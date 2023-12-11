package com.mycompany.trabalho_oo2.aplicacao;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class CadastroPartida extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    public CadastroPartida(){
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
            JLabel lblTitulo = new JLabel("Cadastro de Partida");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,2));
            JLabel lblHora = new JLabel("Hora");
            JLabel lblTimeCasa = new JLabel("Time Casa");
            JLabel lblTimeVisitante = new JLabel("Time Visitante");
            JLabel lblGolCasa = new JLabel("Gols Time Casa");
            JLabel lblGolVisitante = new JLabel("Gols Time Visitante");

            JTextField txtHora = new JTextField();
            JTextField txtTimeCasa = new JTextField();
            JTextField txtTimeVisitante = new JTextField();
            JTextField txtGolCasa = new JTextField();
            JTextField txtGolVisitante = new JTextField();
            JButton btnCadastrar = new JButton("Cadastrar");

            pnlFormulario.add(lblHora);
            pnlFormulario.add(txtHora);
            pnlFormulario.add(lblTimeCasa);
            pnlFormulario.add(txtTimeCasa);
            pnlFormulario.add(lblTimeVisitante);
            pnlFormulario.add(txtTimeVisitante);
            pnlFormulario.add(lblGolCasa);
            pnlFormulario.add(txtGolCasa);
            pnlFormulario.add(lblGolVisitante);
            pnlFormulario.add(txtGolVisitante);
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
            JButton btnSair = new JButton("Sair");

            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnSair);
        }
        return pnlRodape;
    }
}
