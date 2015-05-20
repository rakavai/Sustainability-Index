/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.result;

import common.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import survey.data.SectionData;
import survey.data.SectionObject;

/**
 *
 * @author rakib
 */
public class ResultDataHandler {
    
    public static int projectNoForEnergy=0;
    public static double annualTotalUsageElectriciy=0;
    public static double annualTotalUsageGas=0;
    public static Map<String,Double> electriciyPercentage=new HashMap<>();
    public static Map<String,Double> gasPercentage=new HashMap<>();
    public static List<WasteAmountData> wasteAmount=new ArrayList<>();
   
    
    
    
    private static String qSection;
    private static int qSector;

    
    private static int question; 
    
    public static void incrementSectionComparison(String sectionsKey) {
        SectionObject currentObject=SectionData.allSection.get(sectionsKey);
        currentObject.pairComparisonCount++;
    }
    public static void setEnergyProjectNo(int projectNo){
        projectNoForEnergy=projectNo;
    }
    
    public static void addElectriciyPercentage(String key,double value){
        electriciyPercentage.put(key, value);
    }
    
    public static void addGasPercentage(String key,double value){
        gasPercentage.put(key, value);
    }
    
    public static void printConsumptionAnswer(){
        
        System.err.println("Electriciy Annual: "+annualTotalUsageElectriciy);
        
        System.err.println("Gas Annual: "+ annualTotalUsageGas);
        
        System.out.println("Electriciy: ");
        
        System.out.println(electriciyPercentage);
        
        System.out.println("Gas: ");
        System.out.println(gasPercentage);
        System.out.println("************************************");
    }
    
    
    public static ResultDataHandler setqSection(String section){
        ResultDataHandler.qSection=section;
        return null;
    }    
    public static ResultDataHandler setqSector(int qSector) {
        ResultDataHandler.qSector = qSector;
        return null;
    }
    public static ResultDataHandler setQuestion(int question) {
        ResultDataHandler.question = question;
        return null;
    }    
    public static void setQuestionAnswer(int answer){
        SectionData.allSection.get(qSection)
                .subSection.get(qSector)
                .questions.get(question)
                .setQuAnswer(answer);
    }
    
    public static void addWasteAmountEachRow(String wasteSector, double totalWasteAmount, double recyclingPercentage){
        wasteAmount.add(new WasteAmountData(wasteSector, totalWasteAmount, recyclingPercentage));
        
        System.out.println(wasteAmount);
    }
}
