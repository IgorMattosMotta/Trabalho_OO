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
    private final CPF cpf;
    private String nome;
    private int cargo;
    ArrayList<Pessoas> lista2 =new ArrayList<>();
    public Cadastro(CPF cpf, String nome, int cargo, ArrayList<Pessoas> lista) {
        for(Pessoas e: lista){
            this.lista2.add(e);
        }
        this.cpf = new CPF(CPF.getCpf());
        this.nome = nome;
        this.cargo = cargo;
    }
    
    public void validaCadastro(CPF cpf, String nome){
        try{
            cpf.validacpf(cpf.getCpf());
        }catch(RuntimeException e){
            throw new RuntimeException("Uso de caracteres inválidos (CPF)!");
        }
        Nome.ehValido(nome);
        for(Pessoas e: this.lista2){
            if(e.getCpf().equals(cpf)){
                throw new RuntimeException("Usuário já cadastrado!");
            }
        }
    }
    
    
    
}
