/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import common.CustomFunction;
import java.util.Map;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.SectionVariable;
import survey.data.result.PopulateResultFunction;
import survey.data.result.QuestionStat;
import survey.data.result.ResultDataSet;
import survey.data.result.SelectionPercentage;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.ResultViewer;

/**
 *
 * @author rakib
 */
public class ResultViewerController {

    ResultViewer mainPanel;

    public ResultViewerController(ResultViewer mainPanel) {
        this.mainPanel = mainPanel;
        init();
    }

    public void init() {
        UIControllRoom.setTextTopLabel("Result: Index");
        
        String labelString = "<html>";

        labelString += energySection();
        labelString += wasteSection();
        labelString += whsSection();
        labelString+=overallIndex();
        labelString += "</html>";

        
        mainPanel.resultEditor.setText(labelString);
    }

    public String overallIndex(){
        PopulateResultFunction.overallIndex();
        
        String labelString="<br>";
        labelString+="<hr><hr>";
        labelString += "<u><strong>Sustainability Index</strong></u>";
        labelString+="<br>";
        labelString+="<ul>";
        for (Map.Entry<String, SelectionPercentage> entrySet : ResultDataSet.topSectionPairWisePercentage.entrySet()) {
            String key = entrySet.getKey();
            SelectionPercentage sectionStat = entrySet.getValue();
                labelString+="<li>";
                    labelString+=SectionData.sector(key).sectionName;
                    labelString+="<ul>";
                    labelString+="<li>";
                        labelString+="Recorded Number: ";
                        labelString+=sectionStat.selection;
                    labelString+="</li>";
                    labelString+="<li>";
                        labelString+="Relative Weightage: ";
                        labelString+=CustomFunction.toTwoDecimal(sectionStat.selectionPercentage)+"%";
                    labelString+="</li>";
                    labelString+="</ul>";
                labelString+="</li>";
        }
        labelString+="</ul>";
        labelString+="<strong>";
        labelString+="Sustainability Index: ";
        labelString+=CustomFunction.toTwoDecimal(ResultDataSet.sIndex)+"%";
        labelString+="</strong>";
        labelString+="<br>";
        labelString+="<br>";
        labelString+="<hr><hr>";
        return labelString;
    }
    public String wasteSection() {
        PopulateResultFunction.treatWasteSection();
        String labelString = "";
        labelString += "<u><strong>Waste management Section</strong></u><br>";

        labelString += "Aggregated Recycle Percentage: ";
        labelString += CustomFunction.toTwoDecimal(ResultDataSet.recyclePercentage) + " % <br>";

        labelString += "Recorded Responses: " + questionStatString(ResultDataSet.wasteQStat) + "<br>";

        labelString += "<br>Waste Index: ";
        labelString += CustomFunction.toTwoDecimal(ResultDataSet.wasteIndex) + "%";
        labelString += "<hr><br>";
        return labelString;
    }

    public String whsSection() {
        PopulateResultFunction.treatWhsSection();
        String labelString = "";
        labelString += "<u><strong>Workers’ Health & Safety Section</strong></u><br>";
        for (SectionObject whsSector : SectionData.sector(SectionVariable.WHS).subSection) {
            labelString+="<ul>";
                labelString+="<li>";
                    labelString+=whsSector.sectionName+"<br>";
                    labelString+="<ul>";
                        labelString+="<li>";
                            labelString+="Recorded Number: "+whsSector.pairComparisonCount;
                        labelString+="</li>";
                        
                        labelString+="<li>";
                            labelString+="Recorded Responses: "+questionStatString(ResultDataSet.whsSectorsQuestionStat.get(whsSector.sectionKey)) + "<br>";
                        labelString+="</li>";
                    labelString+="</ul>";
                labelString+="</li>";
            labelString+="</ul>";
        }
        
        
        labelString += "Workers’ Health & Safety Index: ";
        labelString += CustomFunction.toTwoDecimal(PopulateResultFunction.treatWhsSection()) + "%";
       
        return labelString;
    }

    public String energySection() {
        PopulateResultFunction.treatEnergySection();
        String labelString = "";
        labelString += "<u><strong>Energy Efficiency Section</strong></u><br>";
        for (Map.Entry<String, Double> entrySet : ResultDataSet.energySectorsPercentage.entrySet()) {
            String sectionKey = entrySet.getKey();
            Double percent = entrySet.getValue();
            QuestionStat qs = ResultDataSet.energySectorsQuestionStat.get(sectionKey);
            
            labelString+="<ul>";
            labelString+="<li>";
            labelString+=sectionKey+"<br>";
            labelString+="<ul>";
            
            labelString+="<li>";
                labelString+="Percentage: "+ CustomFunction.toTwoDecimal(percent) + "%  ";
            labelString+="</li>";
            
            
            labelString+="<li>";
                labelString+="Recorded Responses: "+questionStatString(qs);
            labelString+="</li>";
            labelString+="</ul>";
             labelString+="</li>";
            labelString+="</ul>";
        }
        labelString += "<br>Energy Efficiency Index: ";
        labelString += CustomFunction.toTwoDecimal(ResultDataSet.energyIndex) + "%";
        labelString += "<hr><br>";
        return labelString;
    }

    private String questionStatString(QuestionStat qs) {
        return "Yes:- " + qs.yes + "; No:- " + qs.no + "; Not Applicable:- " + qs.notApplicable + "";
    }

    public void showCarbon() {
       UIControllRoom.qC().loadCarbonFootPrintPanel();
    }
}
