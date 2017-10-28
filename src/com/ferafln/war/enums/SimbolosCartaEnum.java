/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.enums;

/**
 *
 * @author fernandoneto
 */
public enum SimbolosCartaEnum {
    TRIANGULO("Triangulo"),
    CIRCULO("Circulo"),
    QUADRADO("Quadrado");
    
    private String valor;
    private SimbolosCartaEnum(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
