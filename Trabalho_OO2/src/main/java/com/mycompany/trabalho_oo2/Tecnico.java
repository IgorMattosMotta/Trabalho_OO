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


    public Tecnico(String cpf, String nome, String cargo, String senha, String time) {
        super(cpf, nome, cargo, senha);
        this.time = time;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTime() {
        return time;
    }
    
}
