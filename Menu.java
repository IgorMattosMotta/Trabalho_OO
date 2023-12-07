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
        private ArrayList<Pessoas> pessoasLista = new ArrayList<>();
        private int escolha;
        private Scanner sc = new Scanner(System.in);
        private Pessoa user;

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
                System.out.println("5. Login");
                System.out.println("6. Ver usuário:");
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
                                Pessoas eu = new Pessoas(cpf, nome, cargo, senha, pessoasLista);
                                pessoasLista.add(eu);
                           }catch(RuntimeException e){
                               System.out.println(e.getMessage());
                           }
                            }
                    case 2 -> {
                        for(Pessoas e: pessoasLista){
                            System.out.println(e.getCpf());
                        }
                        }
                    case 3 -> {
                        String cpf = sc.nextLine();
                        cpf = cpf.replace(".", "");
                        cpf = cpf.replace("-", "");
                        for(Pessoas e: pessoasLista){
                            if(e.getCpf().equals(cpf)){
                                pessoasLista.remove(e);
                                break;
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Saindo do programa...");
                    }
                    case 5->{
                        Scanner s = new Scanner(System.in); 
                         String cpf = s.nextLine();
                         try{
                            Login login = new Login(cpf);
                            login.Loga();
                            user = login.getP();
                         }catch(RuntimeException e){
                             System.out.println("Login inválido!!!");
                         }
                         
                    }
                    case 6->{
                        if(user != null){
                            System.out.println(user.getCpf());
                        }
                    }
                    default -> throw new RuntimeException("Opção inválida. Tente novamente.");
                }
        }
    }
}
