package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.Jogador;
import com.mycompany.trabalho_oo2.LeJson;
import com.mycompany.trabalho_oo2.Session;
import com.mycompany.trabalho_oo2.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class EdicaoJogador extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Jogador jogador;
    private Session session;

    private ArrayList<Time> times;


    public EdicaoJogador(Session session, Jogador jogador){
        this.session = session;
        this.jogador = jogador;

        LeJson leJson = new LeJson();
        leJson.getTimes(this.times);
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
            JLabel lblTitulo = new JLabel("Jogador");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,5));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblNumCamisa = new JLabel("Num Camisa");
            JLabel lblTime = new JLabel("Time");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblNumCamisa);
            pnlFormulario.add(lblTime);

            JLabel lblId2 = new JLabel(this.jogador.getCpf());//jogador.getCpf()
            JTextField lblNome2 = new JTextField(this.jogador.getNome());//jogador.nome
            //Ve se é string
            lblNome2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch)) {
                        evt.consume();
                    }
                }
            });
            JTextField lblNumCamisa2 = new JTextField(this.jogador.getNumCamisa());
            lblNumCamisa2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                        evt.consume(); // Ignora caracteres não numéricos
                    }
                }
            });

            // Lista de times
            String[] timesArray = new String[times.size()];
            for (Time time : times) {
                timesArray[times.indexOf(time)] = time.getId()+" - "+time.getNomeTime();
            }

            // Criar um modelo para a lista
            DefaultComboBoxModel<String> lblTime2 = new DefaultComboBoxModel<>(timesArray);

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
