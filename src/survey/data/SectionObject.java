/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data;

import common.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rakib
 */
public class SectionObject {

    public String sectionName;
    public String sectionTitle;

    public String sectionKey;
    public String pairwiseComparisonName;
    public List<SectionObject> subSection;
    public List<QuestionsObject> questions;
    public List<String> subSectionHolder=new ArrayList<>();
    public int pairComparisonCount;
    public double constant;
    public Map<String,Double> subSectionHolderWithConstant=new HashMap<>();
    public SectionObject() {
        this.pairComparisonCount = 0;
    }

    public SectionObject(String sectionName, List<QuestionsObject> questions) {
        this.pairComparisonCount = 0;
        this.sectionName = sectionName;
        this.sectionKey = sectionName;
        this.questions = questions;
    }
    
    public SectionObject(String sectionName, List<QuestionsObject> questions, double constant) {
        this.pairComparisonCount = 0;
        this.sectionName = sectionName;
        this.sectionKey = sectionName;
        this.questions = questions;
        this.constant=constant;
    }
    
    public void subSectionHolder(String holderName, double constant){
        subSectionHolder.add(holderName);
        subSectionHolderWithConstant.put(holderName, constant);
    }

}
