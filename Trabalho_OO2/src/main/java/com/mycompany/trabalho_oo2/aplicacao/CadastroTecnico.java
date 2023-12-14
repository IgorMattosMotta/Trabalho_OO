/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author davil
 */
public abstract class CadastroTecnico extends JFrame implements InterfacePadrao{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;
    private Session session;
    
    private Tecnico tecnico;


    public CadastroTecnico(Session session){
        this.session = session;
        inicializar(session);
    }

    private void inicializar(Session session){
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
            JLabel lblTitulo = new JLabel("Técnicos");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,4));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblTime = new JLabel("Time");
            JLabel lblSenha = new JLabel("Senha");
            
            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblTime);
            pnlFormulario.add(lblSenha);




            // Lista de times
            ArrayList<Time> t = new ArrayList<>();
            LeJson l = new LeJson();
            l.getTimes(t);
            Time[] times = new Time[t.size()];
            int i = 0;
            for(Time time: t){
                times[i] = time;
                i++;
            }

            // Criar um modelo para a lista
            DefaultComboBoxModel<Time> time = new DefaultComboBoxModel<>(times);
            // Criar a lista com base no modelo
            JComboBox<Time>  lblTime2 = new JComboBox<>(time);
            
            JTextField lblId2 = new JTextField("");//jogador.getCpf()
            lblId2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                        evt.consume(); // Ignora caracteres não numéricos
                    }
                }
            });
            JTextField lblNome2 = new JTextField();
            lblNome2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isAlphabetic(ch) && !Character.isSpaceChar(ch)) {
                            evt.consume();
                        }
                    }
                });

            JPasswordField lblSenha2 = new JPasswordField();


            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblNome2);
             pnlFormulario.add(lblTime2);
             pnlFormulario.add(lblSenha2);

            JButton btnCadastro = new JButton("Salvar");
            btnCadastro.addActionListener(e -> {
                ArrayList<Tecnico> tecnico = new ArrayList<>();
                ArrayList<Time> times1 = new ArrayList<>();
                l.getTimes(times1);
                l.getTecnico(tecnico, times1);
                AdicionaJson a = new AdicionaJson();
                try {
                    Time time1 = (Time) time.getSelectedItem();
                    String nome = lblNome2.getText().replaceAll("-", "");
                    nome = nome.replaceAll("[.]", "");
                    a.adicionaTecnico(tecnico, times1, String.valueOf(lblId2.getText()), nome, 1, String.valueOf(lblSenha2.getPassword()), time1.getId());
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

    public JPanel getPnlTopo(){
        if(pnlTopo == null){
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Nome: Álvaro | Administrador");
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}


