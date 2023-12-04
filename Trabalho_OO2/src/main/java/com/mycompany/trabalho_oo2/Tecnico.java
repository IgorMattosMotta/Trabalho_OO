/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Tecnico extends Pessoa{
    private String time;


    public Tecnico(CPF cpf, Nome nome, Cargo cargo, String senha) {
        super(cpf,nome,cargo,senha);
    }

    public String getTime() {
        return time;
    }
    
}
