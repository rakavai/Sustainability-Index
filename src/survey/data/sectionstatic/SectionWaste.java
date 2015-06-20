/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.sectionstatic;

import java.util.ArrayList;
import java.util.Arrays;
import survey.data.QuestionsObject;
import survey.data.SectionObject;
import survey.data.SectionVariable;

/**
 *
 * @author rakib
 */
public class SectionWaste {

    public static SectionObject waste = new SectionObject();

    static {
        waste.sectionName = "Waste Management";
        waste.pairwiseComparisonName = "Waste Management";
        waste.sectionTitle = "Waste Management Questionnaire";
        waste.sectionKey = SectionVariable.WASTE;

        waste.subSection = new ArrayList<>();

        waste.subSectionHolder("Plastic", 2300);
        waste.subSectionHolder("Glass", 2004);
        waste.subSectionHolder("Metal cleaning solvent", 113);
        waste.subSectionHolder("Waste water", 700);
        waste.subSectionHolder("Chemicals", 3400);
        waste.subSectionHolder("Paint", 400);
        waste.subSectionHolder("Waste Sludge", 19510);
        waste.subSectionHolder("Wood Waste", 570);
        waste.subSectionHolder("Scrap Metal", 700);

        String[][] allQuestions = {
            {
                "Do all of your harmful substances labelled and stored properly?",
                "Put labels on all of your harmful substances and store them properly"
            },
            {
                "Do you have any trash pickup program?",
                "Create and maintain a trash pickup program"
            },
            {
                "Is it a companywide initiative?",
                "Make the trash program as a companywide initiative"
            },
            {
                "Do you have single stream wastage collection program?",
                "Establish a single stream wastage collection program"
            },
            {
                "If you generate paint waste, do you dispose the filter in a right way?",
                "Dispose the paint waste and filters in a right way"
            },
            {
                "If you have any scrap metal waste, do you recycle and resale it?",
                "Recycle and resale the scrap metal waste"
            },
            {
                "Do you have proper guideline and methods for electronic waste disposal?",
                "Follow a proper guideline and methods to dispose electronic waste"
            },
            {
                "If you have glass materials in waste, do you have any special treatment for that?",
                "Maintain a special treatment program for the glass material waste"
            },
            {
                "If you have waste water, do you recycle it?",
                "Recycle the waste water"
            },
            {
                "If you do generate wood waste, do you haul it to fuel plant or further end user?",
                "Properly reuse the wood waste"
            },
            {
                "If you generate waste sludge, do you recycle it?",
                "Recycle the waste sludge by balor or some other mechanical equipment"
            },
            {
                "If you have metal cleaning solvents in waste, do you have proper disposable method for cleaning that?",
                "Maintain a proper disposable method for cleaning metal cleaning solvents"
            },
            {
                "Do you use chemicals to prevent scale formation in cooling tower, if you have any?",
                "Properly take care of the chemicals to prevent scale formations in cooling tower"
            },
            {
                "Does your workplace reuse envelopes, print both side of the papers, reusable coffee mugs, rechargeable batteries and battery chargers?",
                "Make policies to reuse the envelopes, print both side of papers, use reusable coffee mugs, rechargeable batteries and battery chargers"
            },
            {
                "Do you pay for the waste water to go sewage?",
                "Pay for the waste water to go before sewage "
            }
        };

        waste.subSection.add(new SectionObject("Waste Management Questionnaire", QuestionsObject.asList(allQuestions)));
    }
}
