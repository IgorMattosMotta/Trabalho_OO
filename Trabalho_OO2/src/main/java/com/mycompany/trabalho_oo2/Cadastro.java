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
    ArrayList<Pessoas> lista2 =new ArrayList<>();
    public Cadastro(CPF cpf, Nome nome, Cargo cargo, ArrayList<Pessoas> lista) {
        for(Pessoas e: lista){
            this.lista2.add(e);
        }
        this.cpf = new CPF(CPF.getCpf());
        this.nome = new Nome(Nome.getNome());
        this.cargo = new Cargo(Cargo.getCargo());
    }
    
    public void validaCadastro(CPF cpf, Nome nome){
        try{
            cpf.validacpf(cpf.getCpf());
        }catch(RuntimeException e){
            throw new RuntimeException("Uso de caracteres inválidos (CPF)!");
        }
        nome.validaNome();
        for(Pessoas e: this.lista2){
            if(e.getCpf().equals(cpf)){
                throw new RuntimeException("Usuário já cadastrado!");
            }
        }
    }
    
    
    
}
