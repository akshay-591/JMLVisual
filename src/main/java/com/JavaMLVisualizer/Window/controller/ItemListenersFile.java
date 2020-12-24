package com.JavaMLVisualizer.Window.controller;


import com.JavaMLVisualizer.UI.Frontend.Visual;
import com.JavaMLVisualizer.Window.view.ChartWindow;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class Contains Controller Structure of The GUI like Listeners for File Item, Image Processing Method.
 *
 * @author Akshay Kumar.
 */


public class ItemListenersFile extends Component implements ActionListener {
    private Visual chart;
    private final String optionMessage = "File already Exists Do you Want Overwrite the File ?";

    public ItemListenersFile(Visual chart) {
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
            case ChartWindow.FILE_SAVE:

                saveImage("png",new File("Chart.png"));
                break;

            case ChartWindow.FILE_SAVE_AS:
                //This Option Will Open the File Chooser Option and Let the user Select the filePath and format

                // Create File Chooser
                JFileChooser fileChooser = new JFileChooser();
                //set Default Name
                File img = new File("Chart.png");
                fileChooser.setSelectedFile(img);

                // Show Dialog box
                int i = fileChooser.showSaveDialog(null);

                if (i == JFileChooser.APPROVE_OPTION){ // if approve
                    //Check if file Name exists or not
                    if(fileChooser.getSelectedFile().exists()){

                        int returnValue =  JOptionPane.showConfirmDialog(this,optionMessage);
                        // return Value Will be 0 if User will press Yes, 1 if user will press No and 2 if User will press Cancel.
                        switch (returnValue){
                            case 0:  saveImage("png",fileChooser.getSelectedFile());
                                break;
                            case 1:  //TODO
                                break;
                            case 2: // TODO
                                break;
                            default: // Do Nothing


                        }
                    }
                    else {saveImage("png",fileChooser.getSelectedFile());}

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


}
