/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.ArrayList;

/**
 *
 * @author igorm
 */
public class Pessoas extends Pessoa{

    public Pessoas(CPF cpf, Nome nome, Cargo cargo, String senha, ArrayList<Pessoas> lista) {
        super(cpf, nome, cargo, senha);
    }


    @Override
    public void validaPessoa(CPF cpf, Nome nome, Cargo cargo) {
        super.validaPessoa(cpf, nome, cargo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


    
}
