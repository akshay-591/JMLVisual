package com.JavaMLVisualizer.UI.Frontend;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

import java.awt.*;

/**
 * This class is sub class of JFreeChart class.
 *
 * @author Akshay Kumar on 01-08-2020 at 22:37
 * @package com.JavaMLVisualizer
 * @project ML_Linear com.JavaMLVisualizer.Test.Regression
 **/
public class Visual extends JFreeChart {
    public Visual(Plot plot) {
        super(plot);
    }

    public Visual(String title, Plot plot) {
        super(title, plot);
    }

    public Visual(String title, Font titleFont, Plot plot, boolean createLegend) {
        super(title, titleFont, plot, createLegend);
    }
}
