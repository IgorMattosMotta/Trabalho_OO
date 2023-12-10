package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.Jogador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public abstract class EdicaoJogador extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Jogador jogador;


    public EdicaoJogador(){
        inicializar();
    }

    private void inicializar(){
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
            JLabel lblTitulo = new JLabel("Jogadores");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,5));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblNumGols = new JLabel("Num Gols");
            JLabel lblNumCamisa = new JLabel("Num Camisa");
            JLabel lblTime = new JLabel("Time");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblNumGols);
            pnlFormulario.add(lblNumCamisa);
            pnlFormulario.add(lblTime);

            JLabel lblId2 = new JLabel("1");//jogador.getCpf()
            JTextField lblNome2 = new JTextField("Gabriel Barbosa");//jogador.nome
            //Ve se é string
            lblNome2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch)) {
                        evt.consume();
                    }
                }
            });
            JTextField lblNumGols2 = new JFormattedTextField("3");
            lblNumGols2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                        evt.consume(); // Ignora caracteres não numéricos
                    }
                }
            });
            JTextField lblNumCamisa2 = new JTextField("10");
            lblNumCamisa2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                        evt.consume(); // Ignora caracteres não numéricos
                    }
                }
            });
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
            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblNome2);
            pnlFormulario.add(lblNumGols2);
            pnlFormulario.add(lblNumCamisa2);
            pnlFormulario.add(listaDeTimes);

        }
        return pnlFormulario;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            JButton btnVoltar = new JButton("Voltar");
            JButton btnSair = new JButton("Sair");
            JButton btnCadastro = new JButton("Salvar");
            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnCadastro);
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
