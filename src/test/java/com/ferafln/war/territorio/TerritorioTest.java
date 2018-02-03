/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.territorio;

import com.ferafln.war.exception.WarException;
import com.ferafln.war.exercito.Exercito;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author feraf
 */
public class TerritorioTest {
    
    public TerritorioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void ataqueSucess() {
        try {
            Territory t = new Territory();
            t.setNome("Moscou");
            t.addExercito(8);
            t.setExercito(new Exercito("Vermelho"));
            
            Territory tv = new Territory();
            tv.setNome("Alemanha");
            tv.addExercito(8);
            tv.setExercito(new Exercito("Verde"));
            t.addVizinho(tv);
            
            t.ataca(tv);
            Assert.assertEquals(3, t.getDadosAtaque().size());
            Assert.assertEquals(3, t.getDadosDefesa().size());
            Assert.assertEquals(8 - t.resultadoDefesa(), t.getAmountTroops());
            Assert.assertEquals(8 - t.resultadoAtaque(), tv.getAmountTroops());
        } catch (WarException ex) {
            Assert.fail("Esse teste não pode da falha.");
        }
         
     }
     @Test
     public void ataqueFail() {
        try {
            Territory t = new Territory();
            t.setNome("Moscou");
            t.addExercito(8);
            t.setExercito(new Exercito("Vermelho"));
            
            Territory tv = new Territory();
            tv.setNome("Moscou");
            tv.addExercito(8);
            tv.setExercito(new Exercito("Verde"));
            t.addVizinho(tv);
            
            t.ataca(tv);
            Assert.fail("Esse teste é para da erro.");
        } catch (WarException ex) {
            Assert.assertEquals("Território não pode ser atacado pois não são vizinhos.",ex.getMessage());
        }
         
     }
}
