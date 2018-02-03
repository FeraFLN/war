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
public class ConqNorthAmericanOceania extends Objective{

    public ConqNorthAmericanOceania(Tabuleiro tabuleiro) {
        super(tabuleiro,8);
    }

    
    @Override
    public boolean conquistouObjetivo() throws WarException {
        Player p = getTabuleiro().getRoundPlayer();
        if(p.getContinents().size()>=2){
            return conqTerritory();
        }
        return false;
    }
    
}
