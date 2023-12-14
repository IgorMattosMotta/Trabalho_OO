package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class EdicaoPartida extends JFrame implements InterfacePadrao{

        protected JPanel pnlTopo;
        protected JPanel pnlRodape;
        protected JPanel pnlTitulo;
        protected JPanel pnlFormulario;

        private Partida tecnico;
        private Session session;

        private Partida partida;

        private ArrayList<Time> times;


        public EdicaoPartida(Session session, Partida partida){
            this.times = new ArrayList<>();
            this.session = session;
            this.partida = partida;

            LeJson leJson = new LeJson();
            leJson.getTimes(this.times);
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

                JLabel lblId2 = new JLabel(String.valueOf(this.partida.getId()));

                String[] timesArray = new String[this.times.size()];
                for (Time time : times) {
                    timesArray[times.indexOf(time)] = time.getId()+" - "+time.getNomeTime();
                }

                // Lista de times

                // Criar um modelo para a lista
                DefaultComboBoxModel<String> lblTime2 = new DefaultComboBoxModel<>(timesArray);

                // Criar a lista com base no modelo
                JComboBox<String> listaDeTimes1 = new JComboBox<>(lblTime2);
                JComboBox<String> listaDeTimes2 = new JComboBox<>(lblTime2);

                JTextField lblHora2 = new JTextField(this.partida.getHorario());

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

                JTextField lblPartida2 = new JTextField(this.partida.getPlacar());


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
                JButton btnSalvar = new JButton("Salvar");

                btnSalvar.addActionListener(e -> {
                    String timeCasa = (String) listaDeTimes1.getSelectedItem();
                    int idTimeCasa = Integer.parseInt(timeCasa.split(" - ")[0]);

                    String timeVisitante = (String) listaDeTimes2.getSelectedItem();
                    int idTimeVisitante = Integer.parseInt(timeVisitante.split(" - ")[0]);

                    String hora = lblHora2.getText();
                    String placar = lblPartida2.getText();
                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente Editar?") == JOptionPane.YES_OPTION &&
                            timeCasa != null && timeVisitante != null && hora != null && placar != null) {
                        EditaJson editaJson = new EditaJson();
                        editaJson.editaPartida(placar,hora,idTimeCasa,idTimeVisitante,this.partida.getId());
                        JOptionPane.showMessageDialog(null, "Partida editada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao editar partida.");
                    }
                });

                pnlFormulario.add(lblId2);
                pnlFormulario.add(listaDeTimes1);
                pnlFormulario.add(listaDeTimes2);
                pnlFormulario.add(lblHora2);
                pnlFormulario.add(lblPartida2);
                pnlFormulario.add(btnSalvar);

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
                        new ConsultaPartida(this.session).setVisible(true);
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
                JLabel lblTitulo = new JLabel("Nome: "+session.getNome()+" | Cargo: "+ Session.getNomeCargo(session.getCargo()));
                pnlTopo.add(lblTitulo);
            }
            return pnlTopo;
        }
    }

