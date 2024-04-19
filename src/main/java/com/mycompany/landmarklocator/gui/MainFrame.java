/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.landmarklocator.gui;

import com.mycompany.landmarklocator.Demo;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Griffin G.
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLbl = new javax.swing.JLabel();
        lastNameLbl = new javax.swing.JLabel();
        birthMonthLbl = new javax.swing.JLabel();
        birthDayLbl = new javax.swing.JLabel();
        birthYearLbl = new javax.swing.JLabel();
        firstNameTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        birthMonthTxt = new javax.swing.JTextField();
        birthDayTxt = new javax.swing.JTextField();
        birthYearTxt = new javax.swing.JTextField();
        calcBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTxtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Heart Rate Calculator");
        setLocation(new java.awt.Point(100, 100));
        setResizable(false);

        firstNameLbl.setText("First Name");

        lastNameLbl.setText("Last Name");

        birthMonthLbl.setText("Birth month");

        birthDayLbl.setText("Birth day");

        birthYearLbl.setText("Birth year");

        firstNameTxt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        firstNameTxt.setName("firstNameTxt"); // NOI18N

        lastNameTxt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        lastNameTxt.setName("lastNameTxt"); // NOI18N

        birthMonthTxt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        birthMonthTxt.setName("birthMonthTxt"); // NOI18N

        birthDayTxt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        birthDayTxt.setName("birthDayTxt"); // NOI18N

        birthYearTxt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        birthYearTxt.setName("birthYearTxt"); // NOI18N

        calcBtn.setText("Calculate");
        calcBtn.setName("calcBtn"); // NOI18N
        calcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcBtnActionPerformed(evt);
            }
        });

        outputTxtArea.setEditable(false);
        outputTxtArea.setColumns(20);
        outputTxtArea.setRows(5);
        outputTxtArea.setFocusable(false);
        outputTxtArea.setName("outputTxtArea"); // NOI18N
        jScrollPane1.setViewportView(outputTxtArea);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cathedral.jpg"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(calcBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(birthMonthLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(birthDayLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lastNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(birthYearLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthMonthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthYearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLbl)
                            .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLbl)
                            .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthMonthLbl)
                            .addComponent(birthMonthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthDayLbl)
                            .addComponent(birthDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthYearLbl)
                            .addComponent(birthYearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(calcBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcBtnActionPerformed
        try {
            String firstName = firstNameTxt.getText();
            String lastName = lastNameTxt.getText();
            int birthMonth = Integer.parseInt(birthMonthTxt.getText());
            int birthDay = Integer.parseInt(birthDayTxt.getText());
            int birthYear = Integer.parseInt(birthYearTxt.getText());

            HeartRates heartRates = new HeartRates(firstName, lastName, birthMonth, birthDay, birthYear);

            outputTxtArea.setText(String.format(
                """

                --- RESULTS ---
                First name: %s
                Last name: %s
                DOB: %s/%s/%s

                Age: %s
                Max Heart Rate: %s BPM
                Target Heart Rate: %s BPM
                """,
                heartRates.getFirstName(),
                heartRates.getLastName(),
                heartRates.getDobMonth(),
                heartRates.getDobDay(),
                heartRates.getDobYear(),
                heartRates.calcAge(),
                heartRates.calcMaxHeartRate(),
                heartRates.calcTargetHeartRateRange()
            ));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Birth parameters must be numeric!!", e.getClass().toString(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_calcBtnActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        
        try {
            outputTxtArea.setText("Attempting!");
            Demo.detectLandmarks("cathedral.jpg");
        } catch (IOException ex) {
            System.out.println("Failed :(");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthDayLbl;
    private javax.swing.JTextField birthDayTxt;
    private javax.swing.JLabel birthMonthLbl;
    private javax.swing.JTextField birthMonthTxt;
    private javax.swing.JLabel birthYearLbl;
    private javax.swing.JTextField birthYearTxt;
    private javax.swing.JButton calcBtn;
    private javax.swing.JLabel firstNameLbl;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JTextArea outputTxtArea;
    // End of variables declaration//GEN-END:variables
}
