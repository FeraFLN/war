/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui;

import java.awt.Font;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

/**
 *
 * @author feraf
 */
public class FontDefaultGame extends Font{

    public FontDefaultGame() {
        super("Tahoma", 1, 10);
    }
    public FontDefaultGame(int size) {
        super("Tahoma", 1, size);
    }
    
    
    public FontDefaultGame(Font font) {
        super(font);
    }

    public FontDefaultGame(Map<? extends Attribute, ?> attributes) {
        super(attributes);
    }

    public FontDefaultGame(String name, int style, int size) {
        super(name, style, size);
    }
 
    
}
