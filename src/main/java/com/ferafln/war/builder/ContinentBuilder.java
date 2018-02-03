/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.builder;

import com.ferafln.war.continent.Continent;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.territorio.Territory;
import com.ferafln.war.territorio.util.PropFilesEnum;
import com.ferafln.war.territorio.util.Props;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Arrays;
import java.util.Properties;

/**
 *
 * @author feraf
 */
public class ContinentBuilder {


    private ContinentBuilder() {
    }

    private List<Continent> loadName(List<Territory> territorys) throws WarException {
        Properties properties = Props.getProperties(PropFilesEnum.CONTINENTS_NAMES);
        List<Continent> list = new ArrayList<>();
        Enumeration enuKeys = properties.keys();
        while (enuKeys.hasMoreElements()) {
            Integer id = Integer.parseInt(enuKeys.nextElement().toString());
            String[] values = properties.getProperty(id.toString()).split(",");
            if (values.length != 2) {
                throw new WarException("");//TODO config error
            }
            String name = values[0];
            int extraTroops = Integer.parseInt(values[1]);
            List<Territory> ts = loadTerritorys(id, territorys);
            list.add(new Continent(id, name, ts,extraTroops));
        }
        return list;
    }
    
    private List<Territory> loadTerritorys(int id, List<Territory> territorys) throws WarException{
        Properties properties = Props.getProperties(PropFilesEnum.CONTINENTS_TERRITORY);
        String[] idTerritorys = properties.getProperty(""+id).split(",");
        List<Territory> result = new ArrayList<>();
        for (String idTerr : idTerritorys) {
            if(!territorys.contains(new Territory(id))) {
                throw new WarException();//TODO error cofig 
            }
            int index = territorys.indexOf(new Territory(Integer.parseInt(idTerr)));
            result.add(territorys.get(index));
        }
        return result;
    }
    
    public static List<Continent> builder(List<Territory> territorys) throws WarException {
        ContinentBuilder builder = new ContinentBuilder();
        List<Continent> l =  builder.loadName(territorys);
        return l;
    }
    
    
//    public static void main(String[] args) throws WarException {
//        List<Territory> terr=TerritoryBuilder.builder();
//        List<Continent> l =ContinentBuilder.builder(terr);
//        for (Continent continent : l) {
//            System.out.println(continent.getName());
//            System.out.println(continent.isContinente(Arrays.asList(new Territory(1))));
//            for (Territory t : continent.getTerritorios()) {
//                System.out.print(" | "+t.getName());
//            }
//            System.out.println("\n__________________________________________________");
//        }
//    }
}
