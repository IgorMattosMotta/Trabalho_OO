/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Gols {

    private int id;

    private Partida partida;
    private Jogador jogador;
    private String minutoMarcou;

    public Gols(int id, Jogador jogadorGol, Partida partidaGol, String minutoMarcou) {
        this.partida = partidaGol;
        this.jogador = jogadorGol;
        this.minutoMarcou = minutoMarcou;
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public String getMinutoMarcou() {
        return minutoMarcou;
    }

    public int getId() {
        return id;
    }
    
}
