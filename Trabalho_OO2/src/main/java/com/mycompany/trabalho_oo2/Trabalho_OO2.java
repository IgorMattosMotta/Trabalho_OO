/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalho_oo2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Trabalho_OO2 {

    public static void main(String[] args) {
        Menu menu = new Menu();
        
         try{
             menu.menu();
        }catch (RuntimeException e) {
            System.out.println("Método inválido!");
            menu.menu();
        }
    }
}
        