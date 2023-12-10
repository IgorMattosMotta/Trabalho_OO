/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Admin extends Pessoa{
    private Jogador jogador;

  

    public Admin(CPF cpf, String nome, int cargo, String senha) {
        super(cpf,nome,cargo,senha);
    }
    public void setNumGols(Jogador jogador, int addNum){
         this.jogador = jogador;
    }
}
