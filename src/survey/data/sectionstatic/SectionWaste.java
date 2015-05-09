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
public class SectionWaste {
    public static SectionObject waste=new SectionObject();
    
    static{
        waste.sectionName="Waste Management";
        waste.pairwiseComparisonName="Waste Management";
        waste.sectionKey=SectionVariable.WASTE;
    }
}
