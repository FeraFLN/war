/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.bottom;

import com.ferafln.war.Player;
import com.ferafln.war.exception.WarException;

/**
 *
 * @author feraf
 */
public interface PlayerPanel {

    public Player getRoundPlayer();

    public int getRound();

    public void nextStep() throws WarException;
}
