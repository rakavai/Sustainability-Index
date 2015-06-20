/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import common.CustomFunction;
import survey.data.result.CarbonFootPrint;
import survey.data.result.PopulateResultFunction;
import survey.data.result.ResultDataSet;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.CarbonFootPrintPanel;

/**
 *
 * @author rakib
 */
public class CarbonFootPrintController {
    CarbonFootPrintPanel mainPanel;

    public CarbonFootPrintController(CarbonFootPrintPanel mainPanel) {
        this.mainPanel = mainPanel;
        init();
    }
    
    public void init(){
        UIControllRoom.setTextTopLabel("Carbon Footprint Reduction Potential");
        
        CarbonFootPrint.overallEnergyCfootPrint();
        CarbonFootPrint.wasteReductionPotential();
        String labelString="";
        labelString+="<html>";
        labelString+="<br>";
        labelString+="<br>";
        labelString+="Carbon Footprint Reduction Potential for Energy Efficiency: ";
        labelString+=CustomFunction.toTwoDecimal(ResultDataSet.carbonFootPrint)+" lbs CO<sub>2</sub><br>";
        
        labelString+="<br>";
        labelString+=" Carbon Footprint Reduction Potential for Waste Management: ";
        labelString+=CustomFunction.toTwoDecimal(ResultDataSet.totalWasteReductionPotential)+" lbs CO<sub>2</sub><br>";
        
        labelString+="</html>";
        
        mainPanel.resultEditor.setText(labelString);
    }

    public void ShowSuggestion() {
        UIControllRoom.qC().loadSuggestion();
    }
}
