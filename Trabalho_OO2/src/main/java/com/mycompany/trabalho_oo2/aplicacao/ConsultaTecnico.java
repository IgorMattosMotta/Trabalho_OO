package com.mycompany.trabalho_oo2.aplicacao;
//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConsultaTecnico extends JFrame implements InterfacePadrao{
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
            if(session.getCargo() == 1) {
                pnlFormulario = new JPanel(new GridLayout(0, 5));
            }else{
                pnlFormulario = new JPanel(new GridLayout(0, 3));
            }
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblTime = new JLabel("Time");
            JLabel lblEditar = new JLabel("Editar");
            JLabel lblExcluir = new JLabel("Excluir");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblTime);
            if(session.getCargo() == 1) {
                pnlFormulario.add(lblEditar);
                pnlFormulario.add(lblExcluir);
            }

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
                JButton btnExcluir = new JButton("Excluir");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblNome2);
                pnlFormulario.add(lblTime2);
                if(session.getCargo() == 1) {
                    pnlFormulario.add(btnEditar);
                    pnlFormulario.add(btnExcluir);
                }

                btnExcluir.addActionListener(e -> {
                    if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o técnico " + t.getNome() + "?") == JOptionPane.YES_OPTION){
                        RemoveJson r = new RemoveJson(session);
                        r.removeTecnico(t.getCpf());
                        new ConsultaTecnico(this.session).setVisible(true);
                        dispose();
                    }
                });

                btnEditar.addActionListener(e -> {
                    new EdicaoTecnico(this.session, t).setVisible(true);
                    dispose();
                });

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
