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
    private static String cargo;

    public Cargo(String cargo) {
        Cargo.cargo = cargo;
    }

    

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        Cargo.cargo = cargo;
    }
}