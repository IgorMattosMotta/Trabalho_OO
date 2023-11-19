/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Nome {
    
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public void validaNome(){
         ehValido(this.nome);
    }

    public Nome(String nome) {
        this.nome = nome;
    }
    
     // Verifica se o nome não está vazio
    public static void ehValido(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("Nome não pode ser vazio.");
        }

        // Verifica se o nome contém apenas letras e espaços
        if (!nome.matches("^[a-zA-Z\\s]+$")) {
            throw new RuntimeException("Nome deve conter apenas letras e espaços.");
        }

    }
}
