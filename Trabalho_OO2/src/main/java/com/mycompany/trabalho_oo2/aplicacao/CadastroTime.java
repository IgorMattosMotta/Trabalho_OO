package com.mycompany.trabalho_oo2.aplicacao;
//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
import com.mycompany.trabalho_oo2.AdicionaJson;
import com.mycompany.trabalho_oo2.LeJson;
import com.mycompany.trabalho_oo2.Session;
import com.mycompany.trabalho_oo2.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CadastroTime extends JFrame implements InterfacePadrao {
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Session session;

    public CadastroTime(Session session) {
        this.session = session;
        inicializar();
    }

    private void inicializar() {
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(getPnlTopo());
        this.getContentPane().add(getPnlFormulario());
        this.getContentPane().add(getPnlRodape());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public JPanel getPnlTitulo() {
        if (pnlTitulo == null) {
            pnlTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Jogadores");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }


    public JPanel getPnlFormulario() {
        if (pnlFormulario == null) {
            pnlFormulario = new JPanel(new GridLayout(0, 2));
            JLabel lblNome = new JLabel("Nome");
            JLabel lblCidade = new JLabel("Cidade");

            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblCidade);

            JTextField lblNome2 = new JTextField();
            //Verifica String
            lblNome2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch) && !Character.isSpaceChar(ch)) {
                        evt.consume();
                    }
                }
            });

            JTextField lblCidade2 = new JTextField();

            lblCidade2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch) && !Character.isSpaceChar(ch)) {
                        evt.consume();
                    }
                }
            });

            JButton btnSalvar = new JButton("Salvar");
            btnSalvar.addActionListener(e -> {
                try {
                    JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso!");
                    AdicionaJson ad = new AdicionaJson(session);
                    LeJson le = new LeJson(session);
                    ArrayList<Time> times = new ArrayList<>();
                    le.getTimes(times);
                    ad.adicionaTime(times, lblNome2.getText(), lblCidade2.getText());
                    dispose();
                    MenuApp menu = new MenuApp(session);
                    menu.setVisible(true);
                } catch (RuntimeException erro) {
                    JOptionPane.showMessageDialog(null, "Algum campo não está preenchido de forma correta!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    throw new RuntimeException("Algum campo não está preenchido de forma correta!" + erro.getMessage());
                }
            });

            pnlFormulario.add(lblNome2);
            pnlFormulario.add(lblCidade2);
            pnlFormulario.add(btnSalvar);

        }
        return pnlFormulario;
    }


    public JPanel getPnlRodape() {
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

        return pnlRodape;
    }

    public JPanel getPnlTopo() {
        if (pnlTopo == null) {
            pnlTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Nome: " + session.getNome() + " | Cargo: " + Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
