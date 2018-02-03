/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ObjectivePanel.java
 *
 * Created on 23-Jan-2018, 6:13:31 PM
 */
package com.ferafln.war.gui;

import com.ferafln.war.gui.util.PathImagesGUIEnum;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author feraf
 */
public class ObjectivePanel extends javax.swing.JPanel {
    private final ImageIcon map;// = new ImageIcon(System.getProperty("user.dir")+File.separator + "Images" + File.separator + "map.png");

    public ObjectivePanel() {
        this.map =  new ImageIcon(PathImagesGUIEnum.WINDOW_OBJECTIVE.getPath());
        initComponents();
        setBounds(0, 0,265,316);
    }
    /** Creates new form ObjectivePanel */

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(map.getImage(), 0, 0, null);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
