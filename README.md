# JMLVisual.
Visualization Library for Machine Learning using Java.
This Library is built upon another Library JfreeCharts which is a Java 2D charts Library. 
JMLVisual is easy to use just Like matplotlib in python, with just few lines of code user can Visualize the Data easily. 
This Library is not just compatible with double[] array but also with Numerical Library Nd4j. Right now it is under Testing and Not ready to use.

For ex- to view scattered charts Just like in Regression..
 
            JML2DPlot plotter = new JML2DPlot();
            plotter.createXYChart(loadData.transpose(),"+"); // using INDArrays object 
            plotter.show();


or to insert more details 


           JML2DPlot plotter = new JML2DPlot();
            plotter.setChartLabel("Regression");
            plotter.setxAxisLabel("Xlabel");
            plotter.setyAxisLabel("Ylabel");
            plotter.setLegend(true);
            plotter.setLegendTitle("Original");
            plotter.setXAxisRange(xMin,xMax);
            plotter.createXYChart(loadData.transpose(),"+");
            plotter.show();

<img src="https://github.com/akshay-591/JMLVisual./blob/master/src/main/java/com/test/ML/Regression/scatt.png">

To Plot more than one data on the single chart

            //Plotting data
            ArrayList<double[][]> list = new ArrayList<>();
            // add original dataset
            list.add(dt);
            // add prediction
            list.add(dt2);
            plotter.setLegend(true);
            plotter.setMultiLegendsTitles("original","Prediction");
            plotter.createMultiDataset(list,"+","/");
            plotter.show();
            
<img src="https://github.com/akshay-591/JMLVisual./blob/master/src/main/java/com/test/ML/Regression/multi.png">
