/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.carta.objetivo;

import com.ferafln.war.Player;
import com.ferafln.war.Tabuleiro;
import com.ferafln.war.exception.WarException;

/**
 *
 * @author feraf
 */
public class TwentyFourTerritorry extends Objective{

    public TwentyFourTerritorry(Tabuleiro tabuleiro) {
        super(tabuleiro,5);
    }

    
    @Override
    public boolean conquistouObjetivo() throws WarException {
        Player p = getTabuleiro().getRoundPlayer();
        int value = Integer.parseInt(getProp());
        return p.getTerritorys().size()==value;
    }
    
}
