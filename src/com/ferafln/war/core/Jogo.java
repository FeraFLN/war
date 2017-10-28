/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.core;

import com.ferafln.war.core.exception.JogadorException;
import com.ferafln.war.core.exception.JogoException;
import com.ferafln.war.enums.StatusRodadaEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author fernandoneto
 */
public class Jogo {

    private List<Jogador> jogadores;
    private List<CartaTerritorio> cartaTerritorios;
    private List<Territorio> allTerritorios;
    private List<Continente> allContinentes;
    private StatusRodadaEnum statusRodada = StatusRodadaEnum.DISTRIBUIR;
    private Territorio territorioAtaque;
    private Territorio territorioDefesa;
    private boolean conquistouTerritorio = false;
    private int rodada = 1;
    private int indexJogador = 0;
    private int maxIndJogador;

    public Jogo(List<Jogador> jogadores, List<CartaTerritorio> cartaTerritorios, List<Territorio> allTerritorios, List<Continente> allContinentes) throws JogoException {
        if (jogadores.size() < 3) {
            throw new JogoException("O mínimo de jogadores são 3");
        }
        if (allContinentes == null || allContinentes.isEmpty()) {
            throw new JogoException("Não foi informado nenhum continete.");
        }
        if (allTerritorios == null || allTerritorios.isEmpty()) {
            throw new JogoException("Não foi informado nenhum territorio.");
        }
        this.allContinentes = allContinentes;
        this.allTerritorios = allTerritorios;
        this.maxIndJogador = jogadores.size();
        this.jogadores = jogadores;
        this.cartaTerritorios = cartaTerritorios;
        sortearTerritorios();
    }

    private void sortearTerritorios() {
        long seed = System.nanoTime();
        Collections.shuffle(allTerritorios, new Random(seed));
        for (Territorio t : allTerritorios) {
            jogadores.get(indexJogador).getTerritorios().add(t);
            proxIndexJogador();
        }
    }


    public void trocarCartas(List<CartaTerritorio> listaTroca) throws JogoException {
        if (!StatusRodadaEnum.DISTRIBUIR.equals(statusRodada)) {
            throw new JogoException("Não é possível trocar cartas nessa etapa.");
        }
        try {
            jogadores.get(indexJogador).trocaCartas(listaTroca);
            cartaTerritorios.addAll(listaTroca);
        } catch (JogadorException ex) {
            throw new JogoException(ex.getMessage());

        }
    }

    public void destribuirExercito(Territorio territorio, int quantidade) throws JogoException {
        if (!StatusRodadaEnum.DISTRIBUIR.equals(statusRodada)) {
            throw new JogoException("Não é possível distribuir exercitos nessa etapa.");
        }
        if (jogadores.get(indexJogador).getQtdExercitoExtra() == 0) {
            throw new JogoException("Você não possui mais exercitos a ser distribuidos.");
        }
        try {
            jogadores.get(indexJogador).addExercito(territorio, quantidade);
        } catch (JogadorException ex) {
            throw new JogoException(ex.getMessage());
        }
    }

    public void destribuirExercitoCont(Territorio territorio, int quantidade) throws JogoException {
        try {
            if (!StatusRodadaEnum.DISTRIBUIR_CONT.equals(statusRodada)) {
                throw new JogoException("Não é possível distribuir exercitos nessa etapa.");
            }
            jogadores.get(indexJogador).addExecitoContinente(territorio, quantidade);
        } catch (JogadorException ex) {
            throw new JogoException(ex.getMessage());
        }

    }

    public List<Dado> defesa(List<Dado> dadosVermelhos, Jogador jogadorDefesa) throws JogoException {
        if (!StatusRodadaEnum.ATACAR.equals(statusRodada)) {
            throw new JogoException("Não é possível distribuir exercitos nessa etapa.");
        }
        if (jogadores.get(indexJogador).getTerritorios().contains(territorioDefesa)) {
            throw new JogoException("Você não pode atacar o seu território.");
        }
        try {

            List<Dado> dadosAmarelos = jogadorDefesa.jogarDados(territorioDefesa);
            int i = 0;
            if (dadosVermelhos.size() < dadosAmarelos.size()) {
                i = dadosVermelhos.size();
            } else {
                i = dadosAmarelos.size();
            }
            int contDefesa = 0;
            int contAtaque = 0;
            for (int j = 0; j < i; j++) {
                if (dadosAmarelos.get(i).getValor() >= dadosVermelhos.get(i).getValor()) {
                    contDefesa++;
                } else {
                    contAtaque++;
                }
            }
            Territorio t = jogadorDefesa.removeExercTerDefesa(territorioDefesa, contDefesa);
            jogadores.get(indexJogador).removeExercTerAtaque(territorioAtaque, contAtaque);
            if (t != null) {
                jogadores.get(indexJogador).getTerritorios().add(t);
                conquistouTerritorio = true;
                Continente c = conquistarContinete(t);
                if(c!=null){
                     jogadores.get(indexJogador).getContinentes().add(c);
                }
            }
            return dadosAmarelos;
        } catch (JogadorException ex) {
            throw new JogoException(ex.getMessage());
        }
    }

    private Continente conquistarContinete(Territorio territorio){
        for (Continente c : allContinentes) {
            if(c.getTerritorioCont().contains(territorio)){
                if(c.isContinente(jogadores.get(indexJogador).getTerritorios())){
                    return c;
                }
            }
        }
        return null;
    }
    
    public List<Dado> atacar(Territorio territorioAtaque, Territorio territorioDefesa) throws JogoException {

        if (!StatusRodadaEnum.ATACAR.equals(statusRodada)) {
            throw new JogoException("Não é possível distribuir exercitos nessa etapa.");
        }
        if (!jogadores.get(indexJogador).getTerritorios().contains(territorioAtaque)) {
            throw new JogoException("Selecione um território que lhe pertença.");
        }
        if (!territorioAtaque.getTerritoriosVizinhos().contains(territorioDefesa)) {
            throw new JogoException("Esses territórios não são vizinhos.");
        }
        if (jogadores.get(indexJogador).getTerritorios().contains(territorioDefesa)) {
            throw new JogoException("Você não pode atacar o seu território.");
        }
        if (territorioAtaque.getQuantidade() <= 1) {
            throw new JogoException("Você não tem exercito suficiente.");
        }
        try {
            this.territorioAtaque = territorioAtaque;
            this.territorioDefesa = territorioDefesa;
            return jogadores.get(indexJogador).jogarDados(territorioAtaque);
        } catch (JogadorException ex) {
            throw new JogoException(ex.getMessage());
        }
    }

    public Jogador getJogador(Territorio territorio) {
        for (Jogador jogador : jogadores) {
            if (jogador.getTerritorios().contains(territorio)) {
                return jogador;
            }
        }
        return null;

    }

    public CartaTerritorio puxarCarta() {
        statusRodada = StatusRodadaEnum.PARAR;
        if (conquistouTerritorio) {
            Random r = new Random();
            CartaTerritorio c = cartaTerritorios.get(r.nextInt(cartaTerritorios.size() - 1));
            cartaTerritorios.remove(c);
            return c;
        }
        return null;
    }

    public void proximoJogador() throws JogoException {
        if (!StatusRodadaEnum.PARAR.equals(statusRodada)) {
            throw new JogoException("Não é possível passar para o proximo jogador.");
        }
        conquistouTerritorio = false;
        rodada = (proxIndexJogador() == true ? rodada++ : rodada);
        statusRodada = StatusRodadaEnum.DISTRIBUIR;
    }

    private boolean proxIndexJogador() {
        if (indexJogador == maxIndJogador - 1) {
            indexJogador = 0;

            return true;
        } else {
            indexJogador++;
            return false;
        }
    }

    public void proximaEtapa() {
        if (StatusRodadaEnum.DISTRIBUIR.equals(statusRodada)) {
            if ((jogadores.get(indexJogador).getQtdExercitoExtra() != 0 && jogadores.get(indexJogador).getContinentes().size() == 0) || rodada == 1) {
                statusRodada = StatusRodadaEnum.ATACAR;
            } else {
                statusRodada = StatusRodadaEnum.DISTRIBUIR_CONT;
            }
        } else if (StatusRodadaEnum.DISTRIBUIR_CONT.equals(statusRodada)) {
            statusRodada = StatusRodadaEnum.ATACAR;
        } else if (StatusRodadaEnum.ATACAR.equals(statusRodada)) {
            statusRodada = StatusRodadaEnum.PARAR;
        }
    }
}
