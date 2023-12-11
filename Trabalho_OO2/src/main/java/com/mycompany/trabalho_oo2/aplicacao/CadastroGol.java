package com.mycompany.trabalho_oo2.aplicacao;
import javax.swing.*;
import java.awt.*;
public abstract class CadastroGol extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;
    public CadastroGol(){
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
            JLabel lblTitulo = new JLabel("Cadastro de Gol");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }
    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,2));
            JLabel lblId = new JLabel("Id");
            JLabel lblMinuto = new JLabel("Minuto");
            JLabel lblJogador = new JLabel("CPF Jogador");
            JLabel lblPartida = new JLabel("Id Partida");
            JTextField txtId = new JTextField();
            JTextField txtMinuto = new JTextField();
            JTextField txtJogador = new JTextField();
            JTextField txtPartida = new JTextField();
            JButton btnCadastrar = new JButton("Cadastrar");
            pnlFormulario.add(lblId);
            pnlFormulario.add(txtId);
            pnlFormulario.add(lblMinuto);
            pnlFormulario.add(txtMinuto);
            pnlFormulario.add(lblJogador);
            pnlFormulario.add(txtJogador);
            pnlFormulario.add(lblPartida);
            pnlFormulario.add(txtPartida);
            pnlFormulario.add(btnCadastrar);
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
            pnlRodape.add(btnVoltar);
        }
        return pnlRodape;
    }
}