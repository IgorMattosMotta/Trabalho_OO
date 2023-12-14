package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.EditaJson;
import com.mycompany.trabalho_oo2.Session;
import com.mycompany.trabalho_oo2.Time;

import javax.swing.*;
import java.awt.*;


public class EdicaoTime extends JFrame implements InterfacePadrao{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Session session;
    private Time time;



    public EdicaoTime(Session session, Time time){
        this.session = session;
        this.time = time;
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
            pnlFormulario = new JPanel(new GridLayout(0,3));
            JLabel lblId = new JLabel("ID");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblCidade = new JLabel("Cidade");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblCidade);

            JLabel lblId2 = new JLabel(String.valueOf(this.time.getId()));//tecnico.getCpf()
            JTextField lblNome2 = new JTextField(this.time.getNomeTime());
            //Verifica String
            lblNome2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch)) {
                        evt.consume();
                    }
                }
            });

            JTextField lblCidade2 = new JTextField(this.time.getCidade());

            lblCidade2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch) && !Character.isSpaceChar(ch)) {
                        evt.consume();
                    }
                }
            });
            JButton btnSalvar = new JButton("Salvar");

            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblNome2);
            pnlFormulario.add(lblCidade2);
            pnlFormulario.add(btnSalvar);

            btnSalvar.addActionListener(e ->{
                if(!lblNome2.getText().equals("") && !lblCidade2.getText().equals("") &&
                JOptionPane.showConfirmDialog(null, "Deseja realmente editar o técnico " + lblNome2.getText() + "?") == JOptionPane.YES_OPTION){

                    EditaJson editaJson = new EditaJson();
                    editaJson.editaTime(this.time, lblNome2.getText(), lblCidade2.getText(), this.time.getId());
                }
            });



        }
        return pnlFormulario;
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

    public JPanel getPnlTopo(){
        if(pnlTopo == null){
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Nome: Álvaro | Administrador");
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
