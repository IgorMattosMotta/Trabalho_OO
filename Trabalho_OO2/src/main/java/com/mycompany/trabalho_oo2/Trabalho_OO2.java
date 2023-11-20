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
         ArrayList<Pessoa> pessoasLista = new ArrayList<>();
         int escolha;
       
                System.out.println("=== Menu ===");
                System.out.println("1. Cadastro");
                System.out.println("2. Listar pessoas");
                System.out.println("3. Apagar Pessoa");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                
                Scanner sc = new Scanner(System.in); 
                 try{
                      Integer.parseInt(sc.nextLine());
                 }catch (RuntimeException e) {
                    System.out.println("Método inválido!");
                }
                escolha = Integer.parseInt(sc.nextLine());
               
            while (escolha != 4) {

                switch (escolha) {
                    case 1 -> {
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
                        }
                    case 2 -> {
                        for(Pessoa e: pessoasLista){
                            System.out.println(e.getCpf().getCpf());
                        }
                        }
                    case 3 -> {
                        Scanner sc1 = new Scanner(System.in);
                        String cpf = sc.nextLine();
                        int i = 0;
                        cpf = cpf.replace(".", "");
                        cpf = cpf.replace("-", "");
                        for(Pessoa e: pessoasLista){
                            if(e.getCpf().getCpf().equals(cpf)){
                                pessoasLista.remove(i);
                            }
                            i++;
                        }
                        }
                    case 4 -> System.out.println("Saindo do programa...");
                    default -> throw new RuntimeException("Opção inválida. Tente novamente.");
                }
        }
    }
}
        