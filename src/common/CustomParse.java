/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author rakib
 */
public class CustomParse {
    public static double toDouble(Object input){
        double toreturn=0;
        try {
            toreturn=Double.parseDouble((String) input);
        } catch (Exception e) {
        }
        return toreturn;
    }
}
