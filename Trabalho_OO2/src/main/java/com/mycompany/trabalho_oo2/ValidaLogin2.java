package com.mycompany.trabalho_oo2;






import com.mycompany.trabalho_oo2.aplicacao.MenuApp;

import javax.swing.*;


import java.util.ArrayList;



public class ValidaLogin2 {

    public static boolean valida(String cpf, String senha, int cargo, ArrayList<Jogador> jogadoresLista, ArrayList<Tecnico> tecnicosLista, ArrayList<Admin> adminLista) {
        return ehValido(cpf, senha, jogadoresLista, tecnicosLista, adminLista) > 0 && ehValido(cpf, senha, jogadoresLista, tecnicosLista, adminLista) < 4;
    }

    private static int ehValido(String cpf, String senha, ArrayList<Jogador> jogadoresLista, ArrayList<Tecnico> tecnicosLista, ArrayList<Admin> adminLista) {
        boolean passouCPF = false;
        int cargo = 0;

        if (CPF.ehValido(cpf)) {
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
                                cargo = 3;
                                return cargo; // Retorna true se MenuApp for aberto
                            }
                        }
                    }
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
                                cargo = 2;
                                return cargo; // Retorna true se MenuApp for aberto
                            }
                        }
                        System.out.println(cpf + "   " + j.getCpf());
                    }
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
                                cargo = 1;
                                return cargo; // Retorna true se MenuApp for aberto
                            }
                        }
                    }
            }

            if (!passouCPF) {
                JOptionPane.showMessageDialog(null, "CPF NÃO ENCONTRADO!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        return cargo;
    }
}
