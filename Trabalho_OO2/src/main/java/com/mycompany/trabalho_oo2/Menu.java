/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author igorm
 */
public class Menu {
        private ArrayList<Pessoa> pessoasLista = new ArrayList<>();
        private int escolha;
        private Scanner sc = new Scanner(System.in);

    public Menu() {
        this.escolha = 0;
    }
                          
    public void menu(){
            while (escolha != 4) {
                System.out.println("=== Menu ===");
                System.out.println("1. Cadastro");
                System.out.println("2. Listar pessoas");
                System.out.println("3. Apagar Pessoa");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                escolha = Integer.parseInt(sc.nextLine());
                switch (escolha) {
                    case 1 -> {
                            try{
                                Scanner s = new Scanner(System.in); 
                                String cpf = s.nextLine();
                                String nome = s.nextLine();
                                String cargo = s.nextLine();
                                String senha = s.nextLine();
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
                        String cpf = sc1.nextLine();
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
                    case 4 -> {
                        System.out.println("Saindo do programa...");
                    }
                    default -> throw new RuntimeException("Opção inválida. Tente novamente.");
                }
        }
    }
}
