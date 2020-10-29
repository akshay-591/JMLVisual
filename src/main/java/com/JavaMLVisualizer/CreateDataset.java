package com.JavaMLVisualizer;

import org.jfree.data.xy.DefaultXYDataset;

import java.util.ArrayList;

/**
 * This class has  method which contains boiler plate code for creating Datasets.
 * @author Akshay Kumar on 02-08-2020 at 00:22
 * @package com.JavaMLVisualizer
 * @project ML_Linear Regression
 **/
class CreateDataset {
   private JML2DPlot plot;
    CreateDataset (JML2DPlot jml2DPlot){
        this.plot=jml2DPlot;
    }

    ArrayList<DefaultXYDataset> createDataset(double[][] set){
        DefaultXYDataset dataset =new DefaultXYDataset();
        //checking if legendTitle is null the then set it to series1
        if(plot.legendTitle ==null) { plot.legendTitle = "Data 1";}
        //adding data to the DefaultXYDataset object
        dataset.addSeries(plot.legendTitle, set);
        //calling combinedCharts() method of Plotter class
        ArrayList<DefaultXYDataset> list =new ArrayList<>();
        list.add(dataset);
        return list;

    }
}
