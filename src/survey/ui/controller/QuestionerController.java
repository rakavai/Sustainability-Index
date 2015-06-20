/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.controller;

import java.awt.Button;
import java.awt.Component;
import javax.swing.GroupLayout;
import survey.ui.Questioner;
import survey.ui.panel.*;

/**
 *
 * @author rakib
 */
public class QuestionerController {

    private Questioner questionFrame;

    private javax.swing.GroupLayout jPanel1Layout;
    private PairwiseComparisionSection sectionParing=new PairwiseComparisionSection();

    public QuestionerController(Questioner questionFrame) {
        this.questionFrame = questionFrame;
        init();
    }

    private void putContentInPanel(Component o) {
        questionFrame.jPanel1.removeAll();
        jPanel1Layout = new javax.swing.GroupLayout(questionFrame.jPanel1);
        questionFrame.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(o, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(o, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }

    private void init() {
        putContentInPanel(sectionParing);
    }
    
    public void loadEnergyProject(){
        EneregyProjectNoCollector projectNoCollector=new EneregyProjectNoCollector();
        putContentInPanel(projectNoCollector);
    }
    
    public void loadConsumptionPanel(){
        putContentInPanel(new ConsumptionPanel());
    }
    
    public void loadQuestionPanel(String section){
        putContentInPanel(new QuestionViewer(section));
    }
    
    public void loadWasteAmountPanel(){
        putContentInPanel(new WasteAmount());
    }
    
    public void loadPairWiseComparisionWHS(){
        putContentInPanel(new PairWiseComparisonWHS());
    }
    
    public void loadResultViewer(){
        putContentInPanel(new ResultViewer());
    }

    public void loadCarbonFootPrintPanel() {
        putContentInPanel(new CarbonFootPrintPanel());
    }

    public void loadSuggestion() {
        putContentInPanel(new ShowSuggestion());
    }

}
