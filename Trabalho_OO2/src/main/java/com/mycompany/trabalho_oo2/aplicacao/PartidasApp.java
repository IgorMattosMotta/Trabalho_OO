package com.mycompany.trabalho_oo2.aplicacao;
import javax.swing.*;
import java.awt.*;

public abstract class PartidasApp extends JFrame {
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    public PartidasApp(){
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
            JLabel lblTitulo = new JLabel("Partidas");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,6));
            JLabel lblId = new JLabel("Id");
            JLabel lblTimeCasa = new JLabel("Casa");
            JLabel lblTimeVisitante = new JLabel("Visitante");
            JLabel lblHora = new JLabel("Hora");
            JLabel lblPlacar = new JLabel("Placar");
            JLabel lblEditar = new JLabel("Editar");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblTimeCasa);
            pnlFormulario.add(lblTimeVisitante);
            pnlFormulario.add(lblHora);
            pnlFormulario.add(lblPlacar);
            pnlFormulario.add(lblEditar);

            for(int i = 0; i < 10; i++){
                JLabel lblId2 = new JLabel("Id");
                JLabel lblTimeCasa2 = new JLabel("Casa");
                JLabel lblTimeVisitante2 = new JLabel("Visitante");
                JLabel lblHora2 = new JLabel("Hora");
                JLabel lblPlacar2 = new JLabel("Placar");
                JLabel lblEditar2 = new JLabel("Editar");
                JButton btnEditar2 = new JButton("Editar");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblTimeCasa2);
                pnlFormulario.add(lblTimeVisitante2);
                pnlFormulario.add(lblHora2);
                pnlFormulario.add(lblPlacar2);
                pnlFormulario.add(btnEditar2);
            }
        }
        return pnlFormulario;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnNovo = new JButton("Nova Partida");
            JButton btnVoltar = new JButton("Voltar");
            JButton btnSair = new JButton("Sair");
            pnlRodape.add(btnNovo);
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
