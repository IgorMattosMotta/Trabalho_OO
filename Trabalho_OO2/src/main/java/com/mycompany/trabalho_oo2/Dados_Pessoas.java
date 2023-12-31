/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Dados_Pessoas {
    private String cpf;
    private String senha;
    private String cargo;
    final Pessoas p;

    public Dados_Pessoas(Pessoas pessoa) {
        this.p = pessoa;
        this.cpf = pessoa.getCpf();
        this.cargo =pessoa.getCargo();
        this.senha = pessoa.getNome();
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
