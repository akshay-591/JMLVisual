# JMLVisual
Visualization Library for Machine Learning using Java.
This Library is built upon another open source Library JfreeCharts which is a Java 2D charts Library. 
JMLVisual is easy to use just Like matplotlib in python, with just few lines of code user can Visualize the Data easily. 
This Library is not just compatible with double[] array but also with Numerical Library Nd4j. Right now it is under Testing and Not ready to use.

For ex- to view scattered charts Just like in com.JavaMLVisualizer.Test.Regression..
 
            JML2DPlot plotter = new JML2DPlot();
            plotter.createXYChart(loadData.transpose(),"+"); // using INDArrays object 
            plotter.show();


or to insert more details 


           JML2DPlot plotter = new JML2DPlot();
            plotter.setChartLabel("com.JavaMLVisualizer.Test.Regression");
            plotter.setxAxisLabel("Xlabel");
            plotter.setyAxisLabel("Ylabel");
            plotter.setLegend(true);
            plotter.setLegendTitle("Original");
            plotter.setXAxisRange(xMin,xMax);
            plotter.createXYChart(loadData.transpose(),"+");
            plotter.show();

<img src="https://github.com/akshay-591/JMLVisual/blob/master/Pic/Screenshot%20from%202020-12-16%2018-11-42.png">

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
            
<img src="https://github.com/akshay-591/JMLVisual/blob/master/Pic/Screenshot%20from%202020-12-16%2018-12-17.png">

Also User Can Save Chart as Images in png format by going to File--Save which will save the image in Local Dir or File--SaveAs which will save the image in user dir.

<img src = "https://github.com/akshay-591/JMLVisual/blob/master/Pic/chart.png">

Image View is added by using simple code user can show image or multiple Images.

        JMLImage test2 = new JMLImage();
        File file = new File("Data/rubiks_cube.jpg"); 

        test2.setImage(file,file); // set Image or Images

        test2.setImageWidth(300,300); // set Image widths 
        test2.setImageHeights(400,400); // set Image heights

        test2.setGapBetweenImages(100,100); // set the gap between the images from each other and from the origin.

        test2.setInitialX(100); // Set the Origin X
        test2.setInitialY(100); // set the Origin Y

        test2.setWindowLabel("Testing"); // Window label
        test2.showImage(); // show image
        
<img src = "https://github.com/akshay-591/JMLVisual/blob/master/Data/Screenshot%20from%202020-12-23%2022-04-29.png">
