package com.JavaMLVisualizer.Window.view;

import com.JavaMLVisualizer.Window.controller.ItemListeners;
import com.JavaMLVisualizer.UI.Visual;
import org.jfree.chart.ChartPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * This is Class Contains Method Which Will Design the Java Swing Window.
 * 
 * @author Akshay Kumar
 */
    public class ChartWindow extends JFrame {
    private Visual chart;
    private String windowLabel;
    public ChartWindow(Visual chart, String windowLabel){
        this.chart=chart;
        this.windowLabel = windowLabel;
        
        // Initialize window making process
        this.showFrame();
    }


    /**
     * This Method put the chart object in the chart panel and that panel in the Jframe.
     */
    private void showFrame(){
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
        ItemListeners listeners = new ItemListeners(this.chart);
        saveItem.addActionListener((ActionListener) listeners);
        saveAsItem.addActionListener((ActionListener)listeners);

        //adding MenuItem to Menu
        menuFile.add(saveItem);
        menuFile.add(saveAsItem);
        return menuBar;
    }

}

