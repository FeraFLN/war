/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.exercito;

import javax.swing.ImageIcon;

/**
 *
 * @author feraf
 */
public class Exercito {
    private ImageIcon imagem;
    private final int id;
    private final String cor;

    public Exercito(int id, String cor) {
        this.id = id;
        this.cor = cor;
    }

   

    public String getCor() {
        return cor;
    }

    public int getId() {
        return id;
    }

   
    public ImageIcon getImagem() {
        return imagem;
    }

    public void setIamgem(ImageIcon iamgem) {
        this.imagem = iamgem;
    }
    
}
