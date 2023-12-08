/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.ArrayList;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025or igorm
public abstract class Pessoa {
    private final String cpf;
    private String nome;
    private String cargo;
    private String senha;
    public ArrayList<Pessoas> lista=new ArrayList<>();
    
     public String getCpf() {
        return cpf;
    }

     
     
    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public Pessoa(String cpf, String nome, String cargo, String senha) {
        Cadastro cadastro = new Cadastro(cpf, nome, cargo, this.lista);
        try{
            cadastro.validaCadastro(cpf, nome);
        }catch(RuntimeException e){
            throw new RuntimeException("Cadastro inválido!!!"); 
        }
        this.cpf = cpf;
        this.cargo =cargo;
        this.nome = nome;
        this.senha = senha;
    }

    
    
    public void validaPessoa(String cpf, String nome, String cargo){
        Cadastro cadastro = new Cadastro(cpf, nome, cargo, this.lista);
        try{
            cadastro.validaCadastro(cpf, nome);
        }catch(RuntimeException e){
             throw new RuntimeException(e.getMessage()+"\nCadastro inválido! Verifique se os campos foram preenchidos corretamente!");
        }
    }
  
}
