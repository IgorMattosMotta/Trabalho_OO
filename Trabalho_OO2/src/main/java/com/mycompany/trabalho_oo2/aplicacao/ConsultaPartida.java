package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class ConsultaPartida extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;
    private Session session;



    public ConsultaPartida(Session session){
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
            pnlFormulario = new JPanel(new GridLayout(0,7));
            JLabel lblId = new JLabel("ID");
            JLabel lblTimeCasa = new JLabel("Time Casa");
            JLabel lblTimeVisitante = new JLabel("Time Visitante");
            JLabel lblHora = new JLabel("Hora");
            JLabel lblPlacar = new JLabel("Placar");
            JLabel lblAjuste = new JLabel("");
            JLabel lblEditar = new JLabel("Editar");



            pnlFormulario.add(lblId);
            pnlFormulario.add(lblTimeCasa);
            pnlFormulario.add(lblTimeVisitante);
            pnlFormulario.add(lblHora);
            pnlFormulario.add(lblPlacar);
            pnlFormulario.add(lblAjuste);
            pnlFormulario.add(lblEditar);

            LeJson l = new LeJson();
            ArrayList<Time> times = new ArrayList<>();
            ArrayList<Partida> partidas =  new ArrayList<>();
            l.getTimes(times);
            l.getPartidas(partidas, times);

            for(Partida p: partidas) {
                JLabel lblId2 = new JLabel(String.valueOf(p.getId()));
                JLabel listaDeTimes1 = new JLabel(String.valueOf(p.getTimeCasa()));
                JLabel listaDeTimes2 = new JLabel(String.valueOf(p.getTimeVisitante()));
                JLabel lblHora2 = new JLabel(p.getHorario());
                JLabel lblPartida2 = new JLabel(p.getPlacar());
                JButton btnPartida = new JButton("Ver Parida Especifica");
                btnPartida.addActionListener(e -> {
                    new ConsultarPartidaEspecifica(this.session, p.getId()).setVisible(true);
                    dispose();
                });
                JButton btnEditar = new JButton("Editar");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(listaDeTimes1);
                pnlFormulario.add(listaDeTimes2);
                pnlFormulario.add(lblHora2);
                pnlFormulario.add(lblPartida2);
                pnlFormulario.add(btnPartida);
                pnlFormulario.add(btnEditar);
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
            JLabel lblTitulo = new JLabel(session.getNome() + " | " + Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
