/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war;

import com.ferafln.war.carta.TerritoryCard;
import com.ferafln.war.carta.objetivo.Objective;
import com.ferafln.war.continent.Continent;
import com.ferafln.war.exception.MessageExceptionEnum;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.exercito.Exercito;
import com.ferafln.war.territorio.Territory;
import com.ferafln.war.territorio.util.StepRoundEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author feraf
 */
public class Player{
    private String name;
    private Exercito troop;
    private Objective objetive;
    private List<Territory> territorys;
    private List<Continent> continents;
    private List<TerritoryCard> territoryCard;
    private int extraTroops =10;
    private StepRoundEnum stepRoundEnum = StepRoundEnum.WAITING;
    private boolean newTerritory = false;
    private Territory attackTerritory;
    private Territory defendTerritorio;
    private Player beatMe;
    public void resetTroops(){
        this.extraTroops = territorys.size()/2;
    }
    
    public boolean isExtraTroops(){
        return extraTroops!=0;
    }
    
    public void setTroop(Exercito troop) {
        this.troop = troop;
    }

    public boolean isNewTerritory() {
        return newTerritory;
    }

    public void setNewTerritory(boolean newTerritory) {
        this.newTerritory = newTerritory;
    }
    
    public int getExtraTroops() {
        return extraTroops;
    }

    public String getName() {
        return name;
    }

    public Objective getObjetive() {
        return objetive;
    }

    public StepRoundEnum getStepRoundEnum() {
        return stepRoundEnum;
    }

    public void setStepRoundEnum(StepRoundEnum stepRoundEnum) {//TODO analize if I need to bring Steps for here
        this.stepRoundEnum = stepRoundEnum;
    }

    public List<TerritoryCard> getTerritoryCard() {
        return territoryCard;
    }

    public List<Territory> getTerritorys() {
        if(territorys==null){
            this.territorys = new ArrayList<>();
        }
        return territorys;
    }
    public void setAttackTerritory(Territory territory) throws WarException{
        if (!StepRoundEnum.ATTACK.equals(this.getStepRoundEnum())) {
            throw new WarException(MessageExceptionEnum.NOT_ATTACK_TURN);
        }
        if (!this.getTerritorys().contains(territory)) {
            throw new WarException(MessageExceptionEnum.TERRITORY_NO_YOUR);
        }
        int index = this.getTerritorys().indexOf(territory);
        int amountTroops = this.getTerritorys().get(index).getAmountTroops();
        if (amountTroops < 2) {
            throw new WarException(MessageExceptionEnum.NOT_ENOGTH_TROOPS);
        }
        this.attackTerritory=territory;
    }
    public void cleanAttack(){
        attackTerritory=null;
        defendTerritorio=null;
    }
    public void setDefendTerritory(Territory territory) throws WarException{
        if (!StepRoundEnum.ATTACK.equals(this.getStepRoundEnum())) {
            throw new WarException(MessageExceptionEnum.NOT_ATTACK_TURN);
        }
        if (territory == null) {
            throw new WarException(MessageExceptionEnum.TERRITORY_ATTACK_NO_SELECT);
        }
        if(this.getTerritorys().contains(territory)){
            throw new WarException(MessageExceptionEnum.YOUR_TERRITORY);
        }
        if(!attackTerritory.getVizinhos().contains(territory)){
            throw new WarException(MessageExceptionEnum.TERRITORY_NO_NEIGHBOOR);
        }
        this.defendTerritorio=territory;
    }

    public Territory getAttackTerritory() {
        return attackTerritory;
    }

    public Territory getDefendTerritorio() {
        return defendTerritorio;
    }
    
    public Exercito getTroop() {
        return troop;
    }

    public void setExtraTroops(int extraTroops) {
        this.extraTroops = extraTroops;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setObjetive(Objective objetive) {
        this.objetive = objetive;
    }

    public Player getBeatMe() {
        return beatMe;
    }

    public void setBeatMe(Player beatMe) {
        this.beatMe = beatMe;
    }

    
//    public void setTerritoryCard(List<TerritoryCard> territoryCard) {
//        this.territoryCard = territoryCard;
//    }

    public void setTerritorys(List<Territory> territorys) {
        this.territorys = territorys;
    }

    public void addExtraTroops(){
        this.extraTroops++;
    }
    public boolean removeExtraTroops() {
        if(extraTroops > 0){
            this.extraTroops--;
            return true;
        }
        return false;
        
    }
    
    public void addContinent(Continent continent){
        if(this.continents==null){
            this.continents=new ArrayList<>();
        }
        this.continents.add(continent);
    }
    public void removeContinent(Continent continent){
        if(this.continents!=null){
            this.continents.remove(continent);
        }
    }
    
    public List<Continent> getContinents(){
        return continents;
    }
    
   
}
