/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom;

import com.ferafln.war.Player;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.gui.TabuleiroGUI;

/**
 *
 * @author feraf
 */
public class PlayerDisplay implements PlayerPanel{

    private TabuleiroGUI tabuleiroGUI;

    public PlayerDisplay(TabuleiroGUI tabuleiroGUI) {
        this.tabuleiroGUI = tabuleiroGUI;
    }
    
    
     @Override
    public Player getRoundPlayer() {
        return tabuleiroGUI.getTabuleiro().getRoundPlayer();
    }

    @Override
    public int getRound() {
        return tabuleiroGUI.getTabuleiro().getRound();
    }

    @Override
    public void nextStep() throws WarException {
        tabuleiroGUI.getTabuleiro().nextStep();
    }
    
    public void setVisibleObjective(boolean b){
        tabuleiroGUI.setVisibleObjective(b);
    }
    
}
