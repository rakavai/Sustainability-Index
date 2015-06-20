/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.data.sectionstatic;

import java.util.ArrayList;
import survey.data.QuestionsObject;
import survey.data.SectionObject;
import survey.data.SectionVariable;

/**
 *
 * @author rakib
 */
public class SectionWHS {

    public static SectionObject whs = new SectionObject();

    static {
        whs.sectionName = "Workers Health & Safety";
        whs.pairwiseComparisonName = "Workers Health & Safety";
        whs.sectionKey = SectionVariable.WHS;
        whs.sectionTitle = "Workers Health & Safety Questionnaire";
        whs.subSection = new ArrayList<>();

        String[][] cognitiveStr = {
            {
                "Is your company strict about not putting too much work pressure on you?",
                "Do not make compulsory extra hour works for the worker"
            },
            {
                "Have you undertaken a stress risk management in the workplace?",
                "Launch a stress risk management program in the workplace"
            },
            {
                "Does your company discourage work at home after the main job hours?",
                ""
            },
            {
                "Is it easy to take time off during your work to take care of personal or family matters?",
                "Make sure work life balance is tolerable"
            },
            {
                "Are you allowed to change your starting and quitting times on a daily basis?",
                "Allow your workers to have flexible timing"
            }
        };

        whs.subSection.add(new SectionObject("Cognitive", QuestionsObject.asList(cognitiveStr)));

        String[][] postureStr = {
            {
                " In the past 12 months, have you not feel any back pain for a week or more?",
                ""
            },
            {
                "Does your job regularly prevents you to perform repetitive or forceful hand movements or awkward postures?",
                "Try to prevent repetitive posture or forceful hand movements or awkward positioning"
            },
            {
                "Are all the employees restricted to use same equipment continuously for maximum 4 hours per day?",
                "Provide breaks regularly during works"
            }
        };

        whs.subSection.add(new SectionObject("Posture", QuestionsObject.asList(postureStr)));

        String[][] forceStr = {
            {
                "Does your job prevent you to work very fast?",
                "Design work in a way that requires moderate pace"
            },
            {
                "Are there any people who must carry heavy goods or awkward items such as stationary or stock deliveries, drink containers or work equipment with proper measurement?",
                "Form a strong policy so that no one has to carry heavy goods without proper measurement"
            },
            {
                "Does your job prevent you to do repeated lifting, pushing, pulling or bending?",
                "Design works in such a manner so that there is no repeated lifting, pushing or bending"
            },
            {
                "In the past 12 months, have you been injured with your job?",
                ""
            }
        };

        whs.subSection.add(new SectionObject("Force", QuestionsObject.asList(forceStr)));

        String[][] environmentStr = {
            {
                "During the past 30 days, did you not take leave for your poor physical or mental health?",
                ""
            },
            {
                "Are you satisfied that all the dangerous parts of work equipment are adequately guarded?",
                "Properly guard all the dangerous parts of work equipment"
            },
            {
                "Do you have proper protection for noisy environment?",
                "Use proper protection for noisy environment"
            },
            {
                "Is the safety or workers a high priority with management?",
                ""
            },
            {
                "Do you have any strong trade unions to protect your interest?",
                "Facilitate strong trade unions for your employees’ interest"
            },
            {
                "Is there any employee health and safety training?",
                "Provide adequate health and safety training to the employees"
            },
            {
                "Is there any regular maintenance check-up system in your industry?",
                "Practice regular maintenance check-up system for all equipment in the industry"
            }
        };

        whs.subSection.add(new SectionObject("Workstation Environment", QuestionsObject.asList(environmentStr)));

    }
}
