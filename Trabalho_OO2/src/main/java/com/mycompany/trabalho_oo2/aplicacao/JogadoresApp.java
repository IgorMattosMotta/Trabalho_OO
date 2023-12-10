package com.mycompany.trabalho_oo2.aplicacao;
import javax.swing.*;
import java.awt.*;

public abstract class JogadoresApp extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    public JogadoresApp(){
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
            pnlFormulario = new JPanel(new GridLayout(0,6));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblNumGols = new JLabel("Num Gols");
            JLabel lblNumCamisa = new JLabel("Num Camisa");
            JLabel lblTime = new JLabel("Time");
            JLabel lblEditar = new JLabel("Editar");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblNumGols);
            pnlFormulario.add(lblNumCamisa);
            pnlFormulario.add(lblTime);
            pnlFormulario.add(lblEditar);

            for(int i = 0; i < 10; i++){
                JLabel lblId2 = new JLabel(""+i);
                JLabel lblNome2 = new JLabel("Gabriel Barbosa");
                JLabel lblNumGols2 = new JLabel(" 3 ");
                JLabel lblNumCamisa2 = new JLabel("10");
                JLabel lblTime2 = new JLabel("Varmengo");
                JButton btnEditar = new JButton("Editar");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblNome2);
                pnlFormulario.add(lblNumGols2);
                pnlFormulario.add(lblNumCamisa2);
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
            JButton btnCadastro = new JButton("Cadastrar Jogador");
            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnCadastro);
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
