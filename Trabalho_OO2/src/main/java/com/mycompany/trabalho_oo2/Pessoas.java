/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.ArrayList;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Pessoas extends Pessoa{
    
        

    

    public Pessoas(String cpf, String nome, String cargo, String senha, ArrayList<Pessoas> lista) {

        super(cpf, nome, cargo, senha);
    }


    @Override
    public void validaPessoa(String cpf, String nome, String cargo) {
        super.validaPessoa(cpf, nome, cargo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


    
}
