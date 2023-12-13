package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.Jogador;
import com.mycompany.trabalho_oo2.LeJson;
import com.mycompany.trabalho_oo2.Session;
import com.mycompany.trabalho_oo2.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConsultaJogadores extends JFrame implements InterfacePadrao{

    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Jogador jogador;
    private Session session;


    public ConsultaJogadores(Session session){
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
        if(pnlFormulario == null) {
            LeJson l = new LeJson();
            ArrayList<Jogador> jogadores = new ArrayList<>();
            ArrayList<Time> times = new ArrayList<>();
            l.getTimes(times);
            l.getJogador(jogadores, times);


            pnlFormulario = new JPanel(new GridLayout(0, 6));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblNumCamisa = new JLabel("Num Camisa");
            JLabel lblTime = new JLabel("Time");
            JLabel lblOverall = new JLabel("Overall");
            JLabel lblEditar = new JLabel("Editar");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblNumCamisa);
            pnlFormulario.add(lblTime);
            pnlFormulario.add(lblOverall);
            pnlFormulario.add(lblEditar);

            for (Jogador j:jogadores) {

                JLabel lblId2 = new JLabel(j.getCpf());

                JLabel lblNome2 = new JLabel(j.getNome());

                JLabel lblNumCamisa2 = new JLabel(String.valueOf(j.getNumCamisa()));

                JLabel lblTimes2 = new JLabel(j.getTime().getNomeTime());

                JLabel lblOverall2 = new JLabel(String.valueOf(j.calculaNotaGeral(j)/10));

                JButton btnEditar = new JButton("Editar");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblNome2);
                pnlFormulario.add(lblNumCamisa2);
                pnlFormulario.add(lblTimes2);
                pnlFormulario.add(lblOverall2);
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
            JLabel lblTitulo = new JLabel("Nome: Álvaro | Administrador");
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
