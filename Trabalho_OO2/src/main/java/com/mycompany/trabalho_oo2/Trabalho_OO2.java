/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalho_oo2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author igorm
 */
public class Trabalho_OO2 {

    public static void main(String[] args) {
        /*Menu menu = new Menu();
        
         try{
             menu.menu();
        }catch (RuntimeException e) {
            System.out.println("Método inválido!");
            menu.menu();
        }*/

        ArrayList<Time> timesLista = new ArrayList<>();
        ArrayList<Partida> partidasLista = new ArrayList<>();
        ArrayList<Tecnico> tecnicosLista = new ArrayList<>();
        ArrayList<Jogador> jogadoresLista = new ArrayList<>();
        LeJson leJson = new LeJson();
        leJson.getTimes(timesLista);
        leJson.getPartidas(partidasLista, timesLista);
        leJson.getTecnico(tecnicosLista,timesLista);
        leJson.getJogador(jogadoresLista,timesLista);

    }
}
        