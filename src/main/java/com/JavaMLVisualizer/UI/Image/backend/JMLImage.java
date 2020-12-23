package com.JavaMLVisualizer.UI.Image.backend;

import com.JavaMLVisualizer.Window.view.ChartWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Akshay Kumar
 */
public class JMLImage extends JPanel {


    private BufferedImage[] bufferedImages;

    private int initialX=0;
    private int initialY = 0;
    private int gapX = 0;
    private int gapY = 0;
    private int[] imageWidth;
    private int[] imageHeight;

    private String windowLabel;


    /**
     * This Method will set the X coordinate of the Origin to the given Input.
     * @param initialX int value.
     */
    public void setInitialX(int initialX) {
        this.initialX = initialX;
    }

    /**
     * This Method will set the Origin Y to the new Value.
     * @param initialY int Value.
     */
    public void setInitialY(int initialY){
        this.initialY = initialY;
    }

    /**
     * The Method will take the Single or Multiple image input as File object
     * @param file File Object containing Image Path.
     */
    public void setImage(File...file){
        this.bufferedImages = new BufferedImage[file.length];
        try{
            int i =0;
            for (File f:file) {

                this.bufferedImages[i] = ImageIO.read(f);
                i++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This Method will set the new width of The Image or Images in X direction.
     * @param width width of the image in X direction
     */
    public void setImageWidth(int...width){
        this.imageWidth = new int[width.length];
        int j = 0;
        for (int i : width){
            this.imageWidth[j] = i;
            j++;
        }

    }

    /**
     * This Method will set the Height of an Image of Images in Y direction.
     * @param heights height of the Image or Images.
     */
    public void setImageHeights(int...heights){
        this.imageHeight = new int[heights.length];
        int j = 0;
        for (int i : heights){
            this.imageHeight[j] = i;
            j++;
        }
    }

    /**
     * if User wants to show Multiple Images he can choose the gap between the images by default gap is 0.
     * @param gapX gap Value in X Direction.
     * @param gapY gap value in Y Direction.
     */
    public void setGapBetweenImages(int gapX, int gapY) {
        this.gapX = gapX;
        this.gapY = gapY;
    }

    public void setWindowLabel(String label){
        this.windowLabel = label;
    }

    /**
     * This Method will create the Image from BufferedImage object and set its new width and Height if given.
     * @param image image in Buffered Image object
     * @param loopValue image number.
     * @return Image
     */
    private Image createImage(BufferedImage image, int loopValue){
        Image img;

        int w = this.imageWidth.length > loopValue ? this.imageWidth[loopValue]:image.getWidth();
        int h = this.imageHeight.length > loopValue ? this.imageHeight[loopValue]:image.getHeight();

        img = image.getScaledInstance(w,h,Image.SCALE_DEFAULT);

        return img;

    }

    public void paint(Graphics g){
        Graphics2D imageContainer = (Graphics2D) g;
        int i = 0;
        int oldX = this.initialX;
        int oldY = this.initialY;
        for (BufferedImage img :this.bufferedImages) {

            Image ig =createImage(img, i);
            imageContainer.drawImage(ig, this.initialX,this.initialY, null);
            i++;
            this.initialX = this.initialX+ig.getWidth(null)+this.gapX;


            if (this.initialX >= this.getWidth() || ig.getWidth(null) > (this.getWidth()-initialX)){
                this.initialY = this.initialY+ig.getHeight(null)+this.gapY;
                this.initialX = oldX;
            }

        }
        this.initialX = oldX;
        this.initialY = oldY;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }

    public void showImage(){
        new ChartWindow(this,this.windowLabel);
    }
}
