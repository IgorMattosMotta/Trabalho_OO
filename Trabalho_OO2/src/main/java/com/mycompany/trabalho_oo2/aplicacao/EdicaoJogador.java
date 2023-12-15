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
        LeJson leJson = new LeJson(session);
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


            Checkbox lblTitular = new Checkbox("Marque se o jogador for titular");

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
                try {
                    int idTime = Integer.parseInt(listaDeTimes.getSelectedItem().toString().split(" - ")[0]);

                    EditaJson editaJson = new EditaJson(session);
                    editaJson.editaJogador(this.jogadores, this.times, this.jogador.getCpf(), lblNome2.getText(), Integer.parseInt(lblNumCamisa2.getText()), idTime, lblTitular.getState());
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                    new MenuApp(this.session).setVisible(true);
                    dispose();
                }catch (RuntimeException erro){
                    JOptionPane.showMessageDialog(null, "Algum campo não está preenchido de forma correta!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    throw new RuntimeException("Algum campo não está preenchido de forma correta!" + erro.getMessage());
                }
            });

            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblNome2);
            pnlFormulario.add(lblNumCamisa2);
            pnlFormulario.add(listaDeTimes);
            pnlFormulario.add(lblTitular);
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
            btnVoltar.addActionListener(e -> {
                new ConsultaJogadores(this.session).setVisible(true);
                dispose();
            });

            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnSair);
        }
        return pnlRodape;
    }

    public JPanel getPnlTopo() {
        if (pnlTopo == null) {
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Nome: "+session.getNome()+" | Cargo: "+ Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
