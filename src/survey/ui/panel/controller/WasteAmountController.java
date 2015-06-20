/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel.controller;

import common.CustomParse;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import survey.data.SectionData;
import survey.data.SectionObject;
import survey.data.SectionVariable;
import survey.data.result.ResultDataHandler;
import survey.ui.controller.UIControllRoom;
import survey.ui.panel.WasteAmount;

/**
 *
 * @author rakib
 */
public class WasteAmountController {

    private WasteAmount mainPanel;

    private SectionObject wasteSection = SectionData.getAllSection().get(SectionVariable.WASTE);

    public WasteAmountController(WasteAmount mainPanel) {
        this.mainPanel = mainPanel;
        init();
    }

    private void init() {
        UIControllRoom.setTextTopLabel(wasteSection.sectionTitle);
        loadTable();
        
    }

    private void loadTable() {
        for (String sectionName : wasteSection.subSectionHolder) {
            getTableModel().addRow(new Object[]{sectionName, "", ""});
        }
    }

    private DefaultTableModel getTableModel() {
        return (DefaultTableModel) mainPanel.wasteTable.getModel();
    }

    public void saveResult(){
        Vector tableData=getTableModel().getDataVector();
        for (Object row : tableData) {
            Vector rowVector=(Vector) row;
            String wasteSector=(String)rowVector.get(0);
            double totalWasteAmount=CustomParse.toDouble(rowVector.get(1));
            double recyclingPercentage=CustomParse.toDouble(rowVector.get(2));
            
            ResultDataHandler.addWasteAmountEachRow(wasteSector, totalWasteAmount, recyclingPercentage);
        }
    }
    
    
    
    public void okayButtonClicked() {
        saveResult();
        UIControllRoom.qC().loadQuestionPanel(SectionVariable.WASTE);
    }

    public void focusLost() {
        mainPanel.wasteTable.editCellAt(0, 0);
    }

}
