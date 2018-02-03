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
public class DestWhiteTroops extends Objective{

    public DestWhiteTroops(Tabuleiro tabuleiro) {
        super(tabuleiro,2);
    }

    @Override
    public boolean conquistouObjetivo() throws WarException {
        return destroyTroops();
    }
    
}
