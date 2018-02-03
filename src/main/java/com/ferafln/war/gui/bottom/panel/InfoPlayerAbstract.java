/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom.panel;

import com.ferafln.war.gui.bottom.PlayerPanel;
import javax.swing.JPanel;

/**
 *
 * @author feraf
 */
public abstract class InfoPlayerAbstract extends JPanel {
    private PlayerPanel playerPanel;

    public InfoPlayerAbstract(PlayerPanel playerPanel) {
        this.playerPanel = playerPanel;
        this.setBounds(250, 150, 220, 100);
    }

    public PlayerPanel getPlayerPanel() {
        return playerPanel;
    }

    
    public abstract void update();
    
    
}
