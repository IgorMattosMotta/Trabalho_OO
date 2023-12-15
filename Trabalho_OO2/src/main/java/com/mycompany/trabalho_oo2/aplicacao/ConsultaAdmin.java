package com.mycompany.trabalho_oo2.aplicacao;
//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
import com.mycompany.trabalho_oo2.Admin;
import com.mycompany.trabalho_oo2.LeJson;
import com.mycompany.trabalho_oo2.RemoveJson;
import com.mycompany.trabalho_oo2.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class ConsultaAdmin extends JFrame implements InterfacePadrao{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;
    private Session session;



    public ConsultaAdmin(Session session){
        this.session = session;
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
            if(session.getCargo() == 1) {
                pnlFormulario = new JPanel(new GridLayout(0, 4));
            }else{
                pnlFormulario = new JPanel(new GridLayout(0, 3));
            }
            JLabel lblId = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblCargo = new JLabel("Cargo");
            JLabel lblExcluir = new JLabel("Excluir");


            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblCargo);
            if(session.getCargo() == 1) {
                pnlFormulario.add(lblExcluir);
            }


            LeJson l = new LeJson(session);
            ArrayList<Admin> admin = new ArrayList<>();
            l.getAdministrdor(admin);

            for(Admin a: admin) {
                JLabel lblId2 = new JLabel(a.getCpf());
                JLabel lblnome2 = new JLabel(a.getNome());
                JLabel lblcargo2 = new JLabel(Session.getNomeCargo(a.getCargo()));
                JButton btnExcluir = new JButton("Excluir");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblnome2);
                pnlFormulario.add(lblcargo2);
                if(session.getCargo() == 1) {
                    pnlFormulario.add(btnExcluir);
                }

                btnExcluir.addActionListener(e -> {
                    if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o admin?") == JOptionPane.YES_OPTION) {
                        RemoveJson r = new RemoveJson(session);
                        r.removeAdmin(a.getCpf());
                        new ConsultaAdmin(this.session).setVisible(true);
                        dispose();
                    }
                });

            }
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
                new MenuApp(this.session).setVisible(true);
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
            JLabel lblTitulo = new JLabel(session.getNome() + "|" + Session.getNomeCargo(session.getCargo()));
            pnlTopo.add(lblTitulo);
        }
        return pnlTopo;
    }
}
