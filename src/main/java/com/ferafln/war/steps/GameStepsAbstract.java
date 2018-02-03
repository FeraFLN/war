/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.steps;

import com.ferafln.war.Player;
import com.ferafln.war.exception.MessageExceptionEnum;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.territorio.Territory;
import com.ferafln.war.territorio.util.StepRoundEnum;
import java.util.List;

/**
 *
 * @author feraf
 */
public abstract class GameStepsAbstract {
    private List<Player> players;
    private Player roundPlayer;
    public GameStepsAbstract(List<Player> players) {
        this.players = players;
    }
    /**
     * 
     * @param round
     * @return if the round changed return true
     * @throws WarException 
     */
    protected abstract boolean next() throws WarException;

    public boolean nextStep()throws WarException{
        findRoundPlayer();
        return next();
    } 
    
    protected List<Player> getPlayers() {
        return players;
    }
    protected Player findRoundPlayer(){
        for (Player player : players) {
            if(!StepRoundEnum.WAITING.equals(player.getStepRoundEnum())){
                this.roundPlayer = player;
                return this.roundPlayer;
            }
        }
        return null;
    }
    private boolean isNextRound(){
        int index = players.indexOf(this.roundPlayer);
        if (index >= players.size() - 1) {
            index = 0;
            return true;
        } else {
            return false;
        }
    }
    protected boolean setRoundPlayer() {
        boolean changeRound = isNextRound();
        int index = players.indexOf(this.roundPlayer);
        if(changeRound){
            index = 0;
        }else{
            index++;
        }
        this.roundPlayer.setStepRoundEnum(StepRoundEnum.WAITING);
        this.roundPlayer = players.get(index);
        return changeRound;
    }

    public boolean jumpStep(StepRoundEnum stepRoundEnum) throws WarException{
        findRoundPlayer();
        if(roundPlayer.getStepRoundEnum().compare(stepRoundEnum)==1){
           roundPlayer.setStepRoundEnum(stepRoundEnum);
           return false;
        }else{
            boolean value =isNextRound();
            if(!value){
                setRoundPlayer();
                roundPlayer.setStepRoundEnum(stepRoundEnum);
            }
            return value;
        }
    }
    public Player getRoundPlayer() {
        if(roundPlayer==null){
            findRoundPlayer();
        }
        return roundPlayer;
    }
    
    protected void setExtraTroops() {
        getRoundPlayer().setExtraTroops(this.roundPlayer.getTerritorys().size() / 2);
    }
    
    protected void commitTroops() throws WarException {
        if (roundPlayer.getExtraTroops() != 0) {
            throw new WarException(MessageExceptionEnum.YOU_HAVE_TROOPS_YET);
        }
        List<Territory> l = roundPlayer.getTerritorys();
        for (Territory terr : l) {
            terr.commitTroops();
        }
    }
}
