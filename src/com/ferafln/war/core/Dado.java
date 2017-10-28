/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.core;

import com.ferafln.war.core.exception.DadoException;
import com.ferafln.war.utilitarios.DadoComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernandoneto
 */
public class Dado {
    private List<Dado> dados = new ArrayList<Dado>();
    private int valor;

    public Dado() {
    }

    
    public List<Dado> sortearDados(int quantidadeDados) throws DadoException{
        if(quantidadeDados>=1 && quantidadeDados <=3){
            for (int i = 0; i < quantidadeDados; i++) {
               dados.add(new Dado().sortearNumero()); 
            }
        }else{
            throw new DadoException("Quantidade de dados inválida.");
        }
        Collections.sort(dados, new DadoComparator());
        return dados;
    }

    public int getValor() {
        return valor;
    }
   
   
    private Dado sortearNumero(){
        Random r = new Random();
        valor = r.nextInt(6)+1;
        return this;
    }
    
}
