package com.JavaMLVisualizer;

import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements ActionListener {


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
     * @param chart is the object of Jfree chart
     */


    void showFrame(Visual chart){
        JPanel newPanel = new ChartPanel(chart);

        JMenuBar bar = createMenu();

        this.setLayout(new BorderLayout());

        this.add("North", bar);
        this.add("Center", newPanel);

        this.pack();
        this.setTitle("Testing");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");

    }
}

