package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public abstract class CadastroAdmin extends JFrame implements InterfacePadrao{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Session session;

    public CadastroAdmin(Session session){
        this.session = session;
        inicializar(session);
    }

    private void inicializar(Session session){


        LeJson l = new LeJson();

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTopo(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlFormulario(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();


    }

    public JPanel getPnlTitulo(){
        if(pnlTitulo == null){
            pnlTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Cadastro de Partida");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }
    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,3));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblSenha = new JLabel("Senha");


            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblSenha);


            JTextField lblId2 = new JTextField("Escreva CPF:");//jogador.getCpf()
            lblId2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isDigit(ch)) {
                        evt.consume();
                    }
                }
            });

            JTextField lblNome2 = new JTextField("Escreva Nome:");//jogador.nome
            //Ve se é string
            lblNome2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch) && !Character.isSpaceChar(ch)) {
                        evt.consume();
                    }
                }
            });

            LeJson l = new LeJson();
            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblNome2);

            JPasswordField lblSenha2 = new JPasswordField();
            pnlFormulario.add(lblSenha2);


            JButton btnCadastro = new JButton("Salvar");
            btnCadastro.addActionListener(e -> {
                ArrayList<Admin> admins = new ArrayList<>();
                l.getAdministrdor(admins);
                AdicionaJson a = new AdicionaJson();
                try {
                    a.adicionaAdmin(admins, String.valueOf(lblId2.getText()), String.valueOf(lblNome2.getText()).replaceAll("[.]", "").replaceAll("-", ""), 1, String.valueOf(lblSenha2.getPassword()));
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!", "Aviso", 1);
                    dispose();
                    MenuApp menu = new MenuApp(session);
                    menu.setVisible(true);

                }catch (RuntimeException erro) {
                    JOptionPane.showMessageDialog(null, "Algum campo não está preenchido de forma correta!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    throw new RuntimeException("Algum campo não está preenchido de forma correta!" + erro.getMessage());
                }
            });


            pnlFormulario.add(btnCadastro);
        }
        return pnlFormulario;
    }
    public JPanel getPnlTopo(){
        if(pnlTopo == null){
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlTopo.add(getPnlTitulo());
            JLabel lblTitulo = new JLabel("Nome: "+session.getNome()+"|"+ Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnVoltar = new JButton("Voltar");

            JButton btnSair = new JButton("Sair");
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Chama dispose() para fechar a janela
                    dispose();
                }
            });
            btnSair.addActionListener(e -> dispose());

            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnSair);
        }
        return pnlRodape;
    }
}
