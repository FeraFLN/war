/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.carta.objetivo;
import com.ferafln.war.Tabuleiro;
import com.ferafln.war.exception.WarException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author feraf
 */
public class SortObjectives {
    private static LinkedList<Integer> objectivesNum = new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13));

    public static void resetObjectives(){
        objectivesNum = new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13));
    }
    
    public static Objective pickObjective(Tabuleiro tabuleiro) throws WarException{
        if(objectivesNum.size()==0){
            throw new WarException();//TODO IMPROVE EXCEWPTION
        }
        Collections.shuffle(objectivesNum);
        int num = objectivesNum.poll();
        switch (num){
            case 0: return new ConqAsiaAfrica(tabuleiro);
            case 1: return new ConqAsiaSouthAmerica(tabuleiro);
            case 2: return new ConqEuropeOceaniaPlusOne(tabuleiro);
            case 3: return new ConqNorthAmericanAfrica(tabuleiro);
            case 4: return new ConqNorthAmericanOceania(tabuleiro);
            case 5: return new ConqSouthAmericaEuropePlusOne(tabuleiro);
            case 6: return new DestBlackTroops(tabuleiro);
            case 7: return new DestBlueTroops(tabuleiro);
            case 8: return new DestGreenTroops(tabuleiro);
            case 9: return new DestRedTroops(tabuleiro);
            case 10: return new DestWhiteTroops(tabuleiro);
            case 11: return new DestYellowTroops(tabuleiro);
            case 12: return new EighteenTerritorry(tabuleiro);
            case 13: return new TwentyFourTerritorry(tabuleiro);
            default:return null;    
                   
        }
    }
    
   
    
}
