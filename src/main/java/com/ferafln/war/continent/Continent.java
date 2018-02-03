/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.continent;

import com.ferafln.war.territorio.Territory;
import java.util.List;

/**
 *
 * @author feraf
 */
public class Continent {
    private final int id;
    private final String name;
    private final List<Territory> territorios;
    private final int exertcitosExtras;

    public Continent(int id, String name, List<Territory> territorios, int exertcitosExtras) {
        this.id = id;
        this.name = name;
        this.territorios = territorios;
        this.exertcitosExtras = exertcitosExtras;
    }


    public int getId() {
        return id;
    }

    
    public String getName() {
        return name;
    }

    public List<Territory> getTerritorios() {
        return territorios;
    }

    public boolean isContinente(List<Territory> territorios){
        return territorios.containsAll(this.territorios);
    }

    public int getExertcitosExtras() {
        return exertcitosExtras;
    }
}
