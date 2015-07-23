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

        String[][] physicalPosture = {
            {
                "Do the employees frequently complain about work-related pain or discomfort (neck, back, upper extremity, etc.) due to physical exertion?",
                "Ensure a policy or mechanism that prevents employees to do physically strenuous job"
            },
            {
                "Are the workstations/work-activities designed to prevent use of sustained awkward postures?",
                "Design a workstation to prevent awkward postures"
            },
            {
                "Are the workstations/work-activities designed to prevent use of forceful arm exertions?",
                "Design the work to eliminate the use of forceful arm exertions"
            },
            {
                "Are the workstations/work-activities designed to prevent use of repetitive or high frequency exertions?",
                "Design workstation to prevent use of repetitive or high frequency exertions"
            },
            {
                "Are the employees prevented from using same equipment/workstation continuously for >= 4 hours per day?",
                "Breakdown work related activities to prevent using same workstation for less than 4 hours per day continuously"
            },
            {
                "Do you have policy that prevents workers from lifting, pushing, pulling heavy loads?",
                "Design a workstation to prevent workers from lifting, pushing, pulling heavy loads"
            },
            {
                "Do you provide annual or bi-annual safety or ergonomics training?",
                "Provide annual or bi annual safety or ergonomics training to all of the employees"
            },
            {
                "Do you have policy that ensures job rotation?",
                "Maintain a policy that ensures job rotation"
            }
        };

        whs.subSection.add(new SectionObject("Physical Posture", QuestionsObject.asList(physicalPosture)));

        String[][] psychosocialAndPsychophysicalExposure = {
            {
                "Do the employees frequently complain about work-related stress due to the social work environment (social support, relationship with supervisor, colleague, etc.)? ",
                "Create a good social work environment in the plant"
            },
            {
                "Do you have policy that encourages/trains the employees on maintaining healthy work-life balance?",
                "Ensure a policy that encourages the employees on maintaining healthy work-life balance"
            },
            {
                "Do you provide annual or bi-annual stress management training?",
                "Provide annual or bi-annual stress management training"
            },
            {
                "Is it easy for the employees to take time off during work to take care of personal or family matters?",
                "Ensure a policy that helps employees to take time off during work for family reasons"
            },
            {
                "Do you have trade union that represent/protect workers interest?",
                "Facilitate trade unions for the employees"
            },
            {
                "Do you have policy that encourages employee participation in day-to-day decision making?",
                "Encourage employee participation in day-to-day decision making"
            },
            {
                "Do you have policy/mechanism (suggestion box, complain box, employee counselling, etc.) that promotes healthy work environment?",
                "Put suggestion box, complain box, and employee counselling that promote healthy work environment"
            },
            {
                "Do you promote regular outings/games/fun activities/team building exercises among employees?",
                "Promote regular outings, games, team building exercises and fun activities among employees"
            }
        };

        whs.subSection.add(new SectionObject("Psychosocial and psychophysical exposure", QuestionsObject.asList(psychosocialAndPsychophysicalExposure)));

        String[][] environmentalExposure = {
            {
                "Do the employees frequently complain about work-related discomfort or stress due to the physical work environment (noise, illumination, climate, etc.)?",
                "Ensure a policy to eliminate work related discomfort due to physical work environment (noise, illumination, climate, etc.)"
            },
            {
                "Do you routinely conduct survey to monitor employees’ noise exposure?",
                "Conduct a routine survey to monitor noise exposure"
            },
            {
                "Do you routinely conduct survey to monitor employees’ vibration exposure?",
                "Conduct a routine survey to monitor vibration exposure"
            },
            {
                "Do you routinely conduct survey to ensure that the workstations/work-activities do not have excessive illumination/glare issues?",
                "Conduct survey to ensure workstations are sufficiently illuminated"
            },
            {
                "Do you provide sufficient sizes/options for all the necessary personal protective equipment (PPE)?",
                "Provide sufficient options for personal protective equipments"
            },
            {
                "Do you have policies to prevent slipping/tripping hazards?",
                "Maintain a policy to prevent slipping hazards"
            },
            {
                "Do you have after work housekeeping policies to ensure that the workstations are maintained neat and clean?",
                "Ensure a policy that encourages neat and clean workstations"
            },
            {
                "Are the mechanical ventilation systems in good condition and regularly maintained so that employees do not get exposed to dust, fumes, and gases?",
                "Provide good mechanical ventilation to prevent exposure from dust, fumes, and gases"
            },
            {
                "Do you have policy that prevents outdoor work under severe weather condition without proper protection?",
                "Ensure a policy that prevents outdoor work without proper protection"
            }
        };

        whs.subSection.add(new SectionObject("Environmental exposure", QuestionsObject.asList(environmentalExposure)));

        String[][] generalPolicy = {
            {
                "Do you maintain emergency response plan?",
                "Maintain an emergency response plan"
            },
            {
                "Do you have a procedure for recording work-related incidents and near misses?",
                "Maintain a procedure for recording work related incidents and near misses"
            },
            {
                "Do you have policy that enforces routine review of all the reported incidents and near misses?",
                "Enforce routine review of all the reported incidents and near misses"
            },
            {
                "Do you routinely provide training on health and safety regulations relevant to your plant?",
                "Provide training on health and safety regulations relevant to your plant"
            },
            {
                "Do you have policy that enforces regular maintenance check-up?",
                "Enforce regular maintenance check-up"
            },
            {
                "Do you have policy that enforces adequate machine guarding?",
                "Enforce adequate machine guarding"
            },
            {
                "Do you have competent persons trained to ensure the safe evacuation of all persons from buildings in the event of serious and unexpected events (fire, cyclone, tornado, etc.)?",
                "Designate a person who will ensure safe evacuation in the event of serious and unexpected events (fire, cyclone, tornado, etc."
            },
            {
                "Do you have policy that enforces adequate machine guarding?",
                "Enforce adequate machine guarding"
            },
            {
                "Do you have policy in place to treat workers in an event of emergency/accident?",
                "Ensure a place to treat the workers in an event of emergency/accident"
            }
        };

        whs.subSection.add(new SectionObject("General Policy", QuestionsObject.asList(generalPolicy)));

    }
}
