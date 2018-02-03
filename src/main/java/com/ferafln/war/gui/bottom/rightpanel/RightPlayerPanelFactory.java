/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom.rightpanel;

import com.ferafln.war.gui.bottom.PlayerPanel;
import com.ferafln.war.territorio.util.StepRoundEnum;

/**
 *
 * @author feraf
 */
public class RightPlayerPanelFactory {
    public RightPlayerPanelFactory() {
    }
    
    public RightPlayerPanelAbstract getInfoPanel(PlayerPanel playerPanel){
        StepRoundEnum s = playerPanel.getRoundPlayer().getStepRoundEnum();
//            return new LeftPanelAttack(playerPanel);
        if(StepRoundEnum.FIRST_STEP.equals(s)||StepRoundEnum.DISTR_EXTRA_TROOPS.equals(s)){
            return new RightPanelDistTroops(playerPanel);
        }else if(StepRoundEnum.ATTACK.equals(s)){
            return new RightPanelAttack(playerPanel);
        }else{
            return new RightPanelDistTroops(playerPanel);
        }
    }
}
