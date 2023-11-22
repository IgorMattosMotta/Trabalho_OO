/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Login {
    Pessoas p;
    
    
    public Login(Pessoas pessoa) {
        this.p = pessoa;
    }
    
    public String RetornaCargo(){
        if(p.getCargo().equals("Admin")){
            return "Admin";
        }else if(p.getCargo().equals("Tecnico")){
            return "Tecnico";
        }else{
            return "Jogador";
        }
    }
    
}
