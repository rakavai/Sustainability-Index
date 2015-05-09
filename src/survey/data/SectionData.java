/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data;

import java.util.HashMap;
import java.util.Map;
import survey.data.sectionstatic.*;

/**
 *
 * @author rakib
 */
public class SectionData {
    public static Map<String, SectionObject> allSection=new HashMap<>();
    static{
        allSection.put(SectionVariable.ENERGY, SectionEnergy.energy);
        allSection.put(SectionVariable.WASTE, SectionWaste.waste);
        allSection.put(SectionVariable.WHS, SectionWHS.whs);        
    }
    
    public static Map<String, SectionObject> getAllSection(){
        return allSection;
    }
}
