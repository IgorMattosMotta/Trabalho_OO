package com.mycompany.trabalho_oo2;


import com.mycompany.trabalho_oo2.aplicacao.MenuApp;

import javax.swing.*;


import java.util.ArrayList;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025


public class ValidaLogin2 {

    public static boolean valida(String cpf, String senha, ArrayList<Jogador> jogadoresLista, ArrayList<Tecnico> tecnicosLista, ArrayList<Admin> adminLista) {
        int x  = ehValido(cpf, senha, jogadoresLista, tecnicosLista, adminLista);
        return x < 4 && x > 0;
    }

    private static int ehValido(String cpf, String senha, ArrayList<Jogador> jogadoresLista, ArrayList<Tecnico> tecnicosLista, ArrayList<Admin> adminLista) {
        boolean passouCPF = false;
        int cargo = -1;

        if (CPF.ehValido(cpf)) {
            for (Admin j : adminLista) {
                if (j.getCpf().equals(cpf)) {
                    if (!j.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "SENHA INCORRETA!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                        passouCPF = true;
                        break;
                    } else {
                        Session session = new Session(j.getCargo(), j.getCpf(), j.getNome());
                        MenuApp m = new MenuApp(session);
                        m.setVisible(true);
                        passouCPF = true;
                        cargo = 1;
                        return cargo;
                    }
                }
            }
                    for (Jogador j : jogadoresLista) {
                        if (j.getCpf().equals(cpf)) {
                            if (!j.getSenha().equals(senha)) {
                                JOptionPane.showMessageDialog(null, "SENHA INCORRETA!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                                passouCPF = true;
                                break;
                            } else {
                                    Session session = new Session(j.getCargo(), j.getCpf(), j.getNome());
                                    MenuApp m = new MenuApp(session);
                                    m.setVisible(true);
                                passouCPF = true;
                                cargo = 3;
                                return cargo;
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
                                    Session session = new Session(j.getCargo(), j.getCpf(), j.getNome());
                                    MenuApp m = new MenuApp(session);
                                    m.setVisible(true);
                                passouCPF = true;
                                cargo = 2;
                                return cargo;
                            }
                        }
                        System.out.println(cpf + "   " + j.getCpf());
                    }

            }

            if (!passouCPF) {
                JOptionPane.showMessageDialog(null, "CPF NÃO ENCONTRADO!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        return cargo;
    }
}
