/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
public class Admin extends Pessoa{
    private Jogador jogador;

  

    public Admin(CPF cpf, String nome, int cargo, String senha){
        super(cpf,nome,cargo,senha);
    }
    public void setNumGols(Jogador jogador, int addNum){
         this.jogador = jogador;
    }
}
