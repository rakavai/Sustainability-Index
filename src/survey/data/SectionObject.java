/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data;

import common.Pair;
import java.util.List;

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
    public List<String> subSectionHolder;
    public int pairComparisonCount;

    public SectionObject() {
        this.pairComparisonCount = 0;
    }

    public SectionObject(String sectionName, List<QuestionsObject> questions) {
        this.pairComparisonCount = 0;
        this.sectionName = sectionName;
        this.sectionKey = sectionName;
        this.questions = questions;
    }

}
