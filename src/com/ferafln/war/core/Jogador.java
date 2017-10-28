/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.core;

import com.ferafln.war.core.exception.ContinenteException;
import com.ferafln.war.core.exception.DadoException;
import com.ferafln.war.core.exception.JogadorException;
import com.ferafln.war.enums.SimbolosCartaEnum;
import com.ferafln.war.utilitarios.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernandoneto
 */
public class Jogador {

    private String nome;
    private Exercito exercito;
    private int qtdTrocas = 0;
    private int qtdExercitoTroca = 6;
    private int qtdExercitoExtra;
    private List<CartaTerritorio> cartaTerritorio;
    private List<Territorio> territorios;
    private List<Continente> continentes;

    public Jogador(String nome, Exercito exercito, List<Territorio> territorios) {
        this.nome = nome;
        this.exercito = exercito;
        this.territorios = territorios;
        this.qtdExercitoExtra = territorios.size() / 2;
    }

    public void addExecitoContinente(Territorio territorio, int quantidade) throws JogadorException {
        for (Continente c : continentes) {
            if (c.getTerritorioCont().contains(territorio)) {
                try {
                    c.addExercitoContinente(territorio, quantidade);
                } catch (ContinenteException ex) {
                    throw new JogadorException(ex.getMessage());
                }
            }
        }
    }

    public List<Continente> getContinentes() {
        return continentes;
    }

    public void removeExercTerAtaque(Territorio territorio,int qtdExecito) throws JogadorException{
        if(!territorios.contains(territorio)){
            throw new JogadorException("Esse território não pertence ao jogador "+nome+".");
        }     
        territorio.removeExecrito(qtdExecito);
        if(territorio.getQuantidade()==0){
            territorio.addExecrito();
        }
    }
    public Territorio removeExercTerDefesa(Territorio territorio,int qtdExecito) throws JogadorException{
        if(!territorios.contains(territorio)){
            throw new JogadorException("Esse território não pertence ao jogador "+nome+".");
        }     
        territorio.removeExecrito(qtdExecito);
        if(territorio.getQuantidade()==0){
            territorios.remove(territorio);
            removeContinente(territorio);
            return territorio;
        }
        return null;
    }
    
    private void removeContinente(Territorio territorio){
        for (Continente c : getContinentes()) {
            if(c.getTerritorioCont().contains(territorio)){
                getContinentes().remove(c);
            }
        }
    }
    public void addExercito(Territorio territorio, int quantidade) throws JogadorException {
        if (qtdExercitoExtra == 0) {
            throw new JogadorException("Você não possui mais exércitos disponíveis.");
        }
        if (!territorios.contains(territorio)) {
            throw new JogadorException("Esse território não lhe pertençe.");
        }
        if (quantidade > qtdExercitoExtra) {
            throw new JogadorException("Você só tem " + qtdExercitoExtra + " exercitos disponíveis.");
        }
        ((Territorio) Util.getValue(territorios, territorio)).addExecrito(quantidade);
        qtdExercitoExtra -= quantidade;
    }

    public List<Dado> jogarDados(Territorio territorio) throws JogadorException {
        if(!territorios.contains(territorio)){
            throw new JogadorException("Esse território não é seu.");
        }
        int qtdDado = territorio.getQuantidade() <= 3 && territorio.getQuantidade() >= 1 ? territorio.getQuantidade(): 3;
        try {
            return new Dado().sortearDados(qtdDado);
        } catch (DadoException ex) {
            throw new JogadorException(ex.getMessage());
        }
    }

    public void trocaCartas(List<CartaTerritorio> cartas) throws JogadorException{
        if (checkTrocarCartas(cartas)) {
            for (CartaTerritorio ct : cartas) {
                if (territorios.contains(ct)) {
                    ((Territorio) Util.getValue(territorios, ct)).addExecrito(2);
                }
            }
            qtdTrocas += 1;
            qtdExercitoTroca += 2;
            qtdExercitoExtra += qtdExercitoTroca;
            cartaTerritorio.removeAll(cartas);
        }

    }

    private boolean checkTrocarCartas(List<CartaTerritorio> cartas) throws JogadorException {
        if (cartas.size() < 3) {
            throw new JogadorException("Você não tem cartas suficientes.");
        }
        if (cartaTerritorio.size() < 3) {
            throw new JogadorException("Máximo de cartas por jogada são três.");
        }
        int contTr = 0, contQd = 0, contCr = 0;
        for (CartaTerritorio ct : cartas) {
            if (SimbolosCartaEnum.CIRCULO.equals(ct.getSimbolo())) {
                contCr += 1;
            } else if (SimbolosCartaEnum.QUADRADO.equals(ct.getSimbolo())) {
                contQd += 1;
            } else if (SimbolosCartaEnum.TRIANGULO.equals(ct.getSimbolo())) {
                contTr += 1;
            }
        }
        if (contCr == 3 || contQd == 3 || contTr == 3) {
            return true;
        } else if (contCr != 0 && contQd != 0 && contTr != 0) {
            return true;
        }
        return false;
    }

    /*
    public boolean checkTrocarCartas() throws JogadorException {
    return checkTrocarCartas(cartaTerritorio);
    }
    
    private boolean checkTrocarCartas(List<CartaTerritorio> cartas) throws JogadorException {
    if (cartas.size() < 3) {
    throw new JogadorException("Você não tem cartas suficientes.");
    }
    if (cartaTerritorio.size() == 5) {
    return true;
    }
    int contTr = 0, contQd = 0, contCr = 0;
    for (CartaTerritorio ct : cartas) {
    if (SimbolosCartaEnum.CIRCULO.equals(ct.getSimbolo())) {
    contCr += 1;
    } else if (SimbolosCartaEnum.QUADRADO.equals(ct.getSimbolo())) {
    contQd += 1;
    } else if (SimbolosCartaEnum.TRIANGULO.equals(ct.getSimbolo())) {
    contTr += 1;
    }
    }
    if (contCr == 3 || contQd == 3 || contTr == 3) {
    return true;
    } else if (contCr != 0 && contQd != 0 && contTr != 0) {
    return true;
    }
    return false;
    }
    
    public void jogada(List<CartaTerritorio> cartas) throws JogadorException {
    if(cartaTerritorio.size()==5){
    throw new JogadorException("É necessario trocar suas cartas.\nEscolha três cartas para troca."); 
    }
    if(cartas.size()>3){
    throw new JogadorException("Máximo de cartas por jogada são três."); 
    }
    if(!checkTrocarCartas(cartas)){
    throw new JogadorException("São necessarias três cartas com simbolos iguais ou três com simbolos diferentes."); 
    }
    
    }
     * 
     */

    public List<CartaTerritorio> getCartaTerritorio() {
        return cartaTerritorio;
    }

    public Exercito getExercito() {
        return exercito;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdExercitoExtra() {
        return qtdExercitoExtra;
    }

    public int getQtdTrocas() {
        return qtdTrocas;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }
}
