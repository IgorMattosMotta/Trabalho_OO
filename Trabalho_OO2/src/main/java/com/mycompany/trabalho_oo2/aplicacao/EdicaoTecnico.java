package com.mycompany.trabalho_oo2.aplicacao;
import com.mycompany.trabalho_oo2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class EdicaoTecnico extends JFrame implements InterfacePadrao{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    private Tecnico tecnico;

    private Session session;

    private ArrayList<Time> times;

    private ArrayList<Tecnico> tecnicos;


    public EdicaoTecnico(Session session, Tecnico tecnico){
        this.times = new ArrayList<>();
        this.tecnicos = new ArrayList<>();
        this.tecnico = tecnico;
        this.session = session;
        LeJson leJson = new LeJson();
        leJson.getTimes(this.times);
        leJson.getTecnico(this.tecnicos, this.times);
        inicializar(this.session);
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
            JLabel lblTitulo = new JLabel("Jogadores");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,3));
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblTime = new JLabel("Time");

            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblTime);

            JLabel lblId2 = new JLabel(this.tecnico.getCpf());//tecnico.getCpf()
            JTextField lblNome2 = new JTextField(this.tecnico.getNome());//tecnico.getNome()
            //Verifica String
            lblNome2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char ch = evt.getKeyChar();
                    if (!Character.isAlphabetic(ch)&& !Character.isSpaceChar(ch)) {
                        evt.consume();
                    }
                }
            });
            // Lista de times
            String[] timesArray = new String[this.times.size()];
            for (Time time : this.times) {
                timesArray[this.times.indexOf(time)] = time.getId() + " - " + time.getNomeTime();
            }

            // Criar um modelo para a lista
            DefaultComboBoxModel<String> lblTime2 = new DefaultComboBoxModel<>(timesArray);

            // Criar a lista com base no modelo
            JComboBox<String> listaDeTimes = new JComboBox<>(lblTime2);

            // Criar um botão para obter a seleção
            JButton botao = new JButton("Obter Seleção");
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obter a seleção da lista
                    String selecionado = (String) listaDeTimes.getSelectedItem();
                    if (selecionado != null) {
                        JOptionPane.showMessageDialog(null, "Time selecionado: " + selecionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum time selecionado.");
                    }
                }
            });

            JButton btnSalvar = new JButton("Salvar");

            pnlFormulario.add(lblId2);
            pnlFormulario.add(lblNome2);
            pnlFormulario.add(listaDeTimes);
            pnlFormulario.add(btnSalvar);

            btnSalvar.addActionListener(e -> {
                if(JOptionPane.showConfirmDialog(null, "Deseja realmente editar o técnico " + lblNome2.getText() + "?") == JOptionPane.YES_OPTION
                && !lblNome2.getText().equals("") && listaDeTimes.getSelectedItem() != null){
                    int idTime = Integer.parseInt(listaDeTimes.getSelectedItem().toString().split(" - ")[0]);
                    EditaJson editaJson = new EditaJson();
                    editaJson.editaTecnico(this.tecnicos, this.times, this.tecnico.getCpf(), lblNome2.getText(), idTime);
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
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Chama dispose() para fechar a janela
                    dispose();
                }
            });

            btnSair.addActionListener(e -> dispose());
            btnVoltar.addActionListener(e -> {
                new ConsultaTecnico(this.session).setVisible(true);
                dispose();
            });
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
