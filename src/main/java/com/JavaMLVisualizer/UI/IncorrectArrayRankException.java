package com.JavaMLVisualizer.UI;

import java.io.IOException;

/**
 * @author Akshay Kumar on 01-08-2020 at 23:50
 * @package com.JavaMLVisualizer
 * @project ML_Linear com.JavaMLVisualizer.Test.Regression
 **/
public class IncorrectArrayRankException extends IOException {

    public IncorrectArrayRankException(String message,Throwable err){
        super(message,err);
    }
}
