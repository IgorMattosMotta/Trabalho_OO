/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Tecnico extends Pessoa{
    private final Time time;


    public Tecnico(String cpf, String nome, String cargo, String senha, Time time) {
        super(cpf, nome, cargo, senha);
        this.time = time;
    }

    /**
     *
     * @return
     */
    public Time getTime() {
        return time;
    }
    
}
