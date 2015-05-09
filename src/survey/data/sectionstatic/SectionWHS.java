/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.sectionstatic;

import survey.data.SectionObject;
import survey.data.SectionVariable;

/**
 *
 * @author rakib
 */
public class SectionWHS {
    public static SectionObject whs=new SectionObject();
    static{
        whs.sectionName="Workers Health & Safety";
        whs.pairwiseComparisonName="Workers Health & Safety";
        whs.sectionKey=SectionVariable.WHS;
    }
}
