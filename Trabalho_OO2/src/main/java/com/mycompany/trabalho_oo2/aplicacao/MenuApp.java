package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.Session;

import javax.swing.*;
import java.awt.*;
public class MenuApp extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    //botao sair
    protected JButton btnSair;
    protected JPanel pnlFormulario;
    //consultar jogadores
    protected JButton btnConsultarJogadores;
    //consultar tecnicos
    protected JButton btnConsultarTecnicos;
    //consultar partidas
    protected JButton btnConsultarPartidas;
    //consultar times
    protected JButton btnConsultarTimes;
    //consultar administradores
    protected JButton btnConsultarAdministradores;
    //consultar gols
    protected JButton btnConsultarGols;

    private Session session;

    public MenuApp(Session session){
        this.session = session;
        inicializar(this.session);
    }

    private void inicializar(Session session){
        this.setTitle("Menu");
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTopo(session), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlFormulario(session), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public JPanel getPnlFormulario(Session session){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(6,1));
            btnConsultarJogadores = new JButton("Consultar Jogadores");
            btnConsultarTecnicos = new JButton("Consultar Técnicos");
            btnConsultarPartidas = new JButton("Consultar Partidas");
            btnConsultarTimes = new JButton("Consultar Times");
            btnConsultarAdministradores = new JButton("Consultar Administradores");
            btnConsultarGols = new JButton("Consultar Gols");

            if(session.getCargo() == 2 || session.getCargo() == 3){
                pnlFormulario.add(btnConsultarJogadores);
            }
            pnlFormulario.add(btnConsultarTecnicos);
            pnlFormulario.add(btnConsultarPartidas);
            pnlFormulario.add(btnConsultarTimes);
            pnlFormulario.add(btnConsultarAdministradores);
            pnlFormulario.add(btnConsultarGols);
        }
        return pnlFormulario;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            btnSair = new JButton("Sair");
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlRodape.add(btnSair);
        }
        return pnlRodape;
    }

    public JPanel getPnlTopo(Session session){
        if(pnlTopo == null){
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            String cargo = "";
            switch(session.getCargo()){
                case 1:
                    cargo = "Administrador";
                    break;
                case 2:
                    cargo = "Técnico";
                    break;
                case 3:
                    cargo = "Jogador";
                    break;
            }
            JLabel lblTitulo = new JLabel("Nome: "+session.getNome()+" | Cargo: "+cargo);
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
