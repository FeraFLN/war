/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.core;

import java.awt.Point;
import java.util.List;

/**
 *
 * @author fernandoneto
 */
public class Territorio {
    private int id;
    private String nome;
    private Point localTerritorio;
    private Exercito exercito;
    private int quantidade = 1;
    private List<Territorio> territoriosVisinhos;

    public Territorio(int id,String nome, Point localTerritorio, List<Territorio> territoriosVisinhos) {
        this.nome = nome;
        this.id = id;
        this.localTerritorio = localTerritorio;
        this.territoriosVisinhos = territoriosVisinhos;
    }

    public void addTerritorioVisinho(Territorio territorioVisinho){
        if(!territorioVisinho.equals(this)){
            territoriosVisinhos.add(territorioVisinho);
        }
    }
    
    public void addExecrito(){
        addExecrito(1);
    }
    public void addExecrito(int i){
        quantidade +=i;
    }
    public void removeExecrito(){
        removeExecrito(1);
    }
    public void removeExecrito(int i){
        quantidade -=i;
        if(quantidade < 1){
            quantidade = 0;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public Exercito getExercito() {
        return exercito;
    }

    public void setExercito(Exercito exercito) {
        this.exercito = exercito;
    }

    public Point getLocalTerritorio() {
        return localTerritorio;
    }

    public void setLocalTerritorio(Point localTerritorio) {
        this.localTerritorio = localTerritorio;
    }

    public String getNome() {
        return nome;
    }

    public List<Territorio> getTerritoriosVizinhos() {
        return territoriosVisinhos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Territorio other = (Territorio) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.localTerritorio != other.localTerritorio && (this.localTerritorio == null || !this.localTerritorio.equals(other.localTerritorio))) {
            return false;
        }
        if (this.exercito != other.exercito && (this.exercito == null || !this.exercito.equals(other.exercito))) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (this.territoriosVisinhos != other.territoriosVisinhos && (this.territoriosVisinhos == null || !this.territoriosVisinhos.equals(other.territoriosVisinhos))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 71 * hash + (this.localTerritorio != null ? this.localTerritorio.hashCode() : 0);
        hash = 71 * hash + (this.exercito != null ? this.exercito.hashCode() : 0);
        hash = 71 * hash + this.quantidade;
        hash = 71 * hash + (this.territoriosVisinhos != null ? this.territoriosVisinhos.hashCode() : 0);
        return hash;
    }

   
    
    
    
    
}
