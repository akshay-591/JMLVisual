package NormalTest;

import com.JavaMLVisualizer.UI.JML2DPlot;
import org.nd4j.linalg.api.ndarray.INDArray;

import org.nd4j.linalg.factory.Nd4j;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Akshay Kumar
 */
public class VisualisationTest {



    public static void main(String[] args) {
        //Load Data before Class
        INDArray scatterData, LineData,x,y;

        try {
            scatterData = Nd4j.readNumpy("Data/scatteredData.txt", ",");

            LineData = Nd4j.readNumpy("Data/LineData.txt",",");

            JML2DPlot plotter = new JML2DPlot();
            plotter.setChartLabel("SingleDataIND");
            plotter.setxAxisLabel("X");
            plotter.setyAxisLabel("Y");
            plotter.setLegend(true);
            plotter.setLegendTitle("XY");
            plotter.setWindowLabel("Testing");

            plotter.createXYChart(scatterData.transpose(),"X");
            plotter.show();


            //Checking For MultiData

            // create List of Data
            ArrayList<double[][]> multiData =new ArrayList<>();
            multiData.add(scatterData.transpose().toDoubleMatrix());
            multiData.add(LineData.transpose().toDoubleMatrix());

            plotter.setChartLabel("MultiData");
            plotter.createMultiDataset(multiData,"X","/");
            plotter.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }



    }
}
