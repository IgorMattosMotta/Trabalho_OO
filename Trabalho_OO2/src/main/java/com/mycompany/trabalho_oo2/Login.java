/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.Scanner;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Login {
    private Pessoas p;
    private Scanner sc = new Scanner(System.in);
    private String senha;
    private final String cpf;

    public Pessoas getP() {
        return p;
    }
    
    
    
    public Login(String cpf) {
        this.p = null;
        this.cpf = cpf;
    }
    
     public void Loga(){
         ehLogavel();
         if(this.p == null){
             throw new RuntimeException();
         }
     }
    
    private void ehLogavel(){
        for(Pessoas e: p.lista){
            System.out.println(e.getCpf() + "="+this.cpf);
            if(e.getCpf().equals(this.cpf)){
                System.out.println("Senha:");
                senha = sc.nextLine();
                if(senha.equals(e.getSenha())){
                    this.p = e;
                }
            }
        }
    }
    
}
