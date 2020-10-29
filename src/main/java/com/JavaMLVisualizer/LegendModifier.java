package com.JavaMLVisualizer;
import org.jfree.chart.LegendItem;
import java.awt.*;
import java.text.AttributedString;

/**
 * @author Akshay Kumar on 03-08-2020 at 01:36
 * @package com.JavaMLVisualizer
 * @project ML_Linear Regression
 **/
public class LegendModifier extends LegendItem {
    static Color color=null;
    public LegendModifier(String label) {
        super(label);
    }

    public LegendModifier(String label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint) {
        super(label, description, toolTipText, urlText, shape, fillPaint);
    }

    @Override
    public void setFillPaint(Paint paint) {
        super.setFillPaint(paint);
    }

    @Override
    public Paint getFillPaint() {
        System.out.println("getFill paint");
        if (color!=null){
            System.out.println("getFillPaint");
            return color;
        }
        return super.getFillPaint();
    }
}
