package com.JavaMLVisualizer;

import org.jfree.chart.ChartPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * This is Class Contains Method Which Will Design the Java Swing Window
 */
   class Window extends JFrame implements ActionListener {
    private Visual chart;
    private String windowLabel;

    Window(Visual chart, String windowLabel){
        this.chart=chart;
        this.windowLabel = windowLabel;
    }


    /**
     * This Method put the chart object in the chart panel and that panel in the Jframe.
     */
    void showFrame(){
        JPanel newPanel = new ChartPanel(this.chart);

        JMenuBar bar = createMenu();

        this.setLayout(new BorderLayout());

        this.add("North", bar);
        this.add("Center", newPanel);

        this.pack();
        this.setTitle(this.windowLabel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This Method will Create Menu bar and items for swing Window.
     * @return JMenuBar
     */
    private JMenuBar createMenu(){
        // Creating Menu Bar
        JMenuBar menuBar = new JMenuBar();
        //Creating Menus
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        //adding Menus to the bar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        // Creating Menu Item
        JMenuItem saveItem = new JMenuItem("Save"); // This item when Clicked Save the Image of The chart in Local
        // Directory

        JMenuItem saveAsItem = new JMenuItem("SaveAs"); // This item when Clicked Save the Image of The chart in
        // Chosen Directory

        //Listeners for Item
        saveItem.addActionListener((ActionListener) this);
        saveAsItem.addActionListener((ActionListener)this);

        //adding MenuItem to Menu
        menuFile.add(saveItem);
        menuFile.add(saveAsItem);
        return menuBar;
    }

    /**
     * This Method is a used for Menu Bar Item Listener
     * @param e parameter which can tell us button or menu option details
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //Creating Switch Case for Different Menu Items
        switch (e.getActionCommand()){
            case "Save":
                saveImage("png","chart");
                break;
            case "SaveAs":
                //Do The SaveAs Item Operation Here
                break;
            default:
                //Do Nothing for Now
        }

    }

    /**
     * This Method will Extract the Image from JfreeChart Object and create and Save the Image
     * @param imageFormat format of the Image Like png or jpeg
     * @param filePath path of the File like Where to save
     */
    private void saveImage(String imageFormat, String filePath){

        // get Image Data from The Chart
        BufferedImage chartImage = this.chart.createBufferedImage(1280,720);

        // write the data from chartImage to Image File
        try {
            // Write Image Data into Bytes in outputStream Object
            File imageFile = new File(filePath+"."+imageFormat);
            if (imageFile.exists()){
                imageFile.renameTo(new File(changeName()));
            }
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

