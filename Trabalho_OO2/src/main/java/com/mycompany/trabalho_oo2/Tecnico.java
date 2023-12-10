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
    private Time time;

    public Tecnico(CPF cpf, String nome, int cargo, String senha, Time time) {
        super(cpf,nome,cargo,senha);
        this.time = time;
    }

    public Time getTime() {
        return time;
    }
    
}
