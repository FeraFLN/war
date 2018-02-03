/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom.leftpanel;

import com.ferafln.war.gui.bottom.PlayerPanel;
import javax.swing.JPanel;

/**
 *
 * @author feraf
 */
public abstract class LeftPlayerPanelAbstract extends JPanel {
    private PlayerPanel playerPanel;

    public LeftPlayerPanelAbstract(PlayerPanel playerPanel) {
        this.playerPanel = playerPanel;
        this.setBounds(250, 150, 220, 200);
    }

    public PlayerPanel getPlayerPanel() {
        return playerPanel;
    }

    
    public abstract void update();
    
    
}
