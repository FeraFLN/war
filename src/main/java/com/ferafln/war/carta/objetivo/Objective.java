/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.carta.objetivo;

import com.ferafln.war.Player;
import com.ferafln.war.Tabuleiro;
import com.ferafln.war.continent.Continent;
import com.ferafln.war.exception.WarException;
import com.ferafln.war.territorio.util.PropFilesEnum;
import com.ferafln.war.territorio.util.Props;
import java.util.Properties;
import javax.swing.ImageIcon;

/**
 *
 * @author feraf
 */
public abstract class Objective {
    private final int id;
    private ImageIcon imagem;
    private final Tabuleiro tabuleiro;

    public Objective(Tabuleiro tabuleiro, int id) {
        this.tabuleiro = tabuleiro;
        this.id=id;
    }

    protected String getProp() throws WarException {
        Properties properties = Props.getProperties(PropFilesEnum.OBJECTIVES_RULES);
        String result = properties.getProperty("" + id);
        if ("".equals(result)) {
            throw new WarException();//TODO:treat this
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    protected Player getPlayer(int id) {
        for (Player p : tabuleiro.getPlayers()) {
            if (p.getTroop().getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean conquistouObjetivo() throws WarException;

    public boolean destroyTroops() throws WarException {
        String[] prop = getProp().split(",");
        int idTroop = Integer.parseInt(prop[0]);
        Player otherPlayer = getPlayer(idTroop);
        if (otherPlayer != null && !otherPlayer.equals(getTabuleiro().getRoundPlayer())) {
            return tabuleiro.getRoundPlayer().getTerritorys().size() == Integer.parseInt(prop[1]);
        } else {
            return tabuleiro.getRoundPlayer().getBeatMe().equals(otherPlayer);
        }
    }

    public boolean conqTerritory() throws WarException {
        Player p = getTabuleiro().getRoundPlayer();
        int result = 0;
        String[] prop = getProp().split(",");
        for (Continent c : p.getContinents()) {
            if (c.getId() == Integer.parseInt(prop[0]) || c.getId() == Integer.parseInt(prop[1])) {
                result++;
            }
        }
        return result == 2;
    }
}
