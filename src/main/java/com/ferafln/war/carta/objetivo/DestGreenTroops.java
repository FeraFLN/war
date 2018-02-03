/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.carta.objetivo;

import com.ferafln.war.Tabuleiro;
import com.ferafln.war.exception.WarException;

/**
 *
 * @author feraf
 */
public class DestGreenTroops extends Objective{

    public DestGreenTroops(Tabuleiro tabuleiro) {
        super(tabuleiro,3);
    }

    @Override
    public boolean conquistouObjetivo() throws WarException {
        return destroyTroops();
    }
    
}
