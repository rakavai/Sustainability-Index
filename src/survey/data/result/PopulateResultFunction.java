/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.result;

import common.CustomFunction;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import survey.data.QuestionsObject;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.SectionVariable;

/**
 *
 * @author rakib
 */
public class PopulateResultFunction {

    /*
     * Common class
     */
    public static QuestionStat getQuestionStat(SectionObject section) {
        int yes = 0, no = 0, notApplicable = 0;
        for (QuestionsObject question : section.questions) {
            switch (question.quAnswer) {
                case QuestionsObject.YES:
                    yes++;
                    break;
                case QuestionsObject.NO:
                    no++;
                    break;
                case QuestionsObject.NOT_APPLICABLE:
                    notApplicable++;
                    break;

            }
        }
        return new QuestionStat(yes, no, notApplicable);
    }
    
    public static Map<String,QuestionStat> getQuestionSetList(SectionObject sectorParent){
        Map<String,QuestionStat> toReturn=new HashMap<>();
        for (SectionObject sector : sectorParent.subSection) {
            toReturn.put(sector.sectionKey,getQuestionStat(sector));
        }
        return toReturn;
    }
    /*
     * Energy
     */

    public static Map<String, Double> populateWeightedEnergyPercentage() {
        Map<String, Double> toReturn = new HashMap<>();
        for (Map.Entry<String, Double> entrySet : ResultDataHandler.electriciyPercentage.entrySet()) {
            String key = entrySet.getKey();
            Double electricityPercentage = entrySet.getValue();
            Double gasPercentage = ResultDataHandler.gasPercentage.get(key);
            double weightedPercentage = wightedPercentageEnergy(electricityPercentage, gasPercentage);
            toReturn.put(key, weightedPercentage);
        }
        return toReturn;
    }

    private static double wightedPercentageEnergy(double electricity, double gas) {
        double totalEnergy = ResultDataHandler.annualTotalUsageElectriciy/293 + ResultDataHandler.annualTotalUsageGas;
        double totalSectorEnergy = electricity * ResultDataHandler.annualTotalUsageElectriciy/293
                + gas * ResultDataHandler.annualTotalUsageGas;
        return totalSectorEnergy / totalEnergy;
    }

    /*
     * Wastage 
     */
    public static double populateWeightedWastePercentage() {
        double totalWaste = 0;
        double totalRecycle = 0;
        for (WasteAmountData wasteAmountEach : ResultDataHandler.wasteAmount) {
            totalRecycle += wasteAmountEach.totalWasteAmount * wasteAmountEach.recyclingPercentage;
            totalWaste += wasteAmountEach.totalWasteAmount;
            
        }
        if(totalWaste==0){
            return 0;
        }
        return totalRecycle / totalWaste;
    }

    /*
     * WHS
     */
    public static Map<String, Double> populateWHSpercentage() {
        Map<String, Double> toReturn = new HashMap<>();
        SectionObject whsSection = SectionData.allSection.get(SectionVariable.WHS);
        int totalSubsection = whsSection.subSection.size();
        int totalChoice = CustomFunction.combination(totalSubsection, 2);
        for (SectionObject sector : whsSection.subSection) {
            double percentage = (double)sector.pairComparisonCount / (double)totalChoice * 100;
            toReturn.put(sector.sectionKey, percentage);
        }
        return toReturn;
    }

    /*
     * Energy and WHS
     */
    public static Map<String, Double> questionWeightedPercentage(SectionObject theSection, Map<String, Double> sectorsPercentageSet) {
        Map<String, Double> toReturn = new HashMap<>();
        for (SectionObject sector : theSection.subSection) {
            QuestionStat qs = getQuestionStat(sector);
            double yesPercentage=0;
            if((qs.yes + qs.no)!=0){
                yesPercentage = (double)qs.yes / (double)(qs.yes + qs.no);
            }
            double sectorPercentage = sectorsPercentageSet.get(sector.sectionKey);
            toReturn.put(sector.sectionKey, yesPercentage * sectorPercentage);
        }
        return toReturn;
    }

    //***********************Final Section******************************
    //Energy
    public static double treatEnergySection() {
        double totalIndex = 0;
        Map<String, Double> energyPercentage = PopulateResultFunction.populateWeightedEnergyPercentage();

        ResultDataSet.energySectorsPercentage = energyPercentage;
        ResultDataSet.energySectorsQuestionStat = getQuestionSetList(SectionData.sector(SectionVariable.ENERGY));

        Map<String, Double> sectorWeightedPercentage = PopulateResultFunction.questionWeightedPercentage(SectionData.sector(SectionVariable.ENERGY), energyPercentage);

        ResultDataSet.questionAndPercentage = sectorWeightedPercentage;

        for (Map.Entry<String, Double> sectorPercentage : sectorWeightedPercentage.entrySet()) {
            String key = sectorPercentage.getKey();
            Double percentValue = sectorPercentage.getValue();
            totalIndex += percentValue;
        }
        
        ResultDataSet.energyIndex=totalIndex;
        return totalIndex;
    }

    //Waste
    public static double treatWasteSection() {
        SectionObject waste = SectionData.sector(SectionVariable.WASTE);
        QuestionStat qs = getQuestionStat(waste.subSection.get(0));
        double questionPercentage = (double)qs.yes / (double)(qs.no + qs.yes) * 100;
        double weightedPersentage = populateWeightedWastePercentage();
        double wasteIndex=weightedPersentage*questionPercentage/100;
        ResultDataSet.wasteQStat=qs;
        ResultDataSet.recyclePercentage=weightedPersentage;
        ResultDataSet.wasteIndex=wasteIndex;

        return wasteIndex;
    }

    //WHS
    public static double treatWhsSection() {
        double totalIndex = 0;
        Map<String, Double> whsPercentage = PopulateResultFunction.populateWHSpercentage();
        Map<String, Double> sectorWeightedPercentage = PopulateResultFunction.questionWeightedPercentage(SectionData.sector(SectionVariable.WHS), whsPercentage);
        
        
        for (Map.Entry<String, Double> sectorPercentage : sectorWeightedPercentage.entrySet()) {
            String key = sectorPercentage.getKey();
            Double percentValue = sectorPercentage.getValue();
            totalIndex += percentValue;
        }
        ResultDataSet.whsPercentage=whsPercentage;
        ResultDataSet.whsIndex=totalIndex;
        ResultDataSet.whsSectorsQuestionStat = getQuestionSetList(SectionData.sector(SectionVariable.WHS));
        
        return totalIndex;
    }
    
    public static Map<String, SelectionPercentage> topSectionMap(){
        SectionObject waste=SectionData.sector(SectionVariable.WASTE);
        SectionObject energy=SectionData.sector(SectionVariable.ENERGY);
        SectionObject whs=SectionData.sector(SectionVariable.WHS);
        Map<String, SelectionPercentage> sectionStat=new HashMap<>();
        sectionStat.put(SectionVariable.ENERGY, new SelectionPercentage(ResultDataSet.energyIndex,energy.pairComparisonCount));
        sectionStat.put(SectionVariable.WASTE, new SelectionPercentage(ResultDataSet.wasteIndex,waste.pairComparisonCount));
        sectionStat.put(SectionVariable.WHS, new SelectionPercentage(ResultDataSet.whsIndex,whs.pairComparisonCount));
        ResultDataSet.topSectionStat=sectionStat;
        return sectionStat;
        
    }
    
    public static double overallIndex(){
        Map<String, SelectionPercentage> sectionStat=topSectionMap();
        Map<Integer,Double> selectionValue=new HashMap<>();
        selectionValue.put(2, 50.0);
        selectionValue.put(1, 30.0);
        selectionValue.put(0, 20.0);
        
        Map<Integer,Double> selectionValue2=new HashMap<>();
        double num=(double)1/3*100;
        selectionValue2.put(1, num);
        
        Map<Integer,Double> finalSelection=selectionValue2;
        for (Map.Entry<String, SelectionPercentage> entrySet : sectionStat.entrySet()) {
            String key = entrySet.getKey();
            SelectionPercentage selectionPercentage = entrySet.getValue();
            if(selectionPercentage.selection==2 ||selectionPercentage.selection==0){
                finalSelection=selectionValue;
                break;
            }
        }
        
        double totalWeightedIndex=0;
        ResultDataSet.topSectionPairWisePercentage=new HashMap<>(); 
        for (Map.Entry<String, SelectionPercentage> entrySet : sectionStat.entrySet()) {
            String key = entrySet.getKey();
            SelectionPercentage selectionPercentage = entrySet.getValue();
            selectionPercentage.selectionPercentage=finalSelection.get(selectionPercentage.selection);
            ResultDataSet.topSectionPairWisePercentage.put(key,selectionPercentage);
            totalWeightedIndex+=selectionPercentage.percentage*finalSelection.get(selectionPercentage.selection);
        }
        
        double overallIndex=totalWeightedIndex/100;
        ResultDataSet.sIndex=overallIndex;
        return overallIndex;
    }

}
