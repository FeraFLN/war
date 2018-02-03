/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war;

import com.ferafln.war.builder.ContinentBuilder;
import com.ferafln.war.continent.Continent;
import com.ferafln.war.builder.TerritoryBuilder;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.carta.TerritoryCard;
import com.ferafln.war.carta.objetivo.Objective;
import com.ferafln.war.carta.objetivo.SortObjectives;
import com.ferafln.war.dado.DicesBattle;
import com.ferafln.war.exception.MessageExceptionEnum;
import com.ferafln.war.steps.GameSteps;
import com.ferafln.war.territorio.Territory;
import com.ferafln.war.territorio.util.StepRoundEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author feraf
 */
public class Tabuleiro { //implements Observer{

    private final List<Player> players;
    private Queue<TerritoryCard> territoryCards;
    private final List<Territory> territorys;
    private int round;
    private final List<Continent> continents;
    private Player roundPlayer;
    private DicesBattle dicesBattle;
    private GameSteps steps;

    public Tabuleiro(List<Player> players) throws WarException {
        this.round = 0;
        this.players = players;
        this.steps = new GameSteps(players);
        this.territorys = TerritoryBuilder.builder();
        this.continents = ContinentBuilder.builder(territorys);
        this.territoryCards = new LinkedList<TerritoryCard>();//TODO create builder to territoryCards random.

    }

    public void iniciarPartida() throws WarException {
        if (players.size() < 3) {
            throw new WarException(MessageExceptionEnum.NOT_ENOGTH_PLAYERS);
        }
        if (players.size() > 6) {
            throw new WarException(MessageExceptionEnum.TOO_MANY_PLAYERS);
        }
        this.sortOrderPlayers();
        this.sortTerritory();
        this.sortObjectives();
        this.roundPlayer = this.steps.getFirstPlayer();
        this.round = 0;
    }

    private void sortObjectives() throws WarException{
        for (Player player : players) {
            player.setObjetive(SortObjectives.pickObjective(this));
        }
    }
    public void nextStep() throws WarException {
        if (!secondRound()) {
            if (steps.nextStep(roundPlayer.getStepRoundEnum())) {
                round++;
            }
        }
        this.roundPlayer = steps.getRoundPlayer();
    }

    private boolean secondRound() throws WarException {
        boolean value = round == 1 && StepRoundEnum.PULL_CARD.equals(roundPlayer.getStepRoundEnum());
        if (value) {
            if (steps.jumpStep(StepRoundEnum.ATTACK)) {
                round++;
                steps.nextStep(roundPlayer.getStepRoundEnum());
            }
        }
        return value;
    }
    public void throwAttackDices() throws WarException{
        dicesBattle.attack(roundPlayer);
    }
    public void throwDefendDices() throws WarException{
        dicesBattle.defense(roundPlayer);
    }
    
//    public void setTerritoryAttack(Territory territory){
//        dicesBattle.setTerritoryAttack(territory);
//    }
//    public void setTerritoryDefend(Territory territory){
//        dicesBattle.setTerritoryDefend(territory);
//    }
    
    
    public int getAttackTroopsDefeat(){
        return dicesBattle.getAttackTroopsDefeat();
    }
    public int getDefendTroopsDefeat(){
        return dicesBattle.getDefendTroopsDefeat();
    }
    private boolean isChangeCards() {
        return false;//TODO: create method check have cards to change
    }

    private boolean isExtraTroopsContinents() {
        return false;//TODO: create method check have extra Troops for continents
    }

    public int getRound() {
        return round;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void nextRound() {
        this.round++;
    }

    public Player getRoundPlayer() {
        return roundPlayer;
    }

    private void sortTerritory() {
        Collections.shuffle(territorys);
        int indexPlayer = 0;
        for (int i = 0; i < territorys.size(); i++) {
            territorys.get(i).setPlayer(players.get(indexPlayer));
            players.get(indexPlayer).getTerritorys().add(territorys.get(i));
            indexPlayer++;
            if (indexPlayer == players.size()) {
                indexPlayer = 0;
            }
        }
    }

    public List<Territory> getTerritorys() {
        return territorys;
    }

    public TerritoryCard pollTerritoryCard() {
        return territoryCards.poll();
    }

    private void sortOrderPlayers() {
        Collections.shuffle(players);
    }

    private void setExtraTroops() {
        this.roundPlayer.setExtraTroops(this.roundPlayer.getTerritorys().size() / 2);
    }

   
//    public DicesBattle getDadosAttack() {
//        return dicesAttack;
//    }

    
}
