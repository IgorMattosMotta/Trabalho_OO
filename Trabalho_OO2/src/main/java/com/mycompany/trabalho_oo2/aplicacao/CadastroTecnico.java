/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.Session;
import com.mycompany.trabalho_oo2.Tecnico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
            pnlFormulario = new JPanel(new GridLayout(2,3));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblTime = new JLabel("Time");
            
            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblTime);

            
            
            
           // Lista de times
                String[] times = {"Varmengo", "Barcelona", "Manchester United", "Bayern Munich", "Liverpool"};

                // Criar um modelo para a lista
                DefaultComboBoxModel<String> lblTime2 = new DefaultComboBoxModel<>(times);

                // Criar a lista com base no modelo
                JComboBox<String> listaDeTimes = new JComboBox<>(lblTime2);

                // Criar um botão para obter a seleção
                JButton botao = new JButton("Obter Seleção");
                botao.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Obter a seleção da lista
                        String selecionado = (String) listaDeTimes.getSelectedItem();
                        if (selecionado != null) {
                            JOptionPane.showMessageDialog(null, "Time selecionado: " + selecionado);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum time selecionado.");
                        }
                    }
                });
                

            
           
            
            JTextField lblId3 = new JTextField("");//jogador.getCpf()
            lblId3.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                        evt.consume(); // Ignora caracteres não numéricos
                    }
                }
            });
            JTextField lblSenha2 = new JTextField();
            lblSenha2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isAlphabetic(ch) && !Character.isSpaceChar(ch)) {
                            evt.consume();
                        }
                    }
                });


            pnlFormulario.add(lblId3);
            pnlFormulario.add(lblSenha2);
             pnlFormulario.add(listaDeTimes);
            
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


