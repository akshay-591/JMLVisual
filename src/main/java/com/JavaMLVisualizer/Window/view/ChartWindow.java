package com.JavaMLVisualizer.Window.view;

import com.JavaMLVisualizer.Window.controller.ItemListenersFile;
import com.JavaMLVisualizer.UI.Visual;
import com.JavaMLVisualizer.Window.controller.ItemListenersHelp;
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

    // Menu name
    private static final String MENU_FILE = "File";
    private static final String MENU_EDIT = "Edit";
    private static final String MENU_HELP = "Help";

    // Menu Item name
    public static final String FILE_SAVE = "Save";
    public static final String FILE_SAVE_AS = "SaveAS";
    public static final String HELP_ABOUT_US = "About Us";
    public static final String HELP_VERSION = "Version";
    public static final String HELP_DEPENDENCY_NEEDED = "Dependency Needed";

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
        JMenu menuFile = new JMenu(ChartWindow.MENU_FILE);
        JMenu menuEdit = new JMenu(ChartWindow.MENU_EDIT);
        JMenu menuHelp = new JMenu(ChartWindow.MENU_HELP);
        //adding Menus to the bar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuHelp);

        // call fileMenu Item for Creating Menu Items and adding listeners
        fileItem(menuFile);

        // call editItem() for Creating Menu Items and adding listeners
        editItem(menuEdit);

        // call helpItem() for Creating Menu Items and adding listeners
        helpItem(menuHelp);


        return menuBar;
    }

    /**
     * This method is for Creating File Menu Item and creating its Listeners.
     * @param menuFile object reference in which item will be added.
     */
    private void fileItem(JMenu menuFile){
        // Creating Menu Item
        JMenuItem saveItem = new JMenuItem(ChartWindow.FILE_SAVE); // This item when Clicked Save the Image of The chart in Local
        // Directory

        JMenuItem saveAsItem = new JMenuItem(ChartWindow.FILE_SAVE_AS); // This item when Clicked Save the Image of The chart in
        // Chosen Directory

        //Listeners for Item
        ItemListenersFile listeners = new ItemListenersFile(this.chart);
        saveItem.addActionListener((ActionListener) listeners);
        saveAsItem.addActionListener((ActionListener)listeners);

        //adding MenuItem to Menu
        menuFile.add(saveItem);
        menuFile.add(saveAsItem);
    }

    /**
     * This method is for Creating Edit Menu Item and creating its Listeners.
     * @param menuEdit object reference in which item will be added.
     */
    private void editItem(JMenu menuEdit){
        //TODO
    }

    /**
     * This method is for Creating Help Menu Item and creating its Listeners.
     * @param menuHelp object reference in which item will be added.
     */
    private void helpItem(JMenu menuHelp){
        JMenuItem itemAboutUs = new JMenuItem(ChartWindow.HELP_ABOUT_US);
        JMenuItem itemVersion = new JMenuItem(ChartWindow.HELP_VERSION);
        JMenuItem itemDependency = new JMenuItem(ChartWindow.HELP_DEPENDENCY_NEEDED);

        //add Listeners
        ItemListenersHelp listenersHelp = new ItemListenersHelp();
        itemAboutUs.addActionListener((ActionListener) listenersHelp);
        itemDependency.addActionListener((ActionListener) listenersHelp);
        itemVersion.addActionListener((ActionListener) listenersHelp);

        // Add Items to the Menu
        menuHelp.add(itemAboutUs);
        menuHelp.add(itemDependency);
        menuHelp.add(itemVersion);
    }

}

