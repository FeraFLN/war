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
public class DistExtraTroopsStep extends GameStepsAbstract {

    public DistExtraTroopsStep(List<Player> players) {
        super(players);
    }

    @Override
    public boolean next() throws WarException {
        commitTroops();
        this.getRoundPlayer().setStepRoundEnum(StepRoundEnum.DISTR_CONTINENT_TROOPS);
        return false;
    }

}
