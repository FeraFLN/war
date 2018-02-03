/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom;

import com.ferafln.war.Player;
import com.ferafln.war.Tabuleiro;
import com.ferafln.war.exception.WarException;

/**
 *
 * @author feraf
 */
public class PlayerDisplay implements PlayerPanel{

    private Tabuleiro tabuleiro;

    public PlayerDisplay(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    
     @Override
    public Player getRoundPlayer() {
        return tabuleiro.getRoundPlayer();
    }

    @Override
    public int getRound() {
        return tabuleiro.getRound();
    }

    @Override
    public void nextStep() throws WarException {
        tabuleiro.nextStep();
    }
    
}
