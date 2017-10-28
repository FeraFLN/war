/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.enums;

/**
 *
 * @author fernandoneto
 */
public enum CorExercitoEnum {
    AZUL("Azul"),
    AMARELO("Amarelo"),
    PRETO("Preto"),
    BRANCO("Branco"),
    VERDE("Verde"),
    VERMELHO("Vermelho");
    
    private String valor;
    private CorExercitoEnum(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
