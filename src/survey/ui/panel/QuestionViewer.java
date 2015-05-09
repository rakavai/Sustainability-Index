/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.ui.panel;

import survey.ui.panel.controller.QuestionViewerController;

/**
 *
 * @author rakib
 */
public class QuestionViewer extends javax.swing.JPanel {

    /**
     * Creates new form QuestionViewer
     */
    QuestionViewerController theController;
    public QuestionViewer() {
        initComponents();
        theController=new QuestionViewerController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionText = new javax.swing.JTextArea();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        naButton = new javax.swing.JButton();
        step = new javax.swing.JLabel();

        topLabel.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        topLabel.setText("<HTML><U>1.1 Something</U></HTML>");

        questionText.setEditable(false);
        questionText.setBackground(new java.awt.Color(87, 133, 254));
        questionText.setColumns(20);
        questionText.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        questionText.setForeground(new java.awt.Color(254, 254, 254));
        questionText.setLineWrap(true);
        questionText.setRows(5);
        questionText.setText("Does your plant have more than 80% of T5 or T8 fluorescent or LED light? ");
        questionText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(questionText);

        yesButton.setBackground(new java.awt.Color(203, 255, 184));
        yesButton.setText("Yes");
        yesButton.setOpaque(true);
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        noButton.setBackground(new java.awt.Color(255, 189, 189));
        noButton.setText("No");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        naButton.setBackground(new java.awt.Color(251, 253, 182));
        naButton.setText("Not Applicable");
        naButton.setToolTipText("");
        naButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naButtonActionPerformed(evt);
            }
        });

        step.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        step.setForeground(new java.awt.Color(0, 255, 89));
        step.setText("1/3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(topLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 9, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 763, Short.MAX_VALUE)
                        .addComponent(step)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(naButton, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(naButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(step)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        // TODO add your handling code here:
        theController.yesButton();
    }//GEN-LAST:event_yesButtonActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        // TODO add your handling code here:
        theController.noButton();
    }//GEN-LAST:event_noButtonActionPerformed

    private void naButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naButtonActionPerformed
        // TODO add your handling code here:
        theController.naButton();
    }//GEN-LAST:event_naButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton naButton;
    public javax.swing.JButton noButton;
    public javax.swing.JTextArea questionText;
    public javax.swing.JLabel step;
    public javax.swing.JLabel topLabel;
    public javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
