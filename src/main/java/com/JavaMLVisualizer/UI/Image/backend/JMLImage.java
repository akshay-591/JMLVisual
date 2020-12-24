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
    private String[] imageText;

    private int totalImagesWidth = 500;
    private int totalImagesHeight = 500;

    private int numImages;

    // Some Constant
    public static final String DIRECTION_X = "X";
    public static final String DIRECTION_Y = "Y";

    private String imagesDirection = JMLImage.DIRECTION_X;


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
            this.numImages = i+1;
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
        this.totalImagesWidth = 0;
        int j = 0;
        for (int i : width){
            this.imageWidth[j] = i;
            this.totalImagesWidth = this.totalImagesWidth+i;
            j++;
        }

    }

    /**
     * This Method will set the Height of an Image of Images in Y direction.
     * @param heights height of the Image or Images.
     */
    public void setImageHeights(int...heights){
        this.imageHeight = new int[heights.length];
        this.totalImagesHeight = 0;
        int j = 0;
        for (int i : heights){
            this.imageHeight[j] = i;
            this.totalImagesHeight = this.totalImagesHeight+i;
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

    /**
     * This Method will Show the Text on the above the Image.
     * @param imageText Text which user wants to show above Image.
     */
    public void setImageText(String...imageText){
        this.imageText = new String[imageText.length];

        int i = 0;
        for (String text : imageText){
            this.imageText[i] = text;
            i++;
        }
    }


    public void setImagesDirection(String imageDirection){
        this.imagesDirection = imageDirection;
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
        int i = 0; // variable for Array
        int oldX = this.initialX; // cache old origin X
        int oldY = this.initialY; // cache old Origin Y

        for (BufferedImage img :this.bufferedImages) {

            Image ig =createImage(img, i); // create Image from BufferedImage to a Specific Size.

            imageContainer.drawImage(ig, this.initialX,this.initialY, null); // Draw Image


            switch (this.imagesDirection){ // Select in which direction Multiple Images should be drawn.

                case JMLImage.DIRECTION_X: // if user want multiple images growing in X direction
                    this.initialX = this.initialX + ig.getWidth(null) + this.gapX; // set the origin X to the new position for new Image

                    // if there is no space in X Direction below condition will be true and next image will be drawn in
                    // nex line.

                    if (this.initialX >= this.getWidth() || ig.getWidth(null) > (this.getWidth() - this.initialX)) {
                        this.initialY = this.initialY + ig.getHeight(null) + this.gapY;
                        this.initialX = oldX;
                    }
                    break;

                case JMLImage.DIRECTION_Y: // if user want multiple images growing in Y direction
                    this.initialY = this.initialY + ig.getHeight(null)+this.gapY; // set the origin Y to the new position for new Image

                    // if there is no space in Y Direction below condition will be true and next image will be drawn in
                    // nex line.
                    if (this.initialY >= this.getHeight() || ig.getHeight(null) > (this.getHeight()-this.initialY)){
                        this.initialX = this.initialX + ig.getWidth(null) + this.gapX;
                        this.initialY = oldY;
                    }
                    break;

            }
            i++;

        }

        // reset the origin to the original position.
        this.initialX = oldX;
        this.initialY = oldY;
    }

    @Override
    public Dimension getPreferredSize() {

        // return the size equal to number of images cover total area
        return new Dimension(this.totalImagesWidth+(this.gapX*this.numImages)+this.initialX,
                this.totalImagesHeight+(this.gapY*this.numImages)+this.initialY);
    }

    public void showImage(){
        new ChartWindow(this,this.windowLabel);
    }
}
