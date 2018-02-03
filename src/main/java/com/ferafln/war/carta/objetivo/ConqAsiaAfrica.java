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
public class ConqAsiaAfrica extends Objective{

    public ConqAsiaAfrica(Tabuleiro tabuleiro) {
        super(tabuleiro,4);
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
