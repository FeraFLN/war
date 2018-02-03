/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom.leftpanel;

import com.ferafln.war.gui.bottom.PlayerPanel;
import com.ferafln.war.territorio.util.StepRoundEnum;

/**
 *
 * @author feraf
 */
public class LeftPlayerPanelFactory {
    public LeftPlayerPanelFactory() {
    }
    
    public LeftPlayerPanelAbstract getInfoPanel(PlayerPanel playerPanel){
        StepRoundEnum s = playerPanel.getRoundPlayer().getStepRoundEnum();
//            return new LeftPanelAttack(playerPanel);
        if(StepRoundEnum.FIRST_STEP.equals(s)||StepRoundEnum.DISTR_EXTRA_TROOPS.equals(s)){
            return new LeftPanelDistTroops(playerPanel);
        }else if(StepRoundEnum.ATTACK.equals(s)){
            return new LeftPanelAttack(playerPanel);
        }else{
            return new LeftPanelDistTroops(playerPanel);
        }
    }
}
