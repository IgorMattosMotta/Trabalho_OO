package aplicacao;
import javax.swing.*;
import java.awt.*;

public class TimesApp {
    protected JPanel pnlTitulo;
    protected JPanel pnlFormulario;
    protected JPanel pnlRodape;

    public TimesApp(){
        inicializar();
    }

    private void inicializar(){

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
            pnlFormulario = new JPanel(new GridLayout(2,2));
            JLabel lblNome = new JLabel("Nome");
            JTextField txtNome = new JTextField(20);
            JLabel lblEstadio = new JLabel("Cidade");
            JTextField txtEstadio = new JTextField(20);

            pnlFormulario.add(lblNome);
            pnlFormulario.add(txtNome);
            pnlFormulario.add(lblEstadio);
            pnlFormulario.add(txtEstadio);
        }
        return pnlFormulario;
    }
}
