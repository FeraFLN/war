/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.utilitarios;

import com.ferafln.war.core.Dado;
import java.io.File;
import java.util.Comparator;

/**
 *
 * @author fernandoneto
 */
public class DadoComparator implements Comparator<Dado> {

    @Override
    public int compare(Dado o1, Dado o2) {
        Integer i1 = new Integer(o1.getValor());
        Integer i2 = new Integer(o2.getValor());
       
        return -i1.compareTo(i2);       
    }
}
