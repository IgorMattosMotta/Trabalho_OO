package aplicacao;
import javax.swing.*;
import java.awt.*;

public abstract class TimesApp extends JFrame{
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;

    public TimesApp(){
        inicializar();
    }

    private void inicializar(){
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlFormulario(), BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public JPanel getPnlTitulo(){
        if(pnlTitulo == null){
            pnlTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lblTitulo = new JLabel("Times");
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(0,4));
            JLabel lblId = new JLabel("Id");
            JLabel lblNome = new JLabel("Nome");
            JLabel lblCidade = new JLabel("Cidade");
            JLabel lblEditar = new JLabel("Editar");


            pnlFormulario.add(lblId);
            pnlFormulario.add(lblNome);
            pnlFormulario.add(lblCidade);
            pnlFormulario.add(lblEditar);

            for(int i = 0; i < 10; i++){
                JLabel lblId2 = new JLabel(""+i);
                JLabel lblNome2 = new JLabel("Time "+1);
                JLabel lblCidade2 = new JLabel("Cidade "+1);
                JButton btnEditar = new JButton("Editar");

                pnlFormulario.add(lblId2);
                pnlFormulario.add(lblNome2);
                pnlFormulario.add(lblCidade2);
                pnlFormulario.add(btnEditar);
            }
        }
        return pnlFormulario;
    }
}
