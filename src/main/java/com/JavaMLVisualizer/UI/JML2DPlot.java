

package com.JavaMLVisualizer.UI;
import com.JavaMLVisualizer.Window.view.ChartWindow;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.nd4j.linalg.api.ndarray.INDArray;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


/** This class Contains the Methods for Visualizing the Data on Charts and manipulating its settings for 2D only.
 * Before using this Class Make sure you have jfree chart and nd4j library in your program or as dependency
 * if you are using maven.
 *
 *
 * @author Akshay Kumar on 30-07-2020 at 17:09
 * @package com.JavaMLVisualizer
 * @project ML_Linear com.JavaMLVisualizer.Test.Regression
 **/
public class JML2DPlot {
    //Chart object
    Visual chart;
    //X and Y axis range variable
    double xMin=0;
    double xMax=0;
    double yMin=0;
    double yMax=0;


     /*
    some Global Variable used by all the methods.
     */

    String chartLabel = "";
    String windowLabel = "";
    String xAxisLabel="";
    String yAxisLabel="";
    PlotOrientation orientation = PlotOrientation.VERTICAL;
    String legendTitle = null;
    String[] legendsTitles = null;
    Shape legendShape =null;
    boolean legend = false;
    boolean tooltips = false;
    boolean urls =false;


    //Constants for orientation
    public final static String orientationVertical = "Vertical";
    public final static String orientationHorizontal = "Horizontal";


    /**
     * Set the Chart title by default it an empty string.
     *
     * @param chartLabel is String.
     */
    public void setChartLabel(String chartLabel) {
        this.chartLabel = chartLabel;
    }

    /**
     * This Method is used to set up window Labels
     * @param windowLabel is String
     */

    public void setWindowLabel(String windowLabel){this.windowLabel = windowLabel;}

    /**
     * Set the X AxisLabel by default it is an empty String.
     *
     * @param xAxisLabel is String
     */
    public void setxAxisLabel(String xAxisLabel) {
        this.xAxisLabel = xAxisLabel;
    }

    /**
     * Set the Y Axis Label by default it is an empty String.
     *
     * @param yAxisLabel
     */
    public void setyAxisLabel(String yAxisLabel) {
        this.yAxisLabel = yAxisLabel;
    }

    /**
     * Set the Visibility of the Legends.By default it is false means off.
     *
     * @param legend is boolean.
     */

    public void setLegend(boolean legend) {
        this.legend = legend;
    }


    public void setLegendShape(Shape legendShape) {
        this.legendShape = legendShape;
    }

    /**
     * This Methods is used to set the single legends Title for the Charts.Before using it turn the legends on(true)
     * using setLegend() method.
     * @param legendTitle is String object containing legends title name.
     */
    public void setLegendTitle(String legendTitle) {
        this.legendTitle = legendTitle;
    }

    /**
     * This method is used for setting the legends Titles when user want more than one type of data on chart
     * @param legendsTitles is a String[] object containing array of names.
     */
    public void setMultiLegendsTitles(String... legendsTitles) {
        this.legendsTitles = legendsTitles;
    }

    /**
     * Set the Visibility of tooltips. By default it is false means off.
     * @param tooltips is a boolean
     */

    public void setTooltips(boolean tooltips) {
        this.tooltips = tooltips;
    }

    /**
     *
     * @param urls
     */
    public void setUrls(boolean urls) {
        this.urls = urls;
    }

    /**
     * This method set the range of ValueAxis X  or also known as Range.
     * @param xMin minimum range or minimum value of x dataset
     * @param xMax maximux range of the axis normaly it the max value of x dataset.
     */
    public void setXAxisRange(double xMin, double xMax) {
        this.xMin = xMin;
        this.xMax = xMax;
    }

    /**
     * This method set the the range of ValueAxis Y or also known as the Domain.
     * @param yMin minimum range value.
     * @param yMax maximum range value
     */
    public void setYAxisRange(double yMin,double yMax) {
        this.yMin = yMin;
        this.yMax = yMax;
    }


    /**
     * Set the Orientation of the Chart using Constant defined in the JMLPlot class.By default it orientation is Vertical.
     * Vertical means Your X axis is X and Y axis is Y and Horizontal means Your X axis is Y and Y axis is X.
     *
     * @param orientation is a String but use the predefined constant for sending input.
     */
    public void setOrientation (String orientation){
        switch (orientation){
            case orientationVertical:
                this.orientation = PlotOrientation.VERTICAL;
                break;

            case orientationHorizontal:
                this.orientation = PlotOrientation.HORIZONTAL;
                break;

            default:
                //do nothing
        }

    }

    /**
     * This Method create the XY chart.
     * @param loadDataset is an INDArray object of rank 2.
     * @param shape shape of the Data points. By Default it will draw a line.
     * @throws IncorrectArrayRankException
     */

    public void createXYChart(INDArray loadDataset, String... shape) throws IncorrectArrayRankException {
        //converting INDArray Matrix of rank 2 in double[][] array of rank 2

        double[][] xy = loadDataset.toDoubleMatrix();
        //checking array rank.
        try {
            if(xy.length!=2)
                throw new IOException("Input error");

        }catch (Exception ref){throw new IncorrectArrayRankException("Array Must be of Rank/length of 2. Try passing transpose of INDArray",ref);
        }

        this.createXYChart(xy,shape);
    }

    /**
     *This Method create the XY chart.
     * @param loadDataset is and INDArray Dataset of rank 2.
     * @param shape shape of the Data points. By Default it will draw a line.
     * @param length length of the shape.By default it is 4.
     * @param width width of the shape.By default it is 1.
     * @throws IncorrectArrayRankException
     */
    public void createXYChart(INDArray loadDataset, String shape, float length, float width) throws IncorrectArrayRankException {
        this.createXYChart(loadDataset,shape,length,width,null);

    }

    /**
     *This Method create the XY chart.
     * @param loadDataset is and INDArray Dataset of rank 2.
     * @param shape shape of the Data points. By Default it will draw a line.
     * @param length length of the shape.By default it is 4.
     * @param width width of the shape.By default it is 1.
     * @param color it is object of Color class of Java AWT.
     * @throws IncorrectArrayRankException
     */
    public void createXYChart(INDArray loadDataset, String shape, float length, float width, Color color) throws IncorrectArrayRankException {
        //converting INDArray Matrix of rank 2 in double[][] array of rank 2
        double[][] xy = loadDataset.toDoubleMatrix();
        //checking array rank.
        try {
            if(xy.length!=2)
                throw new IOException("Input error");

        }catch (Exception ref){throw new IncorrectArrayRankException("Array Must be of Rank/length of 2. Try passing transpose of INDArray",ref);
        }

        this.createXYChart(xy,shape,length,width,color);
    }

    /**
     * This Method create XY chart.
     * @param xy is 2D double array of rank 2..
     * @param shape shape of Data.By default it is line.
     */
    public  void createXYChart(double[][] xy, String... shape) throws IncorrectArrayRankException {
        try {
            if(xy.length!=2)
                throw new IOException("Input error");
        }catch (Exception ref){throw new IncorrectArrayRankException("Array Must be of Rank/length of 2",ref);
        }

        this.chart= new Plotter(this).combinedCharts(new CreateDataset(this).createDataset(xy),
                shape,
                new float[]{4},
                new float[]{1},null);
    }

    /**
     *
     * This Method create the XY chart.
     * @param xy is a 2D double array of rank 2.
     * @param shape shape of the Data points. By Default it will draw a line.
     * @param length length of the shape.By default it is 4.
     * @param width width of the shape.By default it is 1.
     * @throws IncorrectArrayRankException
     */
    public  void createXYChart(double[][] xy, String shape, float length, float width) throws IncorrectArrayRankException {
        this.createXYChart(xy,shape,length,width,null);
    }

    /**
     This Method create the XY chart.
     * @param xy is a 2D double array of rank 2.
     * @param shape shape of the Data points. By Default it will draw a line.
     * @param length length of the shape.By default it is 4.
     * @param width  width of the shape.By default it is 1.
     * @param color  colors of Data points.
     * @throws IncorrectArrayRankException
     */
    public  void createXYChart(double[][] xy, String shape, float length, float width, Color color) throws IncorrectArrayRankException {

        try {
            if(xy.length!=2)
                throw new IOException("Input error");
        }catch (Exception ref){throw new IncorrectArrayRankException("Array Must be of Rank/length of 2",ref);
        }

        this.chart= new Plotter(this).combinedCharts(new CreateDataset(this).createDataset(xy),
                                                     new String[]{shape},
                                                     new float[]{length},
                                                     new float[]{width},
                                                                 color);
    }



    /**
     This Method is usefull when user wants to create More than one shape on single Chart.
     * @param dataset is a List of 2D double array of rank 2.
     * @param shapes is an array of shape for respective the Data in the list.By Default it will draw a line.
     * param width width of the shape.By default it is 1.
     */
   public void createMultiDataset(ArrayList<double[][]> dataset, String...shapes) throws IncorrectArrayRankException {



       this.createMultiDataset(dataset,shapes,new float[]{},new float[]{},null);

    }

    /**This Method is usefull when user wants to create More than one shape on single Chart.
     * @param dataset is a List of 2D double array of rank 2.
     * @param shapes is an array of shape for respective the Data in the list.By Default it will draw a line.
     * @param lengths is and float array of lengths for shapes respectively.By default it is 4.
     * @param widths  is an float array of  widths for shapes respectively. by default it is 1.
     */

    public void createMultiDataset(ArrayList<double[][]> dataset, String[] shapes, float[] lengths,float[] widths) throws IncorrectArrayRankException {

        this.createMultiDataset(dataset,shapes,lengths,widths,null);

    }

    /**This Method is usefull when user wants to create More than one shape on single Chart.
     * @param dataset is a List of 2D double array of rank 2.
     * @param shapes is an array of shape for respective the Data in the list.By Default it will draw a line.
     * @param lengths is and float array of lengths for shapes respectively.By default it is 4.
     * @param widths  is an float array of  widths for shapes respectively. by default it is 1.
     * @param colors  is an array of Color object of Java AWT class.
     */

    public void createMultiDataset(ArrayList<double[][]> dataset, String[] shapes, float[] lengths,float[] widths,Color... colors) throws IncorrectArrayRankException {

        double[][] data;
        ArrayList<DefaultXYDataset> xylist = new ArrayList<>();

        for (int i = 0; i < dataset.size(); i++) {

            data = dataset.get(i);
            try {
                if(data.length!=2)
                    throw new IOException("Input error");
            }catch (Exception ref){throw new IncorrectArrayRankException("Array at index "+i+" Must be of Rank/length of 2",ref);
            }
            DefaultXYDataset defaultXYDataset = new DefaultXYDataset();

            if (this.legendsTitles == null || i > (this.legendsTitles.length - 1)) {
                defaultXYDataset.addSeries("Data" + i, data);
            } else {
                defaultXYDataset.addSeries(this.legendsTitles[i], data);
            }

            xylist.add(defaultXYDataset);

        }

        this.chart = new Plotter(this).combinedCharts(xylist, shapes,lengths,widths,colors);

    }

    /**
     *This method return the created chart object
     * @return Visual class object
     */
    public Visual getChart() {
        return chart;
    }

    /**
     *This class initiate chart showing process.
     */
    public void show (){
        new ChartWindow(this.chart,this.windowLabel);
    }


}
