/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Dados_Pessoas {
    private String cpf;
    private String senha;
    private int cargo;
    final Pessoas p;
    
   

    public Dados_Pessoas(Pessoas pessoa) {
        this.p = pessoa;
        this.cpf = pessoa.getCpf();
        this.cargo = pessoa.getCargo();
        this.senha = pessoa.getSenha();
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
    
}
