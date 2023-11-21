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
    private final CPF cpf;
    private Nome nome;
    private Cargo cargo;
    private String senha;
    private Cadastro cadastro;
    private ArrayList<Pessoa> lista=new ArrayList<>();

    public CPF getCpf() {
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

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }


     

    public Pessoa(String cpf, String nome, String cargo, String senha, ArrayList<Pessoa> pessoasLista) {
        for(Pessoa e: pessoasLista){
            this.lista.add(e);
        }
        validaPessoa(cpf, nome, cargo);
        this.cpf = new CPF(cpf);
        this.nome = new Nome(nome);
        this.cargo = new Cargo(cargo);  
        this.senha = senha;
    }
        
    public void validaPessoa(String cpf, String nome, String cargo){
        cadastro = new Cadastro(cpf, nome, cargo, this.lista);
        try{
            
            cadastro.validaCadastro(cpf, nome);
        }catch(RuntimeException e){
             throw new RuntimeException(e.getMessage()+"\nCadastro inválido! Verifique se os campos foram preenchidos corretamente!");
        }
    }
    
}
