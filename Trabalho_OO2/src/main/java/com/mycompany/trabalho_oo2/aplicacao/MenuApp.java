package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.Session;

import javax.swing.*;
import java.awt.*;
public class MenuApp extends JFrame implements InterfacePadrao{
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

    protected JButton btnCadastrarJogadores;
    protected JButton btnCadastroPartida;
    protected JButton btnCadastroTecnicos;
    protected JButton btnCadastroAdmin;
    protected JButton btnCadastroTime;

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
            pnlFormulario = new JPanel(new GridLayout(5,1));
            btnConsultarJogadores = new JButton("Consultar Jogadores");
            btnConsultarJogadores.addActionListener(e -> {
                new ConsultaJogadores(this.session).setVisible(true);
                dispose();
            });
            btnConsultarTecnicos = new JButton("Consultar Técnicos");
            btnConsultarTecnicos.addActionListener(e -> {
                new ConsultaTecnico(this.session).setVisible(true);
                dispose();
            });
            btnConsultarPartidas = new JButton("Consultar Partidas");
            btnConsultarPartidas.addActionListener(e -> {
                new ConsultaPartida(this.session).setVisible(true);
                dispose();
            });
            btnConsultarTimes = new JButton("Consultar Times");
            btnConsultarTimes.addActionListener(e -> {
                new ConsultaTime(this.session).setVisible(true);
                dispose();
            });
            btnConsultarAdministradores = new JButton("Consultar Administradores");
            btnConsultarAdministradores.addActionListener(e -> {
                new ConsultaAdmin(this.session).setVisible(true);
                dispose();
            });
            btnCadastrarJogadores = new JButton("Cadastrar Jogadores");
            btnCadastrarJogadores.addActionListener(e -> {
                new CadastroJogadores(this.session).setVisible(true);
                dispose();
            });
            btnCadastroPartida = new JButton("Cadastrar Partida");
            btnCadastroPartida.addActionListener(e -> {
                new CadastroPartida(this.session) {
                    @Override
                    public JPanel getPnlFormulario() {
                        return null;
                    }
                }.setVisible(true);
                dispose();
            });
            btnCadastroTecnicos = new JButton("Cadastrar Tecnico");
            btnCadastroTecnicos.addActionListener(e -> {
                new CadastroTecnico(this.session).setVisible(true);
                dispose();
            });

            btnCadastroAdmin = new JButton("Cadastrar Administradores");
            btnCadastroAdmin.addActionListener(e -> {
                new CadastroAdmin(this.session).setVisible(true);
                dispose();
            });
            btnCadastroTime = new JButton("Cadastro Time");
            btnCadastroTime.addActionListener(e -> {
                new CadastroTime(this.session).setVisible(true);
                dispose();
            });

            if(this.session.getCargo() == 1){
                pnlFormulario.add(btnCadastrarJogadores);
                pnlFormulario.add(btnCadastroTecnicos);
                pnlFormulario.add(btnCadastroAdmin);
                pnlFormulario.add(btnCadastroPartida);
                pnlFormulario.add(btnCadastroTime);
            }

            pnlFormulario.add(btnConsultarJogadores);
            pnlFormulario.add(btnConsultarTecnicos);
            pnlFormulario.add(btnConsultarPartidas);
            pnlFormulario.add(btnConsultarTimes);
            pnlFormulario.add(btnConsultarAdministradores);
        }
        return pnlFormulario;
    }

    @Override
    public JPanel getPnlTitulo() {
        return null;
    }

    @Override
    public JPanel getPnlFormulario() {
        return null;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            btnSair = new JButton("Sair");
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlRodape.add(btnSair);
        }
        return pnlRodape;
    }

    @Override
    public JPanel getPnlTopo() {
        return null;
    }

    public JPanel getPnlTopo(Session session){
        if(pnlTopo == null){
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Nome: "+session.getNome()+" | Cargo: "+ Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
