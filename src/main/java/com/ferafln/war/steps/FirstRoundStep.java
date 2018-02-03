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
public class FirstRoundStep extends GameStepsAbstract{

    public FirstRoundStep(List<Player> players) {
        super(players);
    }
    
    @Override
    public boolean  next() throws WarException {
        return firstRoundStep();
    }
    private boolean firstRoundStep() throws WarException {
        boolean roundChange = false;
        commitTroops();
        if(setRoundPlayer()){
            roundChange=true;
            getRoundPlayer().setStepRoundEnum(StepRoundEnum.WAITING);
        }
        if (!roundChange){
            setExtraTroops();
            getRoundPlayer().setStepRoundEnum(StepRoundEnum.FIRST_STEP);
        } else {
            getRoundPlayer().setStepRoundEnum(StepRoundEnum.ATTACK);
        }
        return roundChange;
    }
}
