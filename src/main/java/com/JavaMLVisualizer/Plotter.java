package com.JavaMLVisualizer;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;

import java.awt.*;
import java.util.ArrayList;


/**
 * This class Methods are package protected and only be accessed by the package classes or their method.
 * It contains the methods of Chart preparation and frames.
 *
 * @author Akshay Kumar on 30-07-2020 at 21:28
 * @package com.JavaMLVisualizer
 * @project ML_Linear Regression
 **/
class Plotter {

    private JML2DPlot jmlPlot;

    //Constructor
    Plotter(JML2DPlot plot) {
        this.jmlPlot = plot;

    }


    /**
     * This Method is use for single and Multiple data and shape on single chart.
     * for example for liner regression the best fit line and the original data.
     *
     * @param xylist  array list containing single or multiple DefaultXY Dataset objects
     * @param shapes  array of shapes
     * @param lengths lengths of shapes
     * @param widths  width of shapes
     * @param colors  color of shapes
     * @return Return Visual object which is a subclass of jfree chart
     */

    Visual combinedCharts(ArrayList<DefaultXYDataset> xylist, String[] shapes, float[] lengths, float[] widths, Color... colors) {
        String shape;
        float len;
        float wid;
        Color color = null;
        LegendItemCollection itemCollection = new LegendItemCollection();

        //creating single plot for all data.
        //data can be single or multiple.

        XYPlot plot = new XYPlot();
        DefaultXYDataset defaultXYDataset;

        //Creating domain and range Axis by default they are Number Axis.
        ValueAxis domain1 = new NumberAxis(jmlPlot.xAxisLabel);
        ValueAxis range1 = new NumberAxis(jmlPlot.yAxisLabel);

        //checking minimum and maximum range



        if (jmlPlot.xMin != 0 && jmlPlot.xMax != 0) {
            domain1.setRange(jmlPlot.xMin, jmlPlot.xMax);
        } else {
            domain1.setAutoRange(true);
        }
        if (jmlPlot.yMin != 0 && jmlPlot.yMin != 0) {
            range1.setRange(jmlPlot.yMin, jmlPlot.yMax);
        } else {
            range1.setAutoRange(true);
        }

        //starting loop over ArrayList
        for (int j = 0; j < xylist.size(); j++) {

            //Extracting Dataset from ArrayList
            defaultXYDataset = xylist.get(j);

            //if user does not pass the any shape,color,size by by default it will choose the default case
            // if condition is extracting the shape,color,size so that if out of bound error comes due to either user does not
            // pass the shapes,size,color or number of shapes,size,color are less than the provided data it will feed in the JML2DShapes.SHAPE_LINE String.

            //condition for shape
            shape = !(j > shapes.length - 1) ? shapes[j] : JML2DShapes.SHAPE_LINE;
            color = (colors != null && !(colors.length - 1 < j)) ? colors[j] : null;
            len = lengths.length - 1 < j ? 4 : lengths[j];
            wid = widths.length - 1 < j ? 1 : widths[j];



            /*
             * Cases
             * 1 for Line.
             * 2 for bar
             * default -  for all other shapes
             */

            switch (shape) {
                //for Line or "/"
                case JML2DShapes.SHAPE_LINE:
                    XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer(true, false);
                    //renderer1.setSeriesShape(j,new Rectangle(5,5)); this line is useful when user wants print shapes along the line
                    //renderer1.setSeriesShapesVisible(j,true);
                    if (color != null) {
                        renderer1.setSeriesPaint(j, color);
                    }
                    plot.setDataset(j, defaultXYDataset);
                    plot.setRenderer(j, renderer1);
                    break;
                //for bar or "bar"
                case JML2DShapes.SHAPE_BAR:

                    XYBarRenderer renderer2 = new XYBarRenderer();
                    XYBarDataset xyBarDataset = new XYBarDataset(defaultXYDataset, wid);
                    if (color != null) {
                        renderer2.setSeriesPaint(j, color);
                    }
                    plot.setDataset(j, (IntervalXYDataset) xyBarDataset);
                    plot.setRenderer(j, renderer2);
                    break;
                case JML2DShapes.SHAPE_CIRCLE:
                    XYShapeRenderer renderer3 = new XYShapeRenderer();
                    plot.setDataset(j, defaultXYDataset);
                    plot.setRenderer(j, renderer3);
                    break;

                //for every other shape
                default:
                    this.chartCreator(shape, len, wid, color, plot, j, defaultXYDataset, itemCollection);
                    break;
            }

            plot.setDomainAxis(0, domain1);
            plot.setRangeAxis(0, range1);


        }

        plot.setOrientation(jmlPlot.orientation);
        Visual visual = new Visual(jmlPlot.chartLabel, JFreeChart.DEFAULT_TITLE_FONT, plot, jmlPlot.legend);
        visual.setBackgroundPaint(Color.WHITE);
        visual.getRenderingHints().put(Visual.KEY_SUPPRESS_SHADOW_GENERATION, true);

        return visual;

    }

    /**
     * Common Method containing common code for shape except line and bar
     *
     * @param shape          is shape of the dataset.
     * @param length         length of the shape
     * @param width          width of the shape
     * @param color          color of the shape.
     * @param plot           plot to be put in that data
     * @param index          renderer series.
     * @param set            Dataset which extracted from ArrayList
     * @param itemCollection LegendItemCollection
     */
    void chartCreator(String shape, float length, float width, Color color, XYPlot plot, int index, DefaultXYDataset set, LegendItemCollection itemCollection) {
        //creating new renderer
        JML2DShapesRenderer renderer = new JML2DShapesRenderer();
        //setting new shape and its size if user didn't passed any size by default it is 4 and 1.
        renderer.setWantedShape(shape, length, width);
        //setting color if any passed other wise null will be passed
        renderer.setWantedShapeColor(color);
        renderer.setWantedLegendShape(jmlPlot.legendShape);

        //feeding Dataset in plot
        plot.setDataset(index, set);
        //feeding renderer in plot.
        plot.setRenderer(index, renderer);

    }
}


