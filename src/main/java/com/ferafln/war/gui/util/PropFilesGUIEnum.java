/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.util;

import java.io.File;

/**
 *
 * @author feraf
 */
public enum PropFilesGUIEnum {
    TERRITORYS_POSITION("territorysPosition.properties");
    
    private final String root =System.getProperty("user.dir") + File.separator + "properties" + File.separator+"gui"+ File.separator;
    private String path;

    private PropFilesGUIEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return root + path;
    }
}
