/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.ArrayList;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025

public abstract class Pessoa {
    private final String cpf;
    private String nome;
    private int cargo;
    private String senha;
    public ArrayList<Pessoas> lista=new ArrayList<>();

     public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getCargo() {
        return cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public Pessoa(CPF cpf, String nome, int cargo, String senha) {
        Cadastro cadastro = new Cadastro(cpf, nome, cargo, this.lista);
        try{
            cadastro.validaCadastro(cpf, nome);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        this.cpf = CPF.getCpf();
        this.cargo =cargo;
        this.nome = nome;
        this.senha = senha;
    }

    public void validaPessoa(CPF cpf, String nome, int cargo){
        Cadastro cadastro = new Cadastro(cpf, nome, cargo, this.lista);
        try{
            cadastro.validaCadastro(cpf, nome.toString());
        }catch(RuntimeException e){
             throw new RuntimeException(e.getMessage()+"\nCadastro inválido! Verifique se os campos foram preenchidos corretamente!");
        }
    }

    public boolean validarSenha(String senha){
        return this.getSenha().equals(senha);
    }
}
