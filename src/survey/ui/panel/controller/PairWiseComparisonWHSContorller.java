/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import common.Pair;
import java.util.List;
import javax.swing.JOptionPane;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.SectionVariable;
import survey.data.result.ResultDataHandler;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.PairWiseComparisonWHS;

/**
 *
 * @author rakib
 */
public class PairWiseComparisonWHSContorller {

    PairWiseComparisonWHS mainPanel;
    private List<Pair<?, ?>> pairData;
    private int current = 0;
    private SectionObject currentLeftObject;
    private SectionObject currentRightObject;

    public PairWiseComparisonWHSContorller(PairWiseComparisonWHS mainPanel) {
        this.mainPanel = mainPanel;
        init();
    }

    private void init() {
        UIControllRoom.setTextTopLabel("3.0 Workers Health & Safety Questionnaire");
        formPair();
    }

    private void formPair() {
        SectionObject whs = SectionData.allSection.get(SectionVariable.WHS);
        pairData = Pair.combinePair(whs.subSection);
        setNextPair();
    }

    private void setNextPair() {
        if(current>=pairData.size()){
            UIControllRoom.qC().loadQuestionPanel(SectionVariable.WHS);
            return;
        }
        Pair<?, ?> currentPair = pairData.get(current);
        currentLeftObject  = (SectionObject) currentPair.getLeft();
        currentRightObject = (SectionObject) currentPair.getRight();
        
        mainPanel.optionLeft.setText(currentLeftObject.sectionName);
        mainPanel.optionRight.setText(currentRightObject.sectionName);
        current++;
    }
    
    public void leftOptionClicked(){
        ResultDataHandler.incrementSectionComparisonByRef(currentLeftObject);
        setNextPair();
    }
    
    public void rightOptionClicked(){
        ResultDataHandler.incrementSectionComparisonByRef(currentRightObject);
        setNextPair();
    }

}
