package aplicacao;
import javax.swing.*;
import java.awt.*;

public abstract class TecnicosApp extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    public TecnicosApp(){
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
            JLabel lblTitulo = new JLabel("Tecnicos");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,4));
            JLabel lblCPF = new JLabel("CPF");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblTime = new JLabel("Time");
            JLabel lblEditar = new JLabel("Editar");

            pnlFormulario.add(lblCPF);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblTime);
            pnlFormulario.add(lblEditar);

            for(int i = 0; i < 10; i++){
                JLabel lblCPF2 = new JLabel(""+i);
                JLabel lblNome2 = new JLabel("Jorge Jesus");
                JLabel lblTime2 = new JLabel("Varmengo");
                JButton btnEditar = new JButton("Editar");
                JButton btnExcluir = new JButton("Excluir");

                pnlFormulario.add(lblCPF2);
                pnlFormulario.add(lblNome2);
                pnlFormulario.add(lblTime2);
                pnlFormulario.add(btnEditar);
            }
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
            JButton btnCadastrar = new JButton("Cadastrar");
            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnCadastrar);
        }
        return pnlRodape;
    }

}
