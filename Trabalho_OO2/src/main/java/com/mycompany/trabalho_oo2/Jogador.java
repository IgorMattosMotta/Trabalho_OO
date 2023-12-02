/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Jogador extends Pessoa{
    private String posicao;
    private Gols numGols;
    private int numCamisa;
    private String time;
    private boolean titular;


    private Jogador(String cpf, String nome, String cargo, String senha, String posicao, Gols numGols, int numCamisa, String time, boolean titular) {
        super(cpf, nome, cargo, senha);
        this.posicao = posicao;
        this.numGols = numGols;
        this.numCamisa = numCamisa;
        this.time = time;
        this.titular = titular;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getTime() {
        return time;
    }

    public String getPosicao() {
        return posicao;
    }

    public Gols getNumGols() {
        return numGols;
    }

    public int getNumCamisa() {
        return numCamisa;
    }

    public boolean isTitular() {
        return titular;
    }
    
    
}
