package com.supernova.geeks.calcpackage;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tony on 1/3/17.
 */

public class Helper {
    public static String division = "&divide;";
    public static String factorial ="1/x"+"<br>"+"n!";
    public static String inverseSin = "sin<sup>-1</sup>"+"<br/>"+"sin";
    public static String inverseCos = "cos<sup>-1</sup>"+"<br/>"+"cos";
    public static String inverseTan = "tan<sup>-1</sup>"+"<br/>"+"tan";
    public static String exponential = "<br/>"+"e<sup>x</sup>"+"<br/>"+"ln";
    public static String tenPowerX = "log<sub>10</sub>"+"<br/>"+"10<sup>x</sup>";
    public static String cubeRoot = "x<sup>3</sup>"+"<br/>"+"3&radic";
    public static String yPowerX = "Y<sup>x</sup>"+"<br/>"+"x&radic";
    public static String xSquare = "x<sup>2</sup>"+"<br/>"+"&radic";
    public static String pi = "e"+"<br/>"+"&pi;";
    public static String point=","+"<br>"+".";
    public static String combination="<sup>n</sup>C<sub>r</sub>"+"<br/>"+"<sup>n</sup>P<sub>r</sub>";
    public static void displayErrorMessage(Context context){
        Toast.makeText(context, "Input field must not be zero", Toast.LENGTH_LONG).show();
    }
    public static boolean isZero(EditText input){
        if(Double.parseDouble(input.getText().toString()) == 0){
            return true;
        }
        return false;
    }
    public static int getTopicId(Bundle bundle, String inputValue){
        int id = 0;
        if( bundle!=null){
            id  = bundle.getInt(inputValue);
        }
        return id;
    }
}

