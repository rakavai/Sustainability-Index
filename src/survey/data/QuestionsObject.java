/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rakib
 */
public class QuestionsObject {

    public String quString;
    public Integer quAnswer;

    public Integer getQuAnswer() {
        return quAnswer;
    }

    public void setQuAnswer(Integer quAnswer) {
        this.quAnswer = quAnswer;
    }

    public final static Integer NOT_ANSWERED = -2;
    public final static Integer NOT_APPLICABLE = -1;
    public final static Integer NO = 0;
    public final static Integer YES = 1;

    public QuestionsObject() {
        this.quAnswer = NOT_ANSWERED;
    }

    public QuestionsObject(String question) {
        this.quString = question;
        this.quAnswer = NOT_ANSWERED;
    }

    
    public static List<QuestionsObject> asList(String[] strArray) {
        List<QuestionsObject> returnList = new ArrayList<>();
        for (String str : strArray) {
            returnList.add(new QuestionsObject(str));
        }
        return returnList;
    }
}
