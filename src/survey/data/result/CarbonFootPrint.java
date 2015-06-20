/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.result;

import java.util.HashMap;
import java.util.Map;
import survey.data.SectionData;
import survey.data.SectionVariable;

/**
 *
 * @author rakib
 */
public class CarbonFootPrint {

    private static double complimentPecentage(Map<String, QuestionStat> question, Map<String, Double> consumptionPercentage) {
        double toReturn = 0;
        for (Map.Entry<String, QuestionStat> entrySet : question.entrySet()) {
            String key = entrySet.getKey();
            QuestionStat eachQ = entrySet.getValue();
            double eachPercent = consumptionPercentage.get(key);
            double questionPercent;
            if ((eachQ.no + eachQ.yes) == 0) {
                questionPercent = 0;
            } else {
                questionPercent = (double) eachQ.yes / (eachQ.no + eachQ.yes);
            }
            double complement = 1 - questionPercent;
            double complementWeight = complement * eachPercent/100;
            toReturn += complementWeight;
        }
        return toReturn;
    }

    private static double getProjectNoPercentage() {
        int projectNo = ResultDataHandler.projectNoForEnergy;
        if (projectNo < 5) {
            return 15;
        } else if (projectNo > 5 && projectNo < 15) {
            return 10;
        } else {
            return 5;
        }
    }

    public static double getCfootPrintElectriciy() {
        double complimentPercent = complimentPecentage(ResultDataSet.energySectorsQuestionStat, ResultDataHandler.electriciyPercentage);
        double consumption = ResultDataHandler.annualTotalUsageElectriciy;
        double constant = SectionVariable.ELECTRIICY_CONSTANT;
        double projectNoPercentage = getProjectNoPercentage() / 100;

        double footPrint = complimentPercent * consumption * constant * projectNoPercentage;
        ResultDataSet.electricityCfootPrint = footPrint;
        return footPrint;
    }

    public static double getCfootPrintGAS() {
        double complimentPercent = complimentPecentage(ResultDataSet.energySectorsQuestionStat, ResultDataHandler.gasPercentage);
        double consumption = ResultDataHandler.annualTotalUsageGas;
        double constant = SectionVariable.GAS_CONSTANT;
        double projectNoPercentage = getProjectNoPercentage() / 100;

        double footPrint = complimentPercent * consumption * constant * projectNoPercentage;
        ResultDataSet.gasCfootPrint = footPrint;
        return footPrint;
    }

    public static double overallEnergyCfootPrint() {
        double overallCarbonFootPrint = getCfootPrintElectriciy() + getCfootPrintGAS();
        ResultDataSet.carbonFootPrint = overallCarbonFootPrint;
        return overallCarbonFootPrint;
    }

    public static double wasteReductionPotential() {
        Map<String, Double> wasteReductionPotential = new HashMap<>();
        double totalWasteReductionPotentaial = 0;
        for (WasteAmountData wasteAmount : ResultDataHandler.wasteAmount) {
            String sector = wasteAmount.wasteSector;
            double totalWasteAmount = wasteAmount.totalWasteAmount;
            double recyclePercentage = wasteAmount.recyclingPercentage;
            double constant = SectionData.sector(SectionVariable.WASTE).subSectionHolderWithConstant.get(sector);

            double wasteReductionPotentialPerSection = (1 - recyclePercentage / 100) * totalWasteAmount * constant;

            wasteReductionPotential.put(sector, wasteReductionPotentialPerSection);
            totalWasteReductionPotentaial += wasteReductionPotentialPerSection;
        }
        ResultDataSet.wasteReductionPotential = wasteReductionPotential;
        ResultDataSet.totalWasteReductionPotential = totalWasteReductionPotentaial;

        return totalWasteReductionPotentaial;
    }

}
