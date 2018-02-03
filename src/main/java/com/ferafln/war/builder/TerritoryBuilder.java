/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.builder;

import com.ferafln.war.territorio.Territory;
import com.ferafln.war.territorio.util.PropFilesEnum;
import com.ferafln.war.territorio.util.Props;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author feraf
 */
public class TerritoryBuilder {


    private TerritoryBuilder() {
    }

   

    private List<Territory> loadNames() {
        List<Territory> l = new ArrayList<>();
        Properties properties = Props.getProperties(PropFilesEnum.TERRITORRYS_NAMES);
        Enumeration enuKeys = properties.keys();
        Territory t = null;
        while (enuKeys.hasMoreElements()) {
            Integer id = Integer.parseInt(enuKeys.nextElement().toString());
            String value = properties.getProperty(id.toString());
            t = new Territory(id, value);
            t.addTroops();
            t.commitTroops();
            l.add(t);
        }
        return l;
    }

    private void loadNeighboors(List<Territory> list) {
        Properties properties = Props.getProperties(PropFilesEnum.TERRITORRYS_NEIGHBORING);
        Enumeration enuKeys = properties.keys();
        Territory t = null;
        while (enuKeys.hasMoreElements()) {
            Integer id = Integer.parseInt(enuKeys.nextElement().toString());
            t = new Territory(id);
            int index = list.indexOf(t);
            String[] values = properties.getProperty(id.toString()).split(",");
            for(int i =0; i<values.length;i++){
                Territory tNeighboor = new Territory(Integer.parseInt(values[i]));
                int indexNeighboor = list.indexOf(tNeighboor);
                tNeighboor = list.get(indexNeighboor);
                list.get(index).addVizinho(tNeighboor);
                
            }
        }
    }

    public static List<Territory> builder() {
        TerritoryBuilder builder = new TerritoryBuilder();
        List<Territory> l =  builder.loadNames();
        builder.loadNeighboors(l);
        return l;
    }
}
