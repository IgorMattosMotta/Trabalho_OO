package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class CadastroPartida extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Session session;

    public CadastroPartida(Session session){
        this.session = session;
        inicializar(session);
    }

    private void inicializar(Session session){


        LeJson l = new LeJson();
        ArrayList<Time> t = new ArrayList<>();
        ArrayList<Partida> p = new ArrayList<>();
        l.getTimes(t);
        l.getPartidas(p, t);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTopo(), BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlFormulario(t, p), BorderLayout.CENTER);
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

    public JPanel getPnlFormulario(ArrayList<Time> t, ArrayList<Partida> p){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,2));
            JLabel lblHora = new JLabel("Hora");
            JLabel lblTimeCasa = new JLabel("Time Casa");
            JLabel lblTimeVisitante = new JLabel("Time Visitante");
            JLabel lblGolCasa = new JLabel("Placar");

            JTextField lblHora2 = new JTextField(null);
            lblHora2.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Quando o campo perde foco, verificar a validação
                    String ch = lblHora2.getText();
                    if (!ValidaHora.validarHora(ch)) {
                        lblHora2.setText("Hora inválida");
                    }
                }
            });

            // Lista de times

            Time[] times = new Time[t.size()];
            int i = 0;
            for(Time time: t){
                times[i] = time;
                i++;
            }

            // Criar um modelo para a lista
            DefaultComboBoxModel<Time> l = new DefaultComboBoxModel<>(times);
            DefaultComboBoxModel<Time> l1 = new DefaultComboBoxModel<>(times);
            // Criar a lista com base no modelo
            JComboBox<Time>  txtTimeCasa = new JComboBox<>(l);
            JComboBox<Time> txtTimeVisitante = new JComboBox<>(l1);
            JTextField txtPlacar = new JTextField();
            txtPlacar.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Quando o campo perde foco, verificar a validação
                    String ch = txtPlacar.getText();
                    if (!ValidaPlacar.validarPlacar(ch)) {
                        txtPlacar.setText("Placar inválido!");
                    }
                }
            });
            JButton btnCadastrar = new JButton("Cadastrar");

            btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String hora = lblHora2.getText();
                    String placar = txtPlacar.getText();
                    Time visitante = (Time) txtTimeVisitante.getSelectedItem();
                    Time casa = (Time) txtTimeCasa.getSelectedItem();

                    if(ValidaHora.validarHora(hora) && ValidaPlacar.validarPlacar(placar)){
                        AdicionaJson add = new AdicionaJson();
                        add.adicionaPartida(p, t, p.size() +1, casa.getId(), visitante.getId(), placar, hora);
                        for(Partida p2: p){
                            System.out.println(p2.getTimeCasa() + "x" + p2.getTimeVisitante());
                        }
                        System.out.printf("\n\n");
                    }else{
                        JOptionPane.showMessageDialog(null, "PLACAR OU HORA INVÁLIDOS!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

            pnlFormulario.add(lblHora);
            pnlFormulario.add(lblHora2);
            pnlFormulario.add(lblTimeCasa);
            pnlFormulario.add(txtTimeCasa);
            pnlFormulario.add(lblTimeVisitante);
            pnlFormulario.add(txtTimeVisitante);
            pnlFormulario.add(lblGolCasa);
            pnlFormulario.add(txtPlacar);
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
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Chama dispose() para fechar a janela
                    dispose();
                }
            });
            btnSair.addActionListener(e -> dispose());

            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnSair);
        }
        return pnlRodape;
    }
}
