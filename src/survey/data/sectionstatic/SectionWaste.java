/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.sectionstatic;

import java.util.ArrayList;
import java.util.Arrays;
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
        waste.sectionTitle="Waste Management Questionnaire";
        waste.sectionKey=SectionVariable.WASTE;
        
        String[] sectors={
            "Electronic Waste",
            "Glass Waste",
            "Metal Cleaning Solvent"
        };
        
        waste.subSectionHolder=new ArrayList<>(Arrays.asList(sectors));
    }
}
