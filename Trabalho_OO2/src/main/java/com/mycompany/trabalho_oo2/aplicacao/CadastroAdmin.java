package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.Session;

import javax.swing.*;
import java.awt.*;

public abstract class CadastroAdmin extends JFrame implements InterfacePadrao{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;
    private Session session;

    public CadastroAdmin(Session session){
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
            JLabel lblTitulo = new JLabel("Cadastro de Administrador");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,2));
            JLabel lblNome = new JLabel("Nome");
            JLabel lblCpf = new JLabel("CPF");
            JLabel lblSenha = new JLabel("Senha");
            JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
            JTextField txtNome = new JTextField();
            JTextField txtCpf = new JTextField();
            JPasswordField txtSenha = new JPasswordField();
            JPasswordField txtConfirmarSenha = new JPasswordField();
            JButton btnCadastrar = new JButton("Cadastrar");

            pnlFormulario.add(lblCpf);
            pnlFormulario.add(txtCpf);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(txtNome);
            pnlFormulario.add(lblSenha);
            pnlFormulario.add(txtSenha);
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
