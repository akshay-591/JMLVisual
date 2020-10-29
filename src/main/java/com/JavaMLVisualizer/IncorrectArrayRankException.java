package com.JavaMLVisualizer;

import java.io.IOException;

/**
 * @author Akshay Kumar on 01-08-2020 at 23:50
 * @package com.JavaMLVisualizer
 * @project ML_Linear Regression
 **/
public class IncorrectArrayRankException extends IOException {

    public IncorrectArrayRankException(String message,Throwable err){
        super(message,err);
    }
}
