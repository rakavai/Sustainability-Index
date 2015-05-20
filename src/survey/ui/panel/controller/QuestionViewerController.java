/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import common.V_;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import survey.data.QuestionsObject;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.SectionVariable;
import survey.data.result.ResultDataHandler;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.QuestionViewer;

/**
 *
 * @author rakib
 */
public class QuestionViewerController {

    private QuestionViewer mainPanel;

    private int currentSector = 0;
    private int currentQuestion = 0;

    public String currentSection = SectionVariable.ENERGY;

    public QuestionViewerController(QuestionViewer mainPanel, String currentSection) {
        this.mainPanel = mainPanel;
        this.currentSection=currentSection;
        init();
    }

    private void init() {
        putItToView(loadNextQuestion());
    }

    private Map<String, String> loadNextQuestion() {
        int maxSector, maxQuestion;
        Map<String, String> toReturn = new HashMap<>();
        SectionObject cSection = SectionData.getAllSection().get(currentSection);
        maxSector = cSection.subSection.size();
        if (currentSector >= maxSector) {
            return null;
        }
        SectionObject cSector = cSection.subSection.get(currentSector);
        maxQuestion = cSector.questions.size();
        if (currentQuestion >= maxQuestion) {
            currentSector++;
            currentQuestion = 0;
            return loadNextQuestion();
        }
        QuestionsObject cQuestionsObject = cSector.questions.get(currentQuestion);

        String stepStr = String.valueOf(currentQuestion + 1) + "/" + String.valueOf(maxQuestion);
        String topTitle = V_.underlineStr("1." + String.valueOf(currentSector + 1) + " " + cSector.sectionName);
        toReturn.put(V_.QUESTION, cQuestionsObject.quString);
        toReturn.put(V_.TOP_TITLE, topTitle);
        toReturn.put(V_.STEP, stepStr);
        currentQuestion++;
        return toReturn;
    }

    private void putItToView(Map<String, String> viewData) {
        mainPanel.questionText.setText(viewData.get(V_.QUESTION));
        mainPanel.topLabel.setText(viewData.get(V_.TOP_TITLE));
        mainPanel.step.setText(viewData.get(V_.STEP));
    }

    private void buttonClicked(int answer) {
        ResultDataHandler.setqSection(currentSection)
                .setqSector(currentSector)
                .setQuestion(currentQuestion - 1)
                .setQuestionAnswer(answer);
        
        //ResultDataHandler.printConsumptionAnswer();
        
        Map<String, String> gottenData = loadNextQuestion();
        if (gottenData != null) {
            putItToView(gottenData);
        } else {
            atLast();
        }
    }
    
    private void atLast(){
        if(currentSection==SectionVariable.ENERGY){
            UIControllRoom.qC().loadWasteAmountPanel();
        }
    }

    public void yesButton() {
        buttonClicked(QuestionsObject.YES);
    }

    public void noButton() {
        buttonClicked(QuestionsObject.NO);
    }

    public void naButton() {
        buttonClicked(QuestionsObject.NOT_APPLICABLE);
    }

}
