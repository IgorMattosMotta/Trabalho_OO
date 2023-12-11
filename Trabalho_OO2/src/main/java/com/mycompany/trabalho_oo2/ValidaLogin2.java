package com.mycompany.trabalho_oo2;






import com.mycompany.trabalho_oo2.aplicacao.MenuApp;

import javax.swing.*;


import java.util.ArrayList;



public class ValidaLogin2 {

    public static boolean valida(String cpf, String senha, int cargo, ArrayList<Jogador> jogadoresLista, ArrayList<Tecnico> tecnicosLista, ArrayList<Admin> adminLista) {
        return ehValido(cpf, senha, cargo, jogadoresLista, tecnicosLista, adminLista);
    }

    private static boolean ehValido(String cpf, String senha, int cargo, ArrayList<Jogador> jogadoresLista, ArrayList<Tecnico> tecnicosLista, ArrayList<Admin> adminLista) {
        boolean passouCPF = false;

        if (CPF.ehValido(cpf)) {
            switch (cargo) {
                case 3:
                    for (Jogador j : jogadoresLista) {
                        if (j.getCpf().equals(cpf)) {
                            if (!j.getSenha().equals(senha)) {
                                JOptionPane.showMessageDialog(null, "SENHA INCORRETA!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                                passouCPF = true;
                                break;
                            } else {
                                    MenuApp m = new MenuApp();
                                    m.setVisible(true);
                                passouCPF = true;
                                return true; // Retorna true se MenuApp for aberto
                            }
                        }
                    }
                    break;
                case 2:
                    for (Tecnico j : tecnicosLista) {
                        if (j.getCpf().equals(cpf)) {
                            if (!j.getSenha().equals(senha)) {
                                JOptionPane.showMessageDialog(null, "SENHA INCORRETA!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                                passouCPF = true;
                                break;
                            } else {
                                    MenuApp m = new MenuApp();
                                    m.setVisible(true);
                                passouCPF = true;
                                return true; // Retorna true se MenuApp for aberto
                            }
                        }
                        System.out.println(cpf + "   " + j.getCpf());
                    }
                    break;
                case 1:
                    for (Admin j : adminLista) {
                        if (j.getCpf().equals(cpf)) {
                            if (!j.getSenha().equals(senha)) {
                                JOptionPane.showMessageDialog(null, "SENHA INCORRETA!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                                passouCPF = true;
                                break;
                            } else {
                                    MenuApp m = new MenuApp();
                                    m.setVisible(true);
                                passouCPF = true;
                                return true; // Retorna true se MenuApp for aberto
                            }
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "CARGO INVÁLIDO!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }

            if (!passouCPF) {
                JOptionPane.showMessageDialog(null, "CPF NÃO ENCONTRADO!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        return false; // Retorna false se MenuApp não for aberto
    }
}
