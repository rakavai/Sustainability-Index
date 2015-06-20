/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import common.CustomFunction;
import survey.data.QuestionsObject;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.SectionVariable;
import survey.data.result.CarbonFootPrint;
import survey.data.result.PopulateResultFunction;
import survey.data.result.ResultDataSet;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.CarbonFootPrintPanel;
import survey.ui.panel.ShowSuggestion;

/**
 *
 * @author rakib
 */
public class SuggestionController {

    ShowSuggestion mainPanel;

    public SuggestionController(ShowSuggestion mainPanel) {
        this.mainPanel = mainPanel;
        init();
    }

    public void init() {
        UIControllRoom.setTextTopLabel("Suggestions");

        String labelString = "";
        labelString += "<html>";
        labelString += "<u><strong>" + "Energy Section" + "</strong></u>";
        labelString += "<ul>";
        labelString += printSuggestion(SectionVariable.ENERGY);
        labelString += "</ul>";

        labelString += "<u><strong>" + "Waste Management Section" + "</strong></u>";
        labelString += "<ul>";
        labelString += printWasteSuggestion();
        labelString += "</ul>";

        labelString += "<u><strong>" + "Workers Health & Safety" + "</strong></u>";
        labelString += "<ul>";
        labelString += printSuggestion(SectionVariable.WHS);
        labelString += "</ul>";

        labelString += "</html>";

        mainPanel.resultEditor.setText(labelString);
    }

    public String printSuggestion(String key) {
        String toReturn = "";
        
        for (SectionObject eachSection : SectionData.sector(key).subSection) {
            String sectionStr = "";

            for (QuestionsObject qu : eachSection.questions) {
                if (qu.quAnswer == QuestionsObject.NO && qu.suggestion != "") {
                    sectionStr += inLi(qu.suggestion);
                }
            }
            if (sectionStr != "") {
                sectionStr = inUl(sectionStr);
                sectionStr = "<u><strong>" + eachSection.sectionName + "</strong></u>" + sectionStr;

                toReturn += sectionStr;
            }
        }
        
        return toReturn;
    }

    public String printWhsSuggestion() {
        String toReturn = "";
        toReturn += "<li>";
        for (SectionObject eachSection : SectionData.sector(SectionVariable.WHS).subSection) {
            String sectionStr = "";
            for (QuestionsObject qu : eachSection.questions) {
                if (qu.quAnswer == QuestionsObject.NO && qu.suggestion != "") {
                    sectionStr += inLi(qu.suggestion);
                }
            }
            sectionStr = inUl(sectionStr);
            sectionStr = "<u><strong>" + eachSection.sectionName + "</strong></u>" + sectionStr;
            toReturn += sectionStr;
        }
        toReturn += "</li>";
        return toReturn;
    }

    public String printWasteSuggestion() {
        String toReturn = "";
        SectionObject eachSection = SectionData.sector(SectionVariable.WASTE).subSection.get(0);
        String sectionStr = "";
        for (QuestionsObject qu : eachSection.questions) {
            if (qu.quAnswer == QuestionsObject.NO) {
                sectionStr += inLi(qu.suggestion);
            }
        }

        toReturn += sectionStr;

        return toReturn;
    }

    public String inUl(String input) {
        return "<ul>" + input + "</ul>";
    }

    public String inLi(String input) {
        return "<li>" + input + "</li>";
    }
}
