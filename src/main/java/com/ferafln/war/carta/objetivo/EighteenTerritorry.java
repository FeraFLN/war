/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.carta.objetivo;

import com.ferafln.war.Player;
import com.ferafln.war.Tabuleiro;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.territorio.Territory;

/**
 *
 * @author feraf
 */
public class EighteenTerritorry extends Objective{

    public EighteenTerritorry(Tabuleiro tabuleiro) {
        super(tabuleiro,12);
    }

    
    @Override
    public boolean conquistouObjetivo() throws WarException {
        Player p = getTabuleiro().getRoundPlayer();
        String[] result = getProp().split(",");
        int value = Integer.parseInt(result[0]);
        int amountTroops = Integer.parseInt(result[1]);
        int counter =0;
        if(p.getTerritorys().size()==value){
            for (Territory t : p.getTerritorys()) {
                if(t.getAmountTroops()>=amountTroops){
                    counter++;
                }
            }
        }
        return counter>=value;
    }
    
}
