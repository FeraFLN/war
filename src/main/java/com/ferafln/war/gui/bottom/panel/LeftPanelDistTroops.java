/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJPanel.java
 *
 * Created on 15-Jan-2018, 7:37:23 PM
 */
package com.ferafln.war.gui.bottom.panel;

import com.ferafln.war.Player;
import com.ferafln.war.gui.FontDefaultGame;
import com.ferafln.war.gui.bottom.PlayerPanel;

/**
 *
 * @author feraf
 */
public class LeftPanelDistTroops extends InfoPlayerAbstract {

    public LeftPanelDistTroops(PlayerPanel playerPanel) {
        super(playerPanel);
        initComponents();
    }

//    public void setRoundPlayer() {
//    }

    /** Creates new form NewJPanel */
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblExtraTroops = new javax.swing.JLabel();
        lblAmountTerritorys = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTroop = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(null);

        lblExtraTroops.setFont(new java.awt.Font("Tahoma", 1, 10));
        lblExtraTroops.setForeground(new java.awt.Color(255, 255, 255));
        lblExtraTroops.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add(lblExtraTroops);
        lblExtraTroops.setBounds(80, 25, 50, 17);

        lblAmountTerritorys.setFont(new FontDefaultGame());
        lblAmountTerritorys.setForeground(new java.awt.Color(255, 255, 255));
        add(lblAmountTerritorys);
        lblAmountTerritorys.setBounds(70, 40, 30, 17);

        jLabel2.setFont(new FontDefaultGame());
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Extra Troops:");
        add(jLabel2);
        jLabel2.setBounds(10, 25, 80, 17);
        add(lblTroop);
        lblTroop.setBounds(50, 10, 13, 17);

        jLabel4.setFont(new FontDefaultGame());
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Color:");
        add(jLabel4);
        jLabel4.setBounds(10, 10, 70, 17);

        jLabel3.setFont(new FontDefaultGame());
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Territorys:");
        add(jLabel3);
        jLabel3.setBounds(10, 40, 70, 17);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAmountTerritorys;
    private javax.swing.JLabel lblExtraTroops;
    private javax.swing.JLabel lblTroop;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        Player playerRound = this.getPlayerPanel().getRoundPlayer();
        lblExtraTroops.setText("" + playerRound.getExtraTroops());
        lblTroop.setIcon(playerRound.getTroop().getImagem());
        lblAmountTerritorys.setText("" + playerRound.getTerritorys().size());
    }
}
