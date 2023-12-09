/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Cargo {
    private static int cargo;

    public Cargo(int cargo) {
        Cargo.cargo = cargo;
    }

    

    public static int getCargo() {
        return cargo;
    }

    public static void setCargo(int cargo) {
        Cargo.cargo = cargo;
    }
}