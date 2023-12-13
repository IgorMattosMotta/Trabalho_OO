package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.*;
import com.mycompany.trabalho_oo2.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsultaGol extends JFrame{

    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Session session;

    public ConsultaGol(Session session){
        this.session = session;
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
            JLabel lblTitulo = new JLabel("Gols");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,4));
            JLabel lblId = new JLabel("ID");
            JLabel lblJogador = new JLabel("Jogador");
            JLabel lblCidade = new JLabel("Minuto");
            JLabel lblEditar = new JLabel("Editar");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblJogador);
            pnlFormulario.add(lblCidade);
            pnlFormulario.add(lblEditar);

            ArrayList<Time> timesLista = new ArrayList<>();
            ArrayList<Partida> partidasLista = new ArrayList<>();
            ArrayList<Jogador> jogadoresLista = new ArrayList<>();
            ArrayList<Gols> golsLista = new ArrayList<>();
            LeJson leJson = new LeJson();
            leJson.getTimes(timesLista);
            leJson.getPartidas(partidasLista, timesLista);
            leJson.getJogador(jogadoresLista,timesLista);
            leJson.getGols(golsLista,jogadoresLista,partidasLista);

            for(Gols gols : golsLista){
                JLabel lblIdGol = new JLabel(String.valueOf(gols.getId()));
                JLabel lblJogadorGol = new JLabel(gols.getJogador().getNome());
                JLabel lblMinutoGol = new JLabel(gols.getMinutoMarcou());
                JButton btnEditarGol = new JButton("Editar");
                pnlFormulario.add(lblIdGol);
                pnlFormulario.add(lblJogadorGol);
                pnlFormulario.add(lblMinutoGol);
                pnlFormulario.add(btnEditarGol);
            }

        }
        return pnlFormulario;
    }

    public JPanel getPnlTopo(){
        if(pnlTopo == null){
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlTopo.add(getPnlTitulo());
        }
        return pnlTopo;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnVoltar = new JButton("Voltar");
            btnVoltar.addActionListener(e -> {
                this.dispose();
                new Menu();
            });
            pnlRodape.add(btnVoltar);
        }
        return pnlRodape;
    }
}
