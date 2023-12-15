package com.mycompany.trabalho_oo2.aplicacao;
//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class ConsultarPartidaEspecifica extends JFrame implements InterfacePadrao{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlCentral;
    protected JPanel pnlFormulario2;
    protected JPanel pnlFormulario;

    protected JPanel pnlJogadores1;
    protected JPanel pnlJogadores2;
    private Session session;
    private int id;
    private JScrollPane scrollPaneFormulario2;


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
        scrollPaneFormulario2 = new JScrollPane(getPnlFormulario2());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Times", scrollPaneFormulario2);
        pnlCentral.add(tabbedPane, BorderLayout.CENTER);
        this.pack();
    }



    public  JPanel getPnlCentral(){
        pnlCentral = new JPanel(new GridLayout(0, 2));
        pnlCentral.add(getPnlFormulario());

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

            LeJson l = new LeJson(session);
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

                LeJson l = new LeJson(session);
                ArrayList<Time> times = new ArrayList<>();
                ArrayList<Partida> partidas = new ArrayList<>();
                l.getTimes(times);
                l.getPartidas(partidas, times);
                ArrayList<Jogador> jogadores = new ArrayList<>();
                l.getTimes(times);
                l.getJogador(jogadores, times);
                for (Partida partida : partidas){
                    if(partida.getId() == this.id) {
                        JLabel listaDeTimes1 = new JLabel(String.valueOf(partida.getTimeCasa()));
                        JLabel listaDeTimes2 = new JLabel(String.valueOf(partida.getTimeVisitante()));
                        pnlFormulario2.add(listaDeTimes1);
                        pnlFormulario2.add(listaDeTimes2);

                        // Adiciona jogadores ao pnlJogadores1
                        pnlFormulario2.add(getPnlJogadores1());

                        // Adiciona jogadores ao pnlJogadores2
                        pnlFormulario2.add(getPnlJogadores2());
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

    public JPanel getPnlJogadores1(){
        // Corrigir o nome da variável para pnlJogadores2
        pnlJogadores1 = new JPanel(new GridLayout(0, 1));
        LeJson l = new LeJson(session);
        ArrayList<Time> times = new ArrayList<>();
        ArrayList<Partida> partidas = new ArrayList<>();
        l.getTimes(times);
        l.getPartidas(partidas, times);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        l.getTimes(times);
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        l.getTecnico(tecnicos, times);
        l.getJogador(jogadores, times);
        for (Partida partida : partidas) {
            if (partida.getId() == this.id) {
                for(Tecnico t: tecnicos) {
                    try {
                        if (t.getTime().getId() == partida.getTimeVisitante().getId()) {
                            JLabel lbltecnico = new JLabel(t.getNome());
                            pnlJogadores1.add(lbltecnico);
                        }
                    }catch (RuntimeException e){

                    }
                }
                for (Jogador j : jogadores) {
                    try{
                        if (j.getTime().getId() == partida.getTimeVisitante().getId()) {
                            JLabel lblJogador2 = new JLabel(j.getNome());
                            pnlJogadores1.add(lblJogador2);
                        }
                    }catch (RuntimeException e){

                    }
                }
                break;
            }
        }
        return pnlJogadores1;
    }

        public JPanel getPnlJogadores2(){
            // Corrigir o nome da variável para pnlJogadores2
            pnlJogadores2 = new JPanel(new GridLayout(0, 1));
                LeJson l = new LeJson(session);
                ArrayList<Time> times = new ArrayList<>();
                ArrayList<Partida> partidas = new ArrayList<>();
                l.getTimes(times);
                l.getPartidas(partidas, times);
                ArrayList<Jogador> jogadores = new ArrayList<>();
                l.getTimes(times);
                ArrayList<Tecnico> tecnicos = new ArrayList<>();
                l.getTecnico(tecnicos, times);
                l.getJogador(jogadores, times);
                for (Partida partida : partidas) {
                    if (partida.getId() == this.id) {
                        for(Tecnico t: tecnicos) {
                            try {
                                if (t.getTime().getId() == partida.getTimeVisitante().getId()) {
                                    JLabel lbltecnico = new JLabel(t.getNome());
                                    pnlJogadores2.add(lbltecnico);
                                }
                            }catch (RuntimeException e){

                            }
                        }
                        for (Jogador j : jogadores) {
                            try{
                            if (j.getTime().getId() == partida.getTimeVisitante().getId()) {
                                JLabel lblJogador2 = new JLabel(j.getNome());
                                pnlJogadores2.add(lblJogador2);
                            }
                            }catch (RuntimeException e){

                            }
                        }
                        break;
                    }
                }
            return pnlJogadores2;
        }
}
