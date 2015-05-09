/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.controller;

import java.awt.Component;
import survey.ui.FirstStep;
import survey.ui.Questioner;

/**
 *
 * @author rakib
 */
public class UIControllRoom {
    public static FirstStep firstFrame      =new FirstStep();
    public static Questioner questionFrame  =new Questioner();
    
    public static QuestionerController qC(){
        return questionFrame.theController;
    }
    
    public static void setTextTopLabel(String text){
        questionFrame.topLabel.setText(text);
    }
}
