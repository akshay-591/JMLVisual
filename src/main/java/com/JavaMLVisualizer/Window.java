package com.JavaMLVisualizer;

import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is Class Contains Method Which Will Design the Java Swing Window
 */
public class Window extends JFrame implements ActionListener {

    // Constructor
    JMenuBar createMenu(){
        // Creating Menu Bar
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        bar.add(file);
        bar.add(edit);
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener((ActionListener) this);
        file.add(saveItem);
        return bar;
    }

    /**
     * This Method put the chart object in the chart panel and that panel in the Jframe.
     *
     * @param chart is the object of jfree chart
     * @param windowLabel is a String Which is Title of the Window.
     */


    void showFrame(Visual chart, String windowLabel){
        JPanel newPanel = new ChartPanel(chart);

        JMenuBar bar = createMenu();

        this.setLayout(new BorderLayout());

        this.add("North", bar);
        this.add("Center", newPanel);

        this.pack();
        this.setTitle(windowLabel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This Method is a used for Menu Bar Item Listener
     * @param e parameter which can tell us button or menu option details
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
        System.out.println("Button Clicked"); // Checking if button is working or not

    }
}

