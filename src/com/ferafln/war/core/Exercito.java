/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.core;

import com.ferafln.war.enums.CorExercitoEnum;
import javax.swing.ImageIcon;

/**
 *
 * @author fernandoneto
 */
public class Exercito {
    private CorExercitoEnum cor;
    private ImageIcon iconExercito;

    public Exercito(CorExercitoEnum cor) {
        this.cor = cor;
    }

    public Exercito(CorExercitoEnum cor, ImageIcon iconExercito) {
        this.cor = cor;
        this.iconExercito = iconExercito;
    }

    public CorExercitoEnum getCor() {
        return cor;
    }

    public void setCor(CorExercitoEnum cor) {
        this.cor = cor;
    }

    public ImageIcon getIconExercito() {
        return iconExercito;
    }

    public void setIconExercito(ImageIcon iconExercito) {
        this.iconExercito = iconExercito;
    }
    
    
}
