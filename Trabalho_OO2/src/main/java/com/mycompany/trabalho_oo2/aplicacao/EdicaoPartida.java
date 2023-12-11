package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.Partida;
import com.mycompany.trabalho_oo2.Session;
import com.mycompany.trabalho_oo2.ValidaHora;
import com.mycompany.trabalho_oo2.ValidaPlacar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EdicaoPartida extends JFrame {

        protected JPanel pnlTopo;
        protected JPanel pnlRodape;
        protected JPanel pnlTitulo;
        protected JPanel pnlFormulario;

        private Partida tecnico;
        private Session session;


        public EdicaoPartida(Session session){
            this.session = session;
            inicializar(this.session);
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
                JLabel lblTitulo = new JLabel("Jogadores");
                pnlTitulo.add(lblTitulo);
            }
            return pnlTitulo;
        }

        public JPanel getPnlFormulario(){
            if(pnlFormulario == null){
                pnlFormulario = new JPanel(new GridLayout(0,5));
                JLabel lblId = new JLabel("ID");
                JLabel lblTimeCasa = new JLabel("Time Casa");
                JLabel lblTimeVisitante = new JLabel("Time Visitante");
                JLabel lblHora = new JLabel("Hora");
                JLabel lblPlacar = new JLabel("Placar");


                pnlFormulario.add(lblId);
                pnlFormulario.add(lblTimeCasa);
                pnlFormulario.add(lblTimeVisitante);
                pnlFormulario.add(lblHora);
                pnlFormulario.add(lblPlacar);

                JLabel lblId2 = new JLabel("1");

                // Lista de times
                String[] times = {"Varmengo", "Barcelona", "Manchester United", "Bayern Munich", "Liverpool"};

                // Criar um modelo para a lista
                DefaultComboBoxModel<String> lblTime2 = new DefaultComboBoxModel<>(times);

                // Criar a lista com base no modelo
                JComboBox<String> listaDeTimes1 = new JComboBox<>(lblTime2);
                JComboBox<String> listaDeTimes2 = new JComboBox<>(lblTime2);

                JTextField lblHora2 = new JTextField("1");

                // Adicionar um ouvinte de foco para exibir a mensagem quando o campo perder o foco
                lblHora2.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        // Quando o campo perde foco, verificar a validação
                        String ch = lblHora2.getText();
                        if (!ValidaHora.validarHora(ch)) {
                            lblHora2.setText("Hora inválida");
                        }
                    }
                });

                JTextField lblPartida2 = new JTextField("1");


                // Adicionar um ouvinte de foco para exibir a mensagem quando o campo perder o foco
                lblPartida2.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        // Quando o campo perde foco, verificar a validação
                        String ch = lblPartida2.getText();
                        if (!ValidaPlacar.validarPlacar(ch)) {
                            lblPartida2.setText("Placar inválido!");
                        }
                    }
                });

                pnlFormulario.add(lblId2);
                pnlFormulario.add(listaDeTimes1);
                pnlFormulario.add(listaDeTimes2);
                pnlFormulario.add(lblHora2);
                pnlFormulario.add(lblPartida2);

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

