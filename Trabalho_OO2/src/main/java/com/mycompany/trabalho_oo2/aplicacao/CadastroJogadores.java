package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CadastroJogadores extends JFrame implements InterfacePadrao{

        protected JPanel pnlTopo;
        protected JPanel pnlRodape;
        protected JPanel pnlTitulo;
        protected JPanel pnlFormulario;

        private Jogador jogador;
        private Session session;


        public CadastroJogadores(Session session){
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
                JLabel lblTitulo = new JLabel("Cadastro Jogadores");
                pnlTitulo.add(lblTitulo);
            }
            return pnlTitulo;
        }

        public JPanel getPnlFormulario(){
            if(pnlFormulario == null){
                pnlFormulario = new JPanel(new GridLayout(0,4));
                JLabel lblId = new JLabel("CPF");
                JLabel lblNome = new JLabel("Nome");
                JLabel lblNumCamisa = new JLabel("Num Camisa");
                JLabel lblTime = new JLabel("Time");

                pnlFormulario.add(lblId);
                pnlFormulario.add(lblNome);
                pnlFormulario.add(lblNumCamisa);
                pnlFormulario.add(lblTime);

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
                JTextField lblNumCamisa2 = new JTextField("Escreva número de camisa:");
                lblNumCamisa2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                            evt.consume(); // Ignora caracteres não numéricos
                        }
                    }
                });
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

                // Criar um botão para obter a seleção
                JButton botao = new JButton("Obter Seleção");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblNome2);
                pnlFormulario.add(lblNumCamisa2);
                pnlFormulario.add(lblTime2);


                /*private int reflexo;
                private int chute;
                private int marcação;
                private int passe;
                private int velocidade;*/

                JLabel lblReflexo = new JLabel("Reflexo");
                JLabel lblChute = new JLabel("Chute");
                JLabel lblMarcacao = new JLabel("Marcação");
                JLabel lblPasse = new JLabel("Passe");
                JLabel lblVelocidade = new JLabel("Velocidade");





                pnlFormulario.add(lblReflexo);
                pnlFormulario.add(lblChute);
                pnlFormulario.add(lblMarcacao);
                pnlFormulario.add(lblPasse);



                JTextField lblReflexo2 = new JTextField("Escreva Reflexo");
                JTextField lblChute2 = new JTextField("Escreva Chute");
                JTextField lblMarcacao2 = new JTextField("Escreva Marcacao");
                JTextField lblPasse2 = new JTextField("Escreva Chute");
                JTextField lblVelocidade2 = new JTextField("Escreva Velocidade");




                lblReflexo2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                            evt.consume(); // Ignora caracteres não numéricos
                        }
                    }
                });

                lblChute2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                            evt.consume(); // Ignora caracteres não numéricos
                        }
                    }
                });
                lblMarcacao2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                            evt.consume(); // Ignora caracteres não numéricos
                        }
                    }
                });
                lblPasse2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                            evt.consume(); // Ignora caracteres não numéricos
                        }
                    }
                });
                lblVelocidade2.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char ch = evt.getKeyChar();
                        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
                            evt.consume(); // Ignora caracteres não numéricos
                        }
                    }
                });

                pnlFormulario.add(lblReflexo2);
                pnlFormulario.add(lblChute2);
                pnlFormulario.add(lblPasse2);
                pnlFormulario.add(lblMarcacao2);
                pnlFormulario.add(lblVelocidade);


                JLabel lblSenha = new JLabel("Senha");
                JLabel lblPosicao = new JLabel("Posicao");
                JCheckBox lblTitular = new JCheckBox("Jogador é titular?");

                pnlFormulario.add(lblSenha);
                pnlFormulario.add(lblPosicao);
                pnlFormulario.add(lblTitular);
                pnlFormulario.add(lblVelocidade2);

                JPasswordField lblSenha2 = new JPasswordField();
                // Lista de times
                String[] posicoes = {"AT", "MC", "ZAG", "G"};

                // Criar um modelo para a lista
                DefaultComboBoxModel<String> posicao = new DefaultComboBoxModel<>(posicoes);

                // Criar a lista com base no modelo
                JComboBox<String> lblPosicao2 = new JComboBox<>(posicao);

                pnlFormulario.add(lblSenha2);
                pnlFormulario.add(lblPosicao2);


            JButton btnCadastro = new JButton("Salvar");
            btnCadastro.addActionListener(e -> {
                ArrayList<Jogador> jogadores = new ArrayList<>();
                ArrayList<Time> Listatimes = new ArrayList<>();
                l.getTimes(Listatimes);
                l.getJogador(jogadores, Listatimes);

                Time time1 = (Time) lblTime2.getSelectedItem();
                AdicionaJson a = new AdicionaJson(session);
                try {
                    a.adicionaJogador(jogadores, Listatimes, String.valueOf(lblId2.getText()), String.valueOf(lblNome2.getText()).replaceAll("[.]", "").replaceAll("-", ""), 3, String.valueOf(lblSenha2.getPassword()), lblPosicao2.getSelectedItem().toString(), Integer.parseInt(String.valueOf(lblNumCamisa2.getText())), time1.getId(), lblTitular.isSelected(), Integer.parseInt(String.valueOf(lblReflexo2.getText())), Integer.parseInt(String.valueOf(lblChute2.getText())), Integer.parseInt(String.valueOf(lblMarcacao2.getText())), Integer.parseInt(String.valueOf(lblPasse2.getText())), Integer.parseInt(String.valueOf(lblVelocidade2.getText())));
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
                btnVoltar.addActionListener(e -> {
                    new MenuApp(this.session).setVisible(true);
                    dispose();
                });



                pnlRodape.add(btnVoltar);
                pnlRodape.add(btnSair);
            }
            return pnlRodape;
        }

        public JPanel getPnlTopo(){
            if(pnlTopo == null){
                pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JLabel lblTitulo = new JLabel(session.getNome() + " | " + Session.getNomeCargo(session.getCargo()));
                pnlTopo.add(lblTitulo);
            }
            return pnlTopo;
        }
    }
