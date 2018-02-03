/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.dado;

import java.util.Comparator;

/**
 *
 * @author feraf
 */
public class DadoComparator implements Comparator<Dice> {

    @Override
    public int compare(Dice o1, Dice o2) {
        return o1.getValorSorteado()> o2.getValorSorteado() ? -1 : 1;
    }

    
    
}
