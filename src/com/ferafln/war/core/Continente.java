/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.core;

import com.ferafln.war.core.exception.ContinenteException;
import com.ferafln.war.utilitarios.Util;
import java.util.List;

/**
 *
 * @author fernandoneto
 */
public class Continente {
    private String nome;
    private int id;
    private int qtdExtraExec;
    private int qtdAtualExec;
    private List<Territorio> territorioCont;

    public Continente(int id,String nome, int qtdExtraExec, List<Territorio> territorioCont) {
        this.nome = nome;
        this.id = id;
        this.qtdExtraExec = qtdExtraExec;
        this.territorioCont = territorioCont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addExercitoContinente(Territorio territorio, int quantidade) throws ContinenteException{
        if(qtdAtualExec<quantidade){
            throw new ContinenteException("Você só tem " + qtdAtualExec+ " exercitos disponíveis para esse continente.");
        }
        if(territorioCont.contains(territorio)){
           ((Territorio)Util.getValue(territorioCont, territorio)).addExecrito(quantidade); 
           qtdAtualExec -=quantidade;
        }else{
            throw new ContinenteException("Esse território não faz parte do continente +"+nome+".");
            
        }
    }
    
    
    public void resetExercitos(){
        qtdAtualExec = qtdExtraExec;
    }
    
    public boolean isContinente(List<Territorio> territorios){
        return territorios.contains(territorioCont);
    }

    public String getNome() {
        return nome;
    }

    public List<Territorio> getTerritorioCont() {
        return territorioCont;
    }

    public int getQtdExtraExec() {
        return qtdExtraExec;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Continente other = (Continente) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.qtdExtraExec != other.qtdExtraExec) {
            return false;
        }
        if (this.territorioCont != other.territorioCont && (this.territorioCont == null || !this.territorioCont.equals(other.territorioCont))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 37 * hash + this.qtdExtraExec;
        hash = 37 * hash + (this.territorioCont != null ? this.territorioCont.hashCode() : 0);
        return hash;
    }
    
    
}
