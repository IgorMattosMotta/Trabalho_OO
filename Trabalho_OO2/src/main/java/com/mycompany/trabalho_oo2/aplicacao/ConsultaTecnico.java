package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConsultaTecnico extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Jogador jogador;
    private Session session;


    public ConsultaTecnico(Session session){
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
            JLabel lblTitulo = new JLabel("Jogadores");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,4));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblTime = new JLabel("Time");
            JLabel lblEditar = new JLabel("Editar");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblTime);
            pnlFormulario.add(lblEditar);

            LeJson l = new LeJson();
            ArrayList<Tecnico> tecnicos = new ArrayList<>();
            ArrayList<Time> times = new ArrayList<>();
            l.getTimes(times);
            l.getTecnico(tecnicos, times);
            for (Tecnico t: tecnicos) {
                JLabel lblId2 = new JLabel(t.getCpf());
                JLabel lblNome2 = new JLabel(t.getNome());
                JLabel lblTime2 = new JLabel(t.getTime().getNomeTime());
                JButton btnEditar = new JButton("Editar");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblNome2);
                pnlFormulario.add(lblTime2);
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
            JLabel lblTitulo = new JLabel(session.getNome() + "|" + Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
