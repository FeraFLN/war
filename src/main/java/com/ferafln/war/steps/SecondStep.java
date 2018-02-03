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
public class SecondStep extends GameStepsAbstract{

    public SecondStep(List<Player> players) {
        super(players);
    }

    @Override
    protected boolean next() throws WarException {
        getRoundPlayer().setStepRoundEnum(StepRoundEnum.MANAGER_TROOPS);
        return false;
    }
    
}
