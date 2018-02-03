/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom.panel;

import com.ferafln.war.gui.bottom.PlayerPanel;
import com.ferafln.war.territorio.util.StepRoundEnum;

/**
 *
 * @author feraf
 */
public class InfoPlayerFactory {
    private InfoPlayerAbstract paneldistTroops;
    private InfoPlayerAbstract panelAttack;
    public InfoPlayerFactory() {
    }
    
    public InfoPlayerAbstract getInfoPanel(PlayerPanel playerPanel){
        StepRoundEnum s = playerPanel.getRoundPlayer().getStepRoundEnum();
        if(StepRoundEnum.FIRST_STEP.equals(s)||StepRoundEnum.DISTR_EXTRA_TROOPS.equals(s)){
            if(paneldistTroops==null){
                this.paneldistTroops = new LeftPanelDistTroops(playerPanel);
            }
            return paneldistTroops;
        }else if(StepRoundEnum.ATTACK.equals(s)){
            if(panelAttack==null){
                this.panelAttack = new LeftPanelAttack(playerPanel);
            }
            return panelAttack;
        }else{
            return paneldistTroops;
        }
    }
}
