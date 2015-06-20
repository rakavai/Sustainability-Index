/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.sectionstatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import survey.data.*;

/**
 *
 * @author rakib
 */
public class SectionEnergy {

    public static SectionObject energy = new SectionObject();

    static {

        energy.sectionName = "Energy";
        energy.pairwiseComparisonName = "Energy Usage";
        energy.sectionTitle = "Energy Efficiency Questionnaire";

        energy.sectionKey = SectionVariable.ENERGY;

        energy.subSectionHolder = new ArrayList<>();
        energy.subSectionHolder.add("Electricity");
        energy.subSectionHolder.add("Natural Gas");

        energy.subSection = new ArrayList<>();

        //Question for lightning
        Map<String, String> lightningQuestion = new HashMap<>();
        //lightningQuestion.add("");
        lightningQuestion.put("Does your plant have more than 80% of T5 or T8 fluorescent or LED light?",
                "Replace all of your existing bulbs into T5, T8 or LED bulbs");
        lightningQuestion.put("Do you use occupancy sensors in your plant/warehouse?",
                "Use occupancy sensors in your plant/warehouse");
        lightningQuestion.put("Do you use skylight in your plant?",
                "Use skylight in your plant");
        lightningQuestion.put("Do you use dimmer control in your plant?",
                "Use dimmer control for the lights in your plant");

        energy.subSection.add(new SectionObject("Lighting", QuestionsObject.asList(lightningQuestion)));

        //Question for HVAC
        String[][] hvacQuestion = {
            {"Do you use economizer on the HVAC?", "Use economizer on the HVAC"},
            {"Do you have setback temperature controls during nights & weekends?", "Install new generation programmable thermostat to control setback temperature"},
            {"Do you maintain the least possible temperature difference between inside and outside of the plant?", "Try to maintain minimum possible difference of temperature between inside and outside of the plant"},
            {"Have you checked the dock door seal in last 5 years?", "Regularly check dock door seals for leaks"}
        };
        energy.subSection.add(new SectionObject("HVAC", QuestionsObject.asList(hvacQuestion)));

        //Question for Steam
        String[][] steamQuestion = {
            {
                "Do you have boilers tuning program?",
                "Create and practice a boiler tuning program"
            },
            {
                "Do you have steam trap maintenance system?",
                "Create and practice a steam trap maintenance program"
            },
            {
                "Does air to fuel ratio of your burner stay within 4.0% to 6.0%?",
                "Maintain 4.0%- 6.0% air to fuel ratio for your burners"
            },
            {
                "Is the burner in your factory more than 20 years old?",
                "Replace the burners, if they are older than 20 years"
            },
            {
                "Do you use economizer on the boiler?",
                "Use economizer on the boiler"
            },
            {
                "Do you use proper insulation for the boiler surface, pipeline and steam line?",
                "Use proper insulation for the boiler surface, pipeline and steam line"
            },
            {
                "Are you recovering waste heat from boiler stack to produce hot water or heat the plant?",
                "Recover waste heat from boiler stack to produce hot water or heat the plant"
            }
        };
        energy.subSection.add(new SectionObject("Steam", QuestionsObject.asList(steamQuestion)));

        String[][] processHeat = {
            {
                "Do you increase the temperature of raw material by using stack heat for the furnace?",
                "Increase the temperature of raw material by using stack heat for the furnace"
            },
            {
                "Do you use economizer on the process heat?",
                "Use economizer on the process heat"
            }
        };
        energy.subSection.add(new SectionObject("Process Heat", QuestionsObject.asList(processHeat)));
        
        String[][] pumpsAndFan = {
            {
                "Do you have vibration program for the pumps and fans?",
                "Maintain a vibration program for the pumps and fans"
            },
            {
                "If you have a variable working load in pumps and fans, do you use VFD’s on pumps and fans?",
                "Use VFD on pumps and fans if there are variable loads on them. "
            }
        };
        energy.subSection.add(new SectionObject("Pumps & Fans", QuestionsObject.asList(pumpsAndFan)));
        
        String[][] motors = {
            {
                "Do you have a capacitor bank?",
                "Use a capacitor bank, especially if you pay significantly for power factor"
            },
            {
                "Do you have more than 60% of cogged belt in use?",
                "Use cogged belts in all the motors"
            },
            {
                "Do you have vibration program?",
                "Maintain a vibration program for the motors"
            },
            {
                "Do you have motor management system?",
                "Establish a motor management system"
            }
        };
        energy.subSection.add(new SectionObject("Motors", QuestionsObject.asList(motors)));
        
        String[][] compressedAir = {
            {
                "Do you recover the heat from the compressor?",
                "Recover heat from the compressor and use it for comfort heating"
            },
            {
                "Are the compressors running at the lowest possible set pressure?",
                "Reduce the set point of the pressure of the compressor"
            },
            {
                "Do you use sequencer for compressors, if you have multiple main compressor?",
                "Use sequencer for the multiple compressors"
            },
            {
                "Do you use vortex nozzle for cleaning?",
                "Use vortex nozzles instead of regular ones "
            },
            {
                "Do you have air leaks survey routine for your pressure line?",
                "Perform air leaks survey and repair the air leaks regularly"
            }
        };
        energy.subSection.add(new SectionObject("Compressed Air", QuestionsObject.asList(compressedAir)));
        
        String[][] coolingTowers = {
            {
                "Can you set a higher set point for cooling tower/chiller, if you are using that in the plant?",
                "Set a higher temperature point for the cooling tower/chiller"
            }
        };
        energy.subSection.add(new SectionObject("Chillers/Cooling Towers", QuestionsObject.asList(coolingTowers)));
    }

}
