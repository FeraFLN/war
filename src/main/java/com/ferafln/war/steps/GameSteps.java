/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.steps;

import com.ferafln.war.Player;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.territorio.util.StepRoundEnum;
import java.util.List;

/**
 *
 * @author feraf
 */
public class GameSteps {

    private List<Player> players;
    GameStepsAbstract gameSteps = null;
    public GameSteps(List<Player> players) {
        this.players = players;
        gameSteps = null;
    }
    public Player getRoundPlayer(){
        return gameSteps.getRoundPlayer();
    }
    
    public boolean jumpStep(StepRoundEnum stepRoundEnum) throws WarException {
        getGameStep(stepRoundEnum);
        return gameSteps.jumpStep(stepRoundEnum);
    }
    
    public boolean nextStep(StepRoundEnum stepRoundEnum) throws WarException {
        getGameStep(stepRoundEnum);
        return gameSteps.nextStep();
    }
    
    public Player getFirstPlayer() throws WarException{
        if(players== null || players.isEmpty()){
            return null;
        }
        Player p = this.players.get(0);
        this.players.get(0).setStepRoundEnum(StepRoundEnum.FIRST_STEP);
        this.players.get(0).setExtraTroops(this.players.get(0).getTerritorys().size() / 2);
        return players.get(0);
    }
    
    private void getGameStep(StepRoundEnum stepRoundEnum){
        if(StepRoundEnum.FIRST_STEP.equals(stepRoundEnum)){
            gameSteps = new FirstRoundStep(players);
        }else if(StepRoundEnum.DISTR_EXTRA_TROOPS.equals(stepRoundEnum)){
            gameSteps = new DistExtraTroopsStep(players);
        }else if(StepRoundEnum.DISTR_CONTINENT_TROOPS.equals(stepRoundEnum)){
            gameSteps = new DistTroopsContStep(players);
        }else if(StepRoundEnum.CHANGE_CARDS.equals(stepRoundEnum)){
            gameSteps = new ChangeCardsStep(players);
        }else if(StepRoundEnum.ATTACK.equals(stepRoundEnum)){
            gameSteps = new AttackStep(players);
        }else if(StepRoundEnum.MANAGER_TROOPS.equals(stepRoundEnum)){
            gameSteps = new ManagerTroopsStep(players);
        }else if(StepRoundEnum.PULL_CARD.equals(stepRoundEnum)){
            gameSteps = new PullCardStep(players);
        }
    }

}
