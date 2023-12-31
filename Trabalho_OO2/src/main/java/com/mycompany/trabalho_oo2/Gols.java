/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Gols {
    private Partida partida;
    private Jogador jogador;
    private String minutoMarcou;
    private int numGols;
    
    public Gols(Partida partida, Jogador jogador, String minutoMarcou)
    {
        this.partida = partida;
        this.jogador = jogador;
        this.minutoMarcou = minutoMarcou;
        this.numGols = this.numGols+1;
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
    
    public int getNumGols()
    {
        return numGols;
    }
}
