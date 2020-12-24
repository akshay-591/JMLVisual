package com.JavaMLVisualizer.UI.Backend;

import com.JavaMLVisualizer.UI.Backend.JML2DShapes;
import org.jfree.chart.LegendItem;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.chart.util.ShapeUtils;
import org.jfree.data.xy.XYDataset;
import java.awt.*;
import java.awt.geom.*;

/**
 * This class is a subclass for XYShapeRenderer class and it contains the Methods for modifying the shapes of of the charts.
 *
 * @author Akshay Kumar on 31-07-2020 at 22:57
 * @package com.JavaMLVisualizer
 * @project ML_Linear com.JavaMLVisualizer.Test.Regression
 **/
public class JML2DShapesRenderer extends XYShapeRenderer {
    String wantedShape;
    float length;
    float width;
    Color color=null;
    String label;
    Shape legendShape=null;


     Plotter obj;
    JML2DShapesRenderer(){}

    JML2DShapesRenderer(Plotter obj) {
        this.obj = obj;
    }


    /**
     * this method set the shape and its size for the Renderer and its size
     * @param wantedShape shape user wants
     * @param size1 length
     * @param size2 width
     */
    void setWantedShape(String wantedShape,float size1,float size2) {
        this.wantedShape = wantedShape;
        this.length=size1;
        this.width=size2;
    }

    void setWantedLegendShape(Shape shape){
        this.legendShape=shape;
    }


    /**
     * This method set The color for the shapes.
     * @param color color user wants if null random color will be chosen.
     */
    void setWantedShapeColor(Color color){
        this.color=color;

    }

    /**
     * this a overridden method of super class it return the shape for the renderer
     * @param row series
     * @param column index of the data point in that series
     * @return shape
     */
    @Override
    public Shape getItemShape(int row, int column) {
        Shape shape=this.getShapeUt(row);
        if (shape!=null){return this.getShapeUt(row);}
          return super.getItemShape(row,column);
    }

    /**
     * This method is a overridden method of super class which returns the shape of the Legend
     * @param series series
     * @return Shape same as the Data
     */

    @Override
    public LegendItem getLegendItem(int datasetIndex, int series) {
        Color color =this.color;
        Shape shape =this.legendShape;
        if(this.legendShape==null) {shape = getShapeUt(series);}
        LegendItem item =super.getLegendItem(datasetIndex, series);
        if(shape==null){shape=item.getShape();}
        if(color==null){color= (Color) item.getFillPaint();}


        // return super.getLegendItem(datasetIndex, series);
        return new LegendItem(item.getLabel(),item.getDescription(),item.getToolTipText(),item.getURLText(),
                                          shape,color);
    }

    /**
     * This is a method of super class which returns the color of the shapes for renderer.
     * @param dataset
     * @param series
     * @param item
     * @return
     */
    @Override
    protected Paint getPaint(XYDataset dataset, int series, int item) {
         this.label = (String) dataset.getSeriesKey(series);
        if (this.color!=null){return this.color;}
       return super.getPaint(dataset, series, item);
    }

    /**
     * This method contains the pre defined shapes if enter shape symbol doesn't match it returns null.
     * @param series
     * @return
     */
        Shape getShapeUt(int series) {
        //System.out.println("getShapeUt called\n"+"shape ="+this.wantedShape+" length = "+this.length+" width = "+this.width);
        switch (this.wantedShape) {
            case JML2DShapes.SHAPE_CROSS:
                return ShapeUtils.createDiagonalCross(this.length,this.width);

            //for circle
            case JML2DShapes.SHAPE_CIRCLE:
                break;

            //for plus or "+"
            case JML2DShapes.SHAPE_PlUS:
                return ShapeUtils.createRegularCross(this.length,this.width);
            //for triangleUP or "^"
            case JML2DShapes.SHAPE_TRIANGLEUP:
                return ShapeUtils.createUpTriangle(this.length);

            //for triangleDown or "1"
            case JML2DShapes.SHAPE_TRIANGLEDOWN:
                return ShapeUtils.createDownTriangle(this.length);

            //for Diamond or "D
            case JML2DShapes.SHAPE_DIAMOND:
                return ShapeUtils.createDiamond(this.length);

            case JML2DShapes.SHAPE_NEGATIVE:
                return ShapeUtils.createLineRegion(new Line2D.Float(),100);

            default:
              return null;
        }
        return null;
    }
}




