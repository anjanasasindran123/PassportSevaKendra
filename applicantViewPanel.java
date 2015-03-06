/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darshana
 */
public class applicantViewPanel extends javax.swing.JPanel {
    
    int applicationId;
    Connection conn = null;
    Statement stmt = null;
    
    /**
     * Creates new form applicantViewPanel
     */
    public applicantViewPanel(javax.swing.JPanel applView, int applicationId) {
        initComponents();
        this.applicationId = applicationId;
        System.out.println("Hello!" + applicationId);
        int appId = 0;
        String address = null; int addId = 0;
        
        String appName = null, appEmail = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","tina","batman123");
            stmt = conn.createStatement();
            String sql = "CREATE OR REPLACE VIEW applicantView2 AS select applicant_id,applicant_name,add_id,email from applicant where applicant_id="+this.applicationId+";";
            stmt.executeUpdate(sql);
            String sql1 = "Select * from applicantView2;";
            ResultSet rs = stmt.executeQuery(sql1);
            while(rs.next()){
                System.out.println("--------------");
                appId = rs.getInt("applicant_id");
                System.out.println(appId);
                addId = rs.getInt("add_id");
                appName = rs.getString("applicant_name");
                System.out.println(appName);
                appEmail = rs.getString("email"); 
                System.out.println(appEmail);
            }
            String sql2 = "Select * from address where add_id = "+addId;
            ResultSet rs1 = stmt.executeQuery(sql2);
            while(rs1.next()){
                address = rs1.getString("street_add")+", "+rs1.getString("city")+", "+rs1.getString("state")+", "+rs1.getString("country");
            
            }
            appIdText.setText(Integer.toString(appId));
            appNameText.setText(appName);
            appEmailText.setText(appEmail);
            addressText.setText(address);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(applicantViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(applicantViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appInfoLabel = new javax.swing.JLabel();
        appidLabel = new javax.swing.JLabel();
        appnameLabel = new javax.swing.JLabel();
        appAddress = new javax.swing.JLabel();
        appEmail = new javax.swing.JLabel();
        appIdText = new javax.swing.JLabel();
        appNameText = new javax.swing.JLabel();
        appAddressText = new javax.swing.JLabel();
        appEmailText = new javax.swing.JLabel();
        addressText = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        issueLabel = new javax.swing.JLabel();
        checkPassportStatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        appInfoLabel.setForeground(new java.awt.Color(0, 128, 0));
        appInfoLabel.setText("Applicant Information");

        appidLabel.setText("Applicant ID:");

        appnameLabel.setText("Applicant Name:");

        appAddress.setText("Applicant address:");

        appEmail.setText("Applicant email:");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        checkPassportStatus.setText("Check status");
        checkPassportStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPassportStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(appInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(appnameLabel)
                                    .addComponent(appidLabel)
                                    .addComponent(appAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(appEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(51, 51, 51)
                                .addComponent(appAddressText))
                            .addComponent(checkPassportStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appIdText)
                            .addComponent(appNameText)
                            .addComponent(appEmailText)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(issueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(exitButton))))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(appInfoLabel)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appidLabel)
                    .addComponent(appIdText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appnameLabel)
                    .addComponent(appNameText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appEmail)
                    .addComponent(appEmailText))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPassportStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void checkPassportStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPassportStatusActionPerformed
        if( evt.getSource() == checkPassportStatus ){
            try {
                String sql5 = "Select pass_numb from passport where applicant_id="+applicationId+";";
                ResultSet rs = stmt.executeQuery(sql5);
                String sql5Answer = null;
                while(rs.next()){
                    sql5Answer = rs.getString("pass_numb");
                }
                if(sql5Answer == null || sql5Answer == ""){
                    issueLabel.setText("Pending confirmation");
                }
                else{
                    issueLabel.setText("Passport issued");
                }
            } catch (SQLException ex) {
                Logger.getLogger(applicantViewPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_checkPassportStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressText;
    private javax.swing.JLabel appAddress;
    private javax.swing.JLabel appAddressText;
    private javax.swing.JLabel appEmail;
    private javax.swing.JLabel appEmailText;
    private javax.swing.JLabel appIdText;
    private javax.swing.JLabel appInfoLabel;
    private javax.swing.JLabel appNameText;
    private javax.swing.JLabel appidLabel;
    private javax.swing.JLabel appnameLabel;
    private javax.swing.JButton checkPassportStatus;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel issueLabel;
    // End of variables declaration//GEN-END:variables
}
