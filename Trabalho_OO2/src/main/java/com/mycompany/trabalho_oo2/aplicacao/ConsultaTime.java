package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.LeJson;
import com.mycompany.trabalho_oo2.Session;
import com.mycompany.trabalho_oo2.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ConsultaTime extends JFrame {

        protected JPanel pnlTopo;
        protected JPanel pnlRodape;
        protected JPanel pnlTitulo;
        protected JPanel pnlFormulario;
        private Session session;



        public ConsultaTime(Session session){
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
                pnlFormulario = new JPanel(new GridLayout(0,3));
                JLabel lblId = new JLabel("ID");
                JLabel lblNome = new JLabel("Nome");
                JLabel lblCidade = new JLabel("Cidade");

                pnlFormulario.add(lblId);
                pnlFormulario.add(lblNome);
                pnlFormulario.add(lblCidade);

                ArrayList<Time> times = new ArrayList<>();
                LeJson l = new LeJson();
                l.getTimes(times);
                for (Time t: times) {


                    JLabel lblId2 = new JLabel(String.valueOf(t.getId()));
                    JLabel lblNome2 = new JLabel(t.getNomeTime());
                    JLabel lblCidade2 = new JLabel(t.getCidade());

                    pnlFormulario.add(lblId2);
                    pnlFormulario.add(lblNome2);
                    pnlFormulario.add(lblCidade2);
                }

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
                JLabel lblTitulo = new JLabel(Session.getNome() + "|" + Session.getNomeCargo(Session.getCargo()));
                pnlTopo.add(lblTitulo);
            }
            return pnlTopo;
        }
    }