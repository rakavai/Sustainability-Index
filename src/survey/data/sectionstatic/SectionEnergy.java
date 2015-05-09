/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.sectionstatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import survey.data.*;

/**
 *
 * @author rakib
 */
public class SectionEnergy {

    public static SectionObject energy = new SectionObject();

    static {
        
        energy.sectionName = "Energy";
        energy.pairwiseComparisonName="Energy Usage";
        energy.sectionTitle="Energy Efficiency Questionnaire";
        
        energy.sectionKey=SectionVariable.ENERGY;
                
        energy.subSectionHolder = new ArrayList<>();
        energy.subSectionHolder.add("Electricity");
        energy.subSectionHolder.add("Natural Gas");

        energy.subSection = new ArrayList<>();

        //Question for lightning
        List<String> lightningQuestion = new ArrayList<>();
        //lightningQuestion.add("");
        lightningQuestion.add("Does your plant have more than 80% of T5 or T8 fluorescent or LED light?");
        lightningQuestion.add("Do you use occupancy sensors in your plant/warehouse?");
        lightningQuestion.add("Do you use skylight in your plant?");
        lightningQuestion.add("Do you use dimmer control in your plant?");
        String[] lightningQuestionArray=lightningQuestion.toArray(new String[lightningQuestion.size()]);
        
        energy.subSection.add(new SectionObject("Lightning", QuestionsObject.asList(lightningQuestionArray)));

        //Question for HVAC
        String[] hvacQuestion = {
            "Do you use economizer on the HVAC?",
            "Do you have setback temperature controls during nights & weekends?",
            "Can you set a lower set point of temperature?",
            "Have you checked the dock door seal in last 5 years?"
        };
        energy.subSection.add(new SectionObject("HVAC", QuestionsObject.asList(hvacQuestion)));

        //Question for Steam
        String[] steamQuestion = {
            "Do you have boilers tuning program?",
            "Does air to fuel ratio of your burner stay within 4.0% to 8.0%?",
            "Is the burner in your factory more than 20 years old?"            
        };
        energy.subSection.add(new SectionObject("Steam", QuestionsObject.asList(steamQuestion)));

    }

}
