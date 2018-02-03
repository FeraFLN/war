/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.territorio.util;

import java.io.File;

/**
 *
 * @author feraf
 */
public enum PropFilesEnum {
   CONTINENTS_NAMES("continentsNames.properties"),
   CONTINENTS_TERRITORY("continentsTerritorys.properties"),
   OBJECTIVES_RULES("objectives.properties"),
   TERRITORRYS_NAMES("territorysNames.properties"),
   TERRITORRYS_NEIGHBORING("territorysNeighboring.properties");
   
   
   private final String root = System.getProperty("user.dir")+File.separator + "properties" + File.separator;
   private String path;
    private PropFilesEnum(String path) {
        this.path=path;
    }

    public String getPath() {
        return root+path;
    }
    
}
