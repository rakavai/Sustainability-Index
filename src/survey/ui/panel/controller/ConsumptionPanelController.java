/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.SectionVariable;
import survey.data.result.ResultDataHandler;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.ConsumptionPanel;

/**
 *
 * @author rakib
 */
public class ConsumptionPanelController {

    ConsumptionPanel mainPanel;

    public ConsumptionPanelController(ConsumptionPanel aThis) {
        mainPanel = aThis;
        init();
    }

    private void init() {
        DefaultTableModel modelelEctricity = (DefaultTableModel) mainPanel.electricyTable.getModel();
        DefaultTableModel modelelGas = (DefaultTableModel) mainPanel.gasTable.getModel();
        List<SectionObject> theList = SectionData.allSection.get(SectionVariable.ENERGY).subSection;
        for (SectionObject theSection : theList) {
            modelelEctricity.addRow(new Object[]{theSection.sectionKey, ""});
            modelelGas.addRow(new Object[]{theSection.sectionKey, ""});
        }
        mainPanel.errorLabel.setText("");

    }

    public void tableChanged() {

        mainPanel.totalElectriciy.setText(String.valueOf(getElectriciyTotal()));
        mainPanel.totalGas.setText(String.valueOf(getGasTotal()));

    }

    private double getElectriciyTotal() {
        DefaultTableModel modelelElectricity = (DefaultTableModel) mainPanel.electricyTable.getModel();
        Vector electricityVector = modelelElectricity.getDataVector();
        double totalElectricity = 0;
        for (Object electricityVector1 : electricityVector) {
            try {
                double entry = Double.parseDouble((String) ((Vector) electricityVector1).get(1));
                totalElectricity += entry;
            } catch (Exception e) {
            }

        }
        return totalElectricity;
    }

    private double getGasTotal() {
        DefaultTableModel modelelGas = (DefaultTableModel) mainPanel.gasTable.getModel();
        Vector gasVector = modelelGas.getDataVector();
        double totalGas = 0;

        for (Object gasVector1 : gasVector) {
            try {
                String theValue = (String) ((Vector) gasVector1).get(1);
                double entry = Double.parseDouble(theValue);
                totalGas += entry;
            } catch (Exception e) {
            }

        }
        return totalGas;
    }

    public void resetElectricityCellFocus() {
        mainPanel.electricyTable.editCellAt(0, 0);
    }

    public void resetGasCellFocus() {
        mainPanel.gasTable.editCellAt(0, 0);
    }

    private boolean totalUsageElectricyOkay() {
        try {
            Double.parseDouble(mainPanel.totalUsagesElectriciy.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean totalUsageGasOkay() {
        try {
            Double.parseDouble(mainPanel.totalUsageGas.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private double getTotalElectriciyUsage() {
        return Double.parseDouble(mainPanel.totalUsagesElectriciy.getText());
    }

    private double getTotalGasUsage() {
        return Double.parseDouble(mainPanel.totalUsageGas.getText());
    }

    public void okayButton() {
        if (!totalUsageElectricyOkay()) {
            mainPanel.errorLabel.setText("Use a valid number in 'Total Annual Usage' field.");
        } else if (!totalUsageGasOkay()) {
            mainPanel.errorLabel.setText("Use a valid number in 'Total Annual Usage' field.");
        } else if (getElectriciyTotal() != 100) {
            mainPanel.errorLabel.setText("Electricy table's input total is not equal to 100%. Please recheck.");
        } else if (getGasTotal() != 100) {
            mainPanel.errorLabel.setText("Natural Gas table's input total is equal to 100%. Please recheck.");
        } else {
            putAnswer();
            UIControllRoom.qC().loadQuestionPanel();
        }
    }

    private void putAnswer() {
        ResultDataHandler.annualTotalUsageElectriciy = getTotalElectriciyUsage();
        ResultDataHandler.annualTotalUsageGas = getTotalGasUsage();
        putGas();
        putElectricity();
    }

    private void putGas() {
        DefaultTableModel modelelGas = (DefaultTableModel) mainPanel.gasTable.getModel();
        Vector gasVector = modelelGas.getDataVector();
        for (Object gasVector1 : gasVector) {
            String theKey = (String) ((Vector) gasVector1).get(0);
            double entry = 0;
            try {
                String theValue = (String) ((Vector) gasVector1).get(1);
                entry = Double.parseDouble(theValue);

            } catch (Exception e) {
            }
            ResultDataHandler.addGasPercentage(theKey, entry);
        }
    }

    private void putElectricity() {
        DefaultTableModel modelelElectricity = (DefaultTableModel) mainPanel.electricyTable.getModel();
        Vector electricityVector = modelelElectricity.getDataVector();
        for (Object gasVector1 : electricityVector) {
            String theKey = (String) ((Vector) gasVector1).get(0);
            double entry = 0;
            try {
                String theValue = (String) ((Vector) gasVector1).get(1);
                entry = Double.parseDouble(theValue);

            } catch (Exception e) {
            }
            ResultDataHandler.addElectriciyPercentage(theKey, entry);
        }
    }

}
