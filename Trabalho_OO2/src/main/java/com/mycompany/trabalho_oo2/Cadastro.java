/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.ArrayList;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Cadastro {
    private CPF cpf;
    private Nome nome;
    private Cargo cargo;
    ArrayList<Pessoas> lista2 =new ArrayList<>();
    public Cadastro(String cpf, String nome, String cargo, ArrayList<Pessoas> lista) {
        for(Pessoas e: lista){
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
        for(Pessoas e: this.lista2){
            if(e.getCpf().equals(cpf)){
                throw new RuntimeException("Usuário já cadastrado!");
            }
        }
    }
    
    
    
}
