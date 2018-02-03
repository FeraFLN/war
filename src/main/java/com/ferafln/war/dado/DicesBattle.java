/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.dado;

import com.ferafln.war.Player;
import com.ferafln.war.exception.MessageExceptionEnum;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.territorio.Territory;
import com.ferafln.war.territorio.util.StepRoundEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feraf
 */
public class DicesBattle {

    
    private List<Dice> dicesAttack;
    private List<Dice> dicesDefense;
    private int countDefTroopsDefeat;
    private int countAttTroopsDefeat;
    private Territory territoryAttack;
    private Territory territoryDefensor;
    private boolean throwAttackDice = false;
    private List<Dice> dices;
//    private List<Dado> dadosDefesa;
    /**
     * Sorteia os dados de ataque com base na quantidade de exércitos.
     *
     * @param qtdExercitos
     */
    private void throwDice(int qtdExercitos) throws DadosException {
        if (qtdExercitos < 2) {
            this.dices = null;
            throw new DadosException(MessageExceptionEnum.NOT_ENOGTH_TROOPS);
        }
        this.dices = null;
        switch (qtdExercitos) {
            case 2:
                this.dices = Arrays.asList(new Dice());
                break;
            case 3:
                this.dices = Arrays.asList(new Dice(), new Dice());
                break;
            default:
                this.dices = Arrays.asList(new Dice(), new Dice(), new Dice());
                break;
        }
        Collections.sort(dices, new DadoComparator());

    }


    public static void main(String[] args) {
        try {
            DicesBattle d = new DicesBattle();
            d.throwDice(6);
//            d.jogaDadosDefesa(6);
            List<Dice> l = null;
            System.out.println("Ataque");
            for (Dice dado : l) {
                System.out.println(dado.getValorSorteado());
            }
//            d.jogaDadosDefesa(4);
//            l = d.getDadosDefesa();
            System.out.println("Defesa");
            for (Dice dado : l) {
                System.out.println(dado.getValorSorteado());
            }
//            System.out.println("resultado ataque: "+d.resultadoAtaque()+" resultado defesa: "+d.resultadoDefesa());
        } catch (DadosException ex) {
            Logger.getLogger(DicesBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void attack(Player roundPlayer) throws WarException {
        this.throwDice(roundPlayer.getAttackTerritory().getAmountTroops());
        this.throwAttackDice = true;
    }
    
    public boolean defense(Player roundPlayer) throws WarException {
        if(!throwAttackDice){
            throw new WarException(MessageExceptionEnum.DID_NOT_ATTACK);
        }
        this.throwAttackDice = false;
        this.throwDice(roundPlayer.getDefendTerritorio().getAmountTroops());
        compareResults();
        territoryAttack.removeExercito(countDefTroopsDefeat);
        return territoryDefensor.removeExercito(countAttTroopsDefeat);
    }

    private void compareResults() {
        if (dicesAttack == null || dicesAttack.isEmpty()) {

            this.countAttTroopsDefeat = 0;
            this.countDefTroopsDefeat = 0;
            return;
        }
        if (dicesDefense == null || dicesDefense.isEmpty()) {
            this.countAttTroopsDefeat = 0;
            this.countDefTroopsDefeat = 0;
            return;
        }

        List<Dice> smaller;
        if (dicesAttack.size() <= dicesDefense.size()) {
            smaller = this.dicesAttack ;
        } else {
            smaller = this.dicesDefense ;
        }
        this.countAttTroopsDefeat = 0;
        this.countDefTroopsDefeat = 0;
        for (int i = 0; i < smaller.size(); i++) {
            if (dicesAttack.get(i).getValorSorteado() > dicesDefense.get(i).getValorSorteado()) {
                this.countAttTroopsDefeat++;
            } else {
                this.countDefTroopsDefeat++;
            }
        }
    }

    public void setTerritoryAttack(Territory territoryAttack) {
        this.territoryAttack = territoryAttack;
    }

    public void setTerritoryDefend(Territory territoryDefend) {
        this.territoryDefensor = territoryDefend;
    }

    public int getAttackTroopsDefeat() {
        return countAttTroopsDefeat;
    }

    public int getDefendTroopsDefeat() {
        return countDefTroopsDefeat;
    }
    
    
}
