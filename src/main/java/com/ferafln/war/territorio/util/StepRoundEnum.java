/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.territorio.util;

/**
 *
 * @author feraf
 */
public enum StepRoundEnum {
    WAITING(0),
    FIRST_STEP(1),
    DISTR_EXTRA_TROOPS(2),
    DISTR_CONTINENT_TROOPS(3),
    CHANGE_CARDS(4),
    ATTACK(5),
    MANAGER_TROOPS(6),
    PASS_TROOPS(7),
    PULL_CARD(8);
    
    private int order;

    private StepRoundEnum(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
    
    public int compare(StepRoundEnum enum1){
        if(this.getOrder() < enum1.getOrder()){
            return 1;
        }else if(this.getOrder() > enum1.getOrder()){
            return -1;
        }else{
            return 0;
        }
    }
}
