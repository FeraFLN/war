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
public enum PathImagesGUIEnum {

    IMAGE_MAP("map.png"),
    IMAGE_BOTTOM("bottom.png"),
    WINDOW_OBJECTIVE("objetivos" + File.separator+"ObjectiveWindow.png"),
    OBJECTIVE_CARD("objetivos" + File.separator+"objetivo.png"),
    WHITE_TROOP("troops" + File.separator+"branco.png"),
    BLACK_TROOP("troops" + File.separator+"preto.png"),
    BLUE_TROOP("troops" + File.separator+"azul.png"),
    RED_TROOP("troops" + File.separator+"vermelho.png"),
    GREEN_TROOP("troops" + File.separator+"verde.png"),
    YELLOW_TROOP("troops" + File.separator+"amarelo.png");
    
    private final String root = System.getProperty("user.dir")+File.separator + "Images" + File.separator ;
    private String path;

    private PathImagesGUIEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return root + path;
    }
}
