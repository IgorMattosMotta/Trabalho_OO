/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Cadastro {
    private CPF cpf;
    private Nome nome;
    private Cargo cargo;

    public Cadastro(String cpf, String nome, String cargo) {
        this.cpf = new CPF(cpf);
        this.nome = new Nome(nome);
        this.cargo = new Cargo(cargo);  
    }
    
    public void validaCadastro(String cpf, String nome){
        this.cpf.validacpf(cpf);
        this.nome.validaNome();

    }
    
    
    
}
