/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rakib
 */
public class ResultDataSet {
    public static Map<String, Double> energySectorsPercentage;
    public static Map<String,QuestionStat> energySectorsQuestionStat;
    public static Map<String, Double> questionAndPercentage;
    public static double energyIndex;
    public static QuestionStat wasteQStat;
    public static double recyclePercentage;
    public static Map<String, Double> whsPercentage;
    public static double wasteIndex;
    public static double whsIndex;
    public static Map<String, QuestionStat> whsSectorsQuestionStat;
    public static Map<String, SelectionPercentage> topSectionStat;
    public static double sIndex;
    public static double electricityCfootPrint;
    public static double gasCfootPrint;
    public static double carbonFootPrint;
    public static Map<String,Double> wasteReductionPotential;
    public static double totalWasteReductionPotential;
    public static Map<String, SelectionPercentage> topSectionPairWisePercentage;
    
}
