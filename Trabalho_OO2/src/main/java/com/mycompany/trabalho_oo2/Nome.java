/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025

public class Nome {
    
    private static String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Nome.nome = nome;
    }
  
    public void validaNome(){
         ehValido(Nome.nome);
    }

    public Nome(String nome) {
        Nome.nome = nome;
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
