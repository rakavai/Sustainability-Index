/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import common.Pair;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.result.ResultDataHandler;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.PairwiseComparisionSection;

/**
 *
 * @author rakib
 */
public class PwcUIHandler {

    private PairwiseComparisionSection PWCpanel;
    
    private List<Pair<SectionObject,SectionObject>> pairKeeper;    
    private List<SectionObject> allSectionObject=new ArrayList<>();
    private int now=0;
    
    private String nowOption1;
    private String nowOption2;
    public PwcUIHandler(PairwiseComparisionSection thePanel) {
        PWCpanel=thePanel;
        formThePair();       
        setPairSection();
       
    }   
    
    private void setLabel(){
        UIControllRoom.setTextTopLabel(" Pair Wise Conmparison");
    }
    
    private void formThePair(){        
        for(Map.Entry<String,SectionObject> entry: SectionData.getAllSection().entrySet()){
            allSectionObject.add(entry.getValue());
        }
        pairKeeper=new ArrayList<>();
        for(int i=0;i<allSectionObject.size()-1;i++){
            for(int j=i+1;j<allSectionObject.size();j++){
                pairKeeper.add(new Pair<>(allSectionObject.get(i),allSectionObject.get(j)));
            }
        }
        
    }
    public boolean setPairSection(){
        int max=pairKeeper.size();
        if(now>=max){
          UIControllRoom.questionFrame.theController.loadEnergyProject();
          return false;
        }
        
        PWCpanel.compairOption1.setSelected(false);
        
        
        PWCpanel.compairOption2.setSelected(false);
        
        nowOption1=pairKeeper.get(now).getLeft().sectionKey;
        nowOption2=pairKeeper.get(now).getRight().sectionKey;
        
        PWCpanel.compairOption1.setText(pairKeeper.get(now).getLeft().pairwiseComparisonName);
        PWCpanel.compairOption2.setText(pairKeeper.get(now).getRight().pairwiseComparisonName);
        now++;
        PWCpanel.statusLabel.setText(now+"/"+max);
        
        return true;
    }
    
    
    public void firstOptionClicked(){
        PWCpanel.compairOption1.setSelected(true);
        PWCpanel.compairOption2.setSelected(false);
    }
    
    public void secondOptionClicked(){
        PWCpanel.compairOption1.setSelected(false);
        PWCpanel.compairOption2.setSelected(true);
    }
    
    public void nextClicked(){
        
        if(PWCpanel.compairOption1.isSelected()){
            ResultDataHandler.incrementSectionComparison(nowOption1);
            
        }
        else if(PWCpanel.compairOption2.isSelected())
        {
            ResultDataHandler.incrementSectionComparison(nowOption2);            
        }
        else
        {
            JOptionPane.showMessageDialog(PWCpanel, "Please select an option.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        setPairSection();
        
    }
}
