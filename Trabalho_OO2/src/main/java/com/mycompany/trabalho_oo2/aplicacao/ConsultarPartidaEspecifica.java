package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class ConsultarPartidaEspecifica extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlCentral;
    protected JPanel pnlFormulario2;
    protected JPanel pnlFormulario;
    private Session session;
    private int id;



    public ConsultarPartidaEspecifica(Session session, int id){
        this.session = session;
        this.id = id;
        inicializar(this.session);
    }

    private void inicializar(Session session){

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTopo(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlCentral(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public  JPanel getPnlCentral(){
        pnlCentral = new JPanel(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Informações", getPnlFormulario());
        tabbedPane.addTab("Times", getPnlFormulario2());

        pnlCentral.add(tabbedPane, BorderLayout.CENTER);

        return pnlCentral;

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
            JLabel lblHora = new JLabel("Hora");
            JLabel lblPlacar = new JLabel("Placar");


            pnlFormulario.add(lblId);
            pnlFormulario.add(lblHora);
            pnlFormulario.add(lblPlacar);

            LeJson l = new LeJson();
            ArrayList<Time> times = new ArrayList<>();
            ArrayList<Partida> partidas =  new ArrayList<>();
            l.getTimes(times);
            l.getPartidas(partidas, times);

            for(Partida p: partidas) {
                if(p.getId() == this.id) {
                    JLabel lblId2 = new JLabel(String.valueOf(p.getId()));

                    JLabel lblHora2 = new JLabel(p.getHorario());
                    JLabel lblPartida2 = new JLabel(p.getPlacar());

                    pnlFormulario.add(lblId2);

                    pnlFormulario.add(lblHora2);
                    pnlFormulario.add(lblPartida2);
                }
            }
        }
        return pnlFormulario;
    }

    public JPanel getPnlFormulario2() {
        if (pnlFormulario2 == null) {
            pnlFormulario2 = new JPanel(new GridLayout(0, 2));
            JLabel lblTimeCasa = new JLabel("Time Casa");
            JLabel lblTimeVisitante = new JLabel("Time Visitante");
            pnlFormulario2.add(lblTimeCasa);
            pnlFormulario2.add(lblTimeVisitante);

            LeJson l = new LeJson();
            ArrayList<Time> times = new ArrayList<>();
            ArrayList<Partida> partidas = new ArrayList<>();
            l.getTimes(times);
            l.getPartidas(partidas, times);

            for (Partida partida : partidas){
                if(partida.getId() == this.id) {
                    JLabel listaDeTimes1 = new JLabel(String.valueOf(partida.getTimeCasa()));
                    JLabel listaDeTimes2 = new JLabel(String.valueOf(partida.getTimeVisitante()));
                    pnlFormulario2.add(listaDeTimes1);
                    pnlFormulario2.add(listaDeTimes2);
                    break;
                }
            }
        }
        return pnlFormulario2;
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
            JLabel lblTitulo = new JLabel(session.getNome() + " | " + Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
