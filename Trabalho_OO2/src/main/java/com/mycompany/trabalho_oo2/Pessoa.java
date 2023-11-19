/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

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

    public Cadastro getCadastro() {
        return cadastro;
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


     

    public Pessoa(String cpf, String nome, String cargo, String senha) {
        validaPessoa(cpf, nome, cargo);
        this.cpf = new CPF(cpf);
        this.nome = new Nome(nome);
        this.cargo = new Cargo(cargo);  
        this.senha = senha;
        
    }
        
    public void validaPessoa(String cpf, String nome, String cargo){
            cadastro = new Cadastro(cpf, nome, cargo);
            cadastro.validaCadastro(cpf, nome);
    }
    
}
