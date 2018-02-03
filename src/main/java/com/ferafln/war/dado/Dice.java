/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.dado;

import java.util.Random;

/**
 *
 * @author feraf
 */
public class Dice {

    private int valorSorteado;

    public Dice() {
        this.sorteiaValor();
    }

    public int getValorSorteado() {
        return valorSorteado;
    }
    
    private void sorteiaValor() {
        Random r = new Random();
        int Low = 1;
        int High = 7;
        this.valorSorteado = r.nextInt(High - Low) + Low;

    }

}
