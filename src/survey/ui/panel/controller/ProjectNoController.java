/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import survey.data.SectionData;
import survey.data.SectionVariable;
import survey.data.result.ResultDataHandler;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.EneregyProjectNoCollector;

/**
 *
 * @author rakib
 */
public class ProjectNoController {
    private EneregyProjectNoCollector mainPanel;
    
    
    public final String LESS_FIVE="Less than 5 projects";
    public final String FIVE_TO_TEN="5-10 projects";
    public final String GREATER_TEN="More than 10 projects";

    public ProjectNoController(EneregyProjectNoCollector mainPanel) {
        this.mainPanel = mainPanel;
        init();
    }
    
    private void init(){
        mainPanel.lessFiveButton.setText(LESS_FIVE);
        mainPanel.fiveTenButton.setText(FIVE_TO_TEN);
        mainPanel.greaterTenButton.setText(GREATER_TEN);
        UIControllRoom.questionFrame.topLabel.setText(" 1.0 "+SectionData.getAllSection().get(SectionVariable.ENERGY).sectionTitle);
    }
    
    public void buttonClicked(String buttonName){
        int projectNo=0;
        if(buttonName.equals(LESS_FIVE)){
            projectNo=3;
        }
        else if(buttonName.equals(FIVE_TO_TEN)){
            projectNo=7;
        }
        else{
            projectNo=13;
        }
        ResultDataHandler.setEnergyProjectNo(projectNo);
        UIControllRoom.questionFrame.theController.loadConsumptionPanel();
        
    }
    
    
}
