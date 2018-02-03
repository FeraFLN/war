/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom.rightpanel;

import com.ferafln.war.gui.bottom.PlayerPanel;
import javax.swing.JPanel;

/**
 *
 * @author feraf
 */
public abstract class RightPlayerPanelAbstract extends JPanel{
    private PlayerPanel playerPanel;

    public RightPlayerPanelAbstract(PlayerPanel playerPanel) {
        this.playerPanel = playerPanel;
        this.setBounds(560, 150, 220, 90);
    }

    public PlayerPanel getPlayerPanel() {
        return playerPanel;
    }

    
    public abstract void update();
    
    
}
