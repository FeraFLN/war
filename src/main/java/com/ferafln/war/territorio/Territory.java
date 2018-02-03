/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.territorio;

import com.ferafln.war.Player;
import com.ferafln.war.territorio.util.StepRoundEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author feraf
 */
public class Territory{
    
    private int id;
    private String nome;
    private List<Territory> vizinhos;
    private Player player;
    private int amountTroops=0;
    private int initTroops = 0;
    private boolean attacker = false;
    //private Dados dados;

    public Territory() {
        //this.dados=new Dados();
        
    }

    public Territory(int id) {
        this.id = id;
    }

    public Territory(int id,String nome) {
        super();
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setVizinhos(List<Territory> vizinhos) {
        this.vizinhos = vizinhos;
    }
    public void addVizinho(Territory territorio){
        if(this.vizinhos==null){
            this.vizinhos=new ArrayList<>();
        }
        if(this.equals(territorio)){
            return;
        }
        this.vizinhos.add(territorio);
    }

    public List<Territory> getVizinhos() {
        return vizinhos;
    }

    public String getName() {
        return nome;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean removeExercito(int amount){
        this.amountTroops -=amount;
        if(this.amountTroops<=0){
            this.amountTroops=0;
            commitTroops();
            return true;
        }
        commitTroops();
        return false;
        
    }
    public boolean removeTroop(){
        if(this.amountTroops > initTroops){
            this.amountTroops--;
            return true;
        }
        this.amountTroops=initTroops;
        return false;
    }
    
    public int getAmountTroops() {
        return amountTroops;
    }
    public void setAmountTroops(int value){
        this.amountTroops = value;
        this.initTroops = value;
    }
    public void addTroops(){
        this.amountTroops++;
    }
    
    public void commitTroops(){
        this.initTroops = this.amountTroops ;
    }
    public boolean isAttacker(){
        return (StepRoundEnum.ATTACK.equals(getPlayer().getStepRoundEnum())&& 
                (getPlayer().getAttackTerritory()==null||getPlayer().getAttackTerritory().equals(this)));
//        return attacker;
    }

//    public void setAttacker(boolean attacker) {
//        this.attacker = attacker;
//    }
    
    public boolean isDefender(){
        for (Territory t : vizinhos) {
            if(StepRoundEnum.ATTACK.equals(t.getPlayer().getStepRoundEnum())&& 
                (t.getPlayer().getAttackTerritory()==null||t.getPlayer().getAttackTerritory().equals(t))){
//            if(t.isAttacker()){
                return true;
            }
        }
        return false;
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Territory other = (Territory) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    
   

}
