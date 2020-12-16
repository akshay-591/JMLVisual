package com.JavaMLVisualizer.Window.controller;


import com.JavaMLVisualizer.UI.Visual;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class Contains Controller Structure of The GUI like Listeners, Image Processing Method.
 *
 * @author Akshay Kumar.
 */
public class ItemListeners extends Component implements ActionListener {
    private Visual chart;

    public ItemListeners(Visual chart) {
        this.chart = chart;
    }


    /**
     * This Method is a used for Menu Bar Item Listener
     * @param event parameter which can tell us button or menu option details
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        //Creating Switch Case for Different Menu Items
        switch (event.getActionCommand()){
            case "Save":
                saveImage("png",new File("Chart.png"));
                break;

            case "SaveAs":
                //This Option Will Open the File Chooser Option and Let the user Select the filePath and format

                // Create File Chooser
                JFileChooser fileChooser = new JFileChooser();
                //set Default Name
                fileChooser.setSelectedFile(new File("Chart.png"));


                // Show Dialog box
                int i = fileChooser.showSaveDialog(null);

                if (i == JFileChooser.APPROVE_OPTION){ // if approve
                 saveImage("png",fileChooser.getSelectedFile());
                }

                break;
            default:
                //Do Nothing for Now
        }

    }


    /**
     * This Method will Extract the Image from JfreeChart Object and create and Save the Image
     * @param imageFormat format of the Image Like png or jpeg
     * @param imageFile file Name
     */

    private void saveImage(String imageFormat, File imageFile){

        // get Image Data from The Chart
        BufferedImage chartImage = this.chart.createBufferedImage(1280,720);

        // write the data from chartImage to Image File
        try {
            // Write Image Data into Bytes in outputStream Object
            ImageIO.write(chartImage, imageFormat, imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This Method will ask user to Change the Name of the File if its already Exist
     * @return Name of the File selected by user as String
     */
    private String changeName(){
        //TODO

        return null;
    }

}