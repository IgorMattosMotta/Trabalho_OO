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
public class Pessoa {
    private final String cpf;
    private Nome nome;
    private Cargo cargo;
    private String senha;
    public ArrayList<Pessoas> lista=new ArrayList<>();
    
     public String getCpf() {
        return cpf;
    }

     
     
    public Nome getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public Pessoa(CPF cpf, Nome nome, Cargo cargo, String senha) {
        Cadastro cadastro = new Cadastro(cpf, nome, cargo, this.lista);
        try{
            cadastro.validaCadastro(cpf, nome);
        }catch(RuntimeException e){
            throw new RuntimeException("Cadastro inválido!!!"); 
        }
        this.cpf = CPF.getCpf();
        this.cargo =cargo;
        this.nome = nome;
        this.senha = senha;
    }

    
    
    public void validaPessoa(CPF cpf, Nome nome, Cargo cargo){
        Cadastro cadastro = new Cadastro(cpf, nome, cargo, this.lista);
        try{
            cadastro.validaCadastro(cpf, nome);
        }catch(RuntimeException e){
             throw new RuntimeException(e.getMessage()+"\nCadastro inválido! Verifique se os campos foram preenchidos corretamente!");
        }
    }
  
}
