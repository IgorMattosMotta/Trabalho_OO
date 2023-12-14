package com.mycompany.trabalho_oo2.aplicacao;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025

import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Login extends JFrame {
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Jogador jogador;
    private ArrayList<Jogador> jogadoresLista = new ArrayList<>();
    private ArrayList<Admin> adminLista = new ArrayList<>();
    private ArrayList<Tecnico> tecnicosLista = new ArrayList<>();

    public Login(ArrayList<Jogador> jogadoresLista, ArrayList<Admin> adminLista, ArrayList<Tecnico> tecnicosLista){
        this.jogadoresLista = jogadoresLista;
        this.adminLista = adminLista;
        this.tecnicosLista = tecnicosLista;
        inicializar();
    }

    private void inicializar(){
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTopo(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlFormulario(), BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }



    public JPanel getPnlTitulo(){
        if(pnlTitulo == null){
            pnlTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Login");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,2));
            JLabel lblId = new JLabel("CPF");
            JLabel lblSenha = new JLabel("Senha");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblSenha);


            JTextField lblId2 = new JTextField("");
            try {
                lblId2.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                            evt.consume(); // Ignora caracteres não numéricos
                        }
                    }
                });
            }catch (Exception e){
                new RuntimeException("Esse erro se deve ao listener, mas não causa alteração no desenvolvimento do código!");
            }
            JPasswordField lblSenha2 = new JPasswordField();//jogador.nome

            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblSenha2);

            JButton btnLogar = new JButton("Logar");
            btnLogar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String cpf = CPF.validacpf(lblId2.getText());
                    String senha = String.valueOf(lblSenha2.getPassword());

                    if (cpf != null) {
                        if(ValidaLogin2.valida(cpf, senha, jogadoresLista, tecnicosLista, adminLista)) {
                            dispose();
                        }
                    }
                }
            });
            JButton btnSair = new JButton("Sair");
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Chama dispose() para fechar a janela
                    dispose();
                }
            });
            btnSair.addActionListener(e -> dispose());
            pnlFormulario.add(btnLogar);
            pnlFormulario.add(btnSair);

        }
        return pnlFormulario;
    }



    public JPanel getPnlTopo(){
        if(pnlTopo == null){
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Login");
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
