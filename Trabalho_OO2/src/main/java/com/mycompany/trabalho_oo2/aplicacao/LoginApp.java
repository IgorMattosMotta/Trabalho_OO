package com.mycompany.trabalho_oo2.aplicacao;
import javax.swing.*;
import java.awt.*;

public abstract class LoginApp extends JFrame{

    private static final int TAMANHO_TXT = 20;
    //formulario
    protected JPanel pnlFormulario;
    //rodape
    protected JPanel pnlRodape;

    //usuario
    protected JLabel lblUsuario;
    protected JTextField txtUsuario;
    //senha
    protected JLabel lblSenha;
    protected JPasswordField txtSenha;
    //botao de login
    protected JButton btnLogin;

    public LoginApp(){
        inicializar();
    }
    private void inicializar(){
        this.setTitle("Login");
        //this.setSize(300, 200);
        this.getContentPane().setLayout(new BorderLayout());

        this.getContentPane().add(getPnlFormulario(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(2,2));
            lblUsuario = new JLabel("Usuário");
            txtUsuario = new JTextField(TAMANHO_TXT);
            lblSenha = new JLabel("Senha");
            txtSenha = new JPasswordField(TAMANHO_TXT);

            pnlFormulario.add(lblUsuario);
            pnlFormulario.add(txtUsuario);
            pnlFormulario.add(lblSenha);
            pnlFormulario.add(txtSenha);
        }
        return pnlFormulario;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnLogin = new JButton("Login");
            pnlRodape.add(btnLogin);
        }
        return pnlRodape;
    }

}
