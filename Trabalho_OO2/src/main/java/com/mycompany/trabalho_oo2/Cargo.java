/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
public class Cargo {
    private static int cargo;

    public Cargo(int cargo) {
        Cargo.setCargo(cargo);
    }

    

    public int getCargo() {
        return cargo;
    }

    public static void setCargo(int cargo) {
        Cargo.cargo = cargo;
    }
}