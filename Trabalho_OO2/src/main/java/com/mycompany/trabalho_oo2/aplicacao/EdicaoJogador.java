package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EdicaoJogador extends JFrame {
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Jogador jogador;
    private Session session;

    private ArrayList<Time> times;
    private ArrayList<Jogador> jogadores;


    public EdicaoJogador(Session session, Jogador jogador) {
        this.session = session;
        this.jogador = jogador;

        this.times = new ArrayList<>();
        this.jogadores = new ArrayList<>();
        LeJson leJson = new LeJson();
        leJson.getTimes(this.times);
        leJson.getJogador(this.jogadores, this.times);
        inicializar(session);
    }

    private void inicializar(Session session) {
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

    public JPanel getPnlTitulo() {
        if (pnlTitulo == null) {
            pnlTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Jogador");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario() {
        if (pnlFormulario == null) {
            pnlFormulario = new JPanel(new GridLayout(0, 5));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblNumCamisa = new JLabel("Num Camisa");
            JLabel lblTime = new JLabel("Time");
            JLabel lblTitular1 = new JLabel("Titular");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblNumCamisa);
            pnlFormulario.add(lblTime);
            pnlFormulario.add(lblTitular1);

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
            JTextField lblNumCamisa2 = new JTextField(String.valueOf(this.jogador.getNumCamisa()));
            lblNumCamisa2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                        evt.consume(); // Ignora caracteres não numéricos
                    }
                }
            });

            // Lista de times
            String[] timesArray = new String[this.times.size()];
            for (Time time : this.times) {
                timesArray[this.times.indexOf(time)] = time.getId() + " - " + time.getNomeTime();
            }
            //String[] timesArray = {"vasco","cruzeiro"};

            // Criar um modelo para a lista
            DefaultComboBoxModel<String> lblTime2 = new DefaultComboBoxModel<>(timesArray);

            // Criar a lista com base no modelo
            JComboBox<String> listaDeTimes = new JComboBox<>(lblTime2);

            String[] titularArray = new String[2];
            titularArray[0] = "Titular";
            titularArray[1] = "Reserva";
            DefaultComboBoxModel<String> lblTitular = new DefaultComboBoxModel<>(titularArray);
            JComboBox<String> listaDeTitular = new JComboBox<>(lblTitular);

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

            JButton btnSalvar = new JButton("Salvar");
            btnSalvar.addActionListener(e -> {
                //Salvar
                boolean titular = false;
                if (listaDeTitular.getSelectedItem().toString().equals("Titular")) {
                    titular = true;
                } else if (listaDeTitular.getSelectedItem().toString().equals("Reserva")) {
                    titular = false;
                }
                int idTime = Integer.parseInt(listaDeTimes.getSelectedItem().toString().split(" - ")[0]);

                StringBuilder cpfFormatado = new StringBuilder(this.jogador.getCpf());
                cpfFormatado.insert(9, '-').insert(6, '.').insert(3, '.');

                EditaJson editaJson = new EditaJson();
                editaJson.editaJogador(this.jogadores, this.times, cpfFormatado.toString(), lblNome2.getText(), Integer.parseInt(lblNumCamisa2.getText()), idTime, titular);
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                new MenuApp(this.session).setVisible(true);
                dispose();
            });

            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblNome2);
            pnlFormulario.add(lblNumCamisa2);
            pnlFormulario.add(listaDeTimes);
            pnlFormulario.add(listaDeTitular);
            pnlFormulario.add(btnSalvar);

        }
        return pnlFormulario;
    }

    public JPanel getPnlRodape() {
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

    public JPanel getPnlTopo() {
        if (pnlTopo == null) {
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Nome: Álvaro | Administrador");
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
