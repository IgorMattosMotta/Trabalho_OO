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
public class Cadastro {
    private CPF cpf;
    private Nome nome;
    private Cargo cargo;
    ArrayList<Pessoa> lista2 =new ArrayList<>();
    public Cadastro(String cpf, String nome, String cargo, ArrayList<Pessoa> lista) {
        for(Pessoa e: lista){
            this.lista2.add(e);
        }
        this.cpf = new CPF(cpf);
        this.nome = new Nome(nome);
        this.cargo = new Cargo(cargo);  
       
    }
    
    public void validaCadastro(String cpf, String nome){
        try{
            this.cpf.validacpf(cpf);
        }catch(RuntimeException e){
            throw new RuntimeException("Uso de caracteres inválidos (CPF)!");
        }
        this.nome.validaNome();
        for(Pessoa e: this.lista2){
            if(e.getCpf().getCpf().equals(cpf)){
                throw new RuntimeException("Usuário já cadastrado!");
            }
        }
    }
    
    
    
}
