/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.enums;

/**
 *
 * @author fernandoneto
 */
public enum StatusRodadaEnum {
    DISTRIBUIR("Distribuir"),
    DISTRIBUIR_CONT("Distribuir Continente"),
    ATACAR("Atacar"),
    PARAR("Para");
    
    private String valor;
    private StatusRodadaEnum(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
