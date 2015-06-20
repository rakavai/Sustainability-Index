/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rakib
 */
public class QuestionsObject {

    public String quString;
    public Integer quAnswer;
    public String suggestion;

    public Integer getQuAnswer() {
        return quAnswer;
    }

    public void setQuAnswer(Integer quAnswer) {
        this.quAnswer = quAnswer;
    }

    public static final int NOT_ANSWERED = -2;
    public static final int NOT_APPLICABLE = -1;
    public static final int NO = 0;
    public static final int YES = 1;

    public QuestionsObject() {
        this.quAnswer = NOT_ANSWERED;
    }

    public QuestionsObject(String question) {
        this.quString = question;
        this.quAnswer = NOT_ANSWERED;
    }
    public QuestionsObject(String question, String suString) {
        this.quString = question;
        this.quAnswer = NOT_ANSWERED;
        this.suggestion=suString;
    }

    
    public static List<QuestionsObject> asList(String[] strArray) {
        List<QuestionsObject> returnList = new ArrayList<>();
        for (String str : strArray) {
            returnList.add(new QuestionsObject(str));
        }
        return returnList;
    }
    
    public static List<QuestionsObject> asList(String[] quArray,String[] suArray) {
        List<QuestionsObject> returnList = new ArrayList<>();
        int count=0;
        for (String str : quArray) {
            returnList.add(new QuestionsObject(str,suArray[count]));
            count++;
        }
        return returnList;
    }
    
    public static List<QuestionsObject> asList(Map<String, String> questions){
        List<QuestionsObject> returnList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : questions.entrySet()) {
            String question = entrySet.getKey();
            String suggestion = entrySet.getValue();
             returnList.add(new QuestionsObject(question,suggestion));
        }
        return returnList;
    }
    public static List<QuestionsObject> asList(String[][] quAndSu){
        List<QuestionsObject> returnList = new ArrayList<>();
        for (String[] set: quAndSu) {
            String question = set[0];
            String suggestion = set[1];
             returnList.add(new QuestionsObject(question,suggestion));
        }
        return returnList;
    }
}
