/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.core;

import com.ferafln.war.enums.SimbolosCartaEnum;
import javax.swing.ImageIcon;

/**
 *
 * @author fernandoneto
 */
class CartaTerritorio {
    private ImageIcon carta;
    private Territorio territorio;
    private SimbolosCartaEnum simbolo;

    public CartaTerritorio(ImageIcon carta, Territorio territorio, SimbolosCartaEnum simbolo) {
        this.carta = carta;
        this.territorio = territorio;
        this.simbolo = simbolo;
    }

    public ImageIcon getCarta() {
        return carta;
    }

    public SimbolosCartaEnum getSimbolo() {
        return simbolo;
    }

    public Territorio getTerritorio() {
        return territorio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartaTerritorio other = (CartaTerritorio) obj;
        if (this.simbolo != other.simbolo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.simbolo != null ? this.simbolo.hashCode() : 0);
        return hash;
    }
    
}
