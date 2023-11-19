/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalho_oo2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author igorm
 */
public class Trabalho_OO2 {

    public static void main(String[] args) {
         ArrayList<Pessoa> pessoasLista = new ArrayList<>();

        int escolha;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Cadastro");
            System.out.println("2. Listar pessoas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            Scanner sc = new Scanner(System.in);
            escolha = Integer.parseInt(sc.nextLine()); 
            switch (escolha) {
                case 1:
                    try{
                        Scanner sc1 = new Scanner(System.in);
                        String cpf = sc.nextLine();
                        Scanner sc2 = new Scanner(System.in);
                        String nome = sc.nextLine();
                        Scanner sc3 = new Scanner(System.in);
                        String cargo = sc.nextLine();
                        Scanner sc4 = new Scanner(System.in);
                        String senha = sc.nextLine();
                        Pessoa eu = new Pessoa(cpf, nome, cargo, senha, pessoasLista);
                        pessoasLista.add(eu);
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    for(Pessoa e: pessoasLista){
                            System.out.println(e.getCpf().getCpf());
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 3);
    }
}
