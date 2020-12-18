package com.JavaMLVisualizer.Window.controller;

import com.JavaMLVisualizer.Window.view.ChartWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * This Class is Item Listener Class for Help Menu Items.
 *
 * @author Akshay Kumar
 */
public class ItemListenersHelp implements ActionListener {

    private static final String ABout_US_URL = "https://github.com/akshay-591/JMLVisual/blob/master/README.md";
    public ItemListenersHelp(){

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        switch (event.getActionCommand()){
            case ChartWindow.HELP_ABOUT_US:
                //open the URL in Default web browser
                Desktop desktop = Desktop.getDesktop();

                try {
                    //create Uniform Resource Identifier by passing the URL
                    URI aboutUSURI = new URI(ItemListenersHelp.ABout_US_URL);

                    //Pass the URI object to browser
                    desktop.browse(aboutUSURI);

                } catch (URISyntaxException  | IOException e ) {
                    e.printStackTrace();
                }
                break;
            case ChartWindow.HELP_VERSION:
                //getVersion();
                break;
            case ChartWindow.HELP_DEPENDENCY_NEEDED:
                //TODO
                break;
            default:
                //Do nothing for Now

        }


    }

   /* private String getVersion() {

        InternetAddress object = new InternetAddress();
        Package objPackage = object.getClass().getPackage();
        //examine the package object
        String name = objPackage.getSpecificationTitle();
        String version = objPackage.getSpecificationVersion();
        //some jars may use 'Implementation Version' entries in the manifest instead
        System.out.println("Package name: " + name);
        System.out.println("Package version: " + version);
    }*/
}

