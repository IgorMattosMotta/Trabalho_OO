package aplicacao;
import javax.swing.*;
import java.awt.*;
public abstract class MenuApp extends JFrame{
    protected JPanel pnlTopo;
    protected JPanel pnlRodape;
    //botao sair
    protected JButton btnSair;
    protected JPanel pnlFormulario;
    //consultar jogadores
    protected JButton btnConsultarJogadores;
    //consultar tecnicos
    protected JButton btnConsultarTecnicos;
    //consultar partidas
    protected JButton btnConsultarPartidas;
    //consultar times
    protected JButton btnConsultarTimes;
    //consultar administradores
    protected JButton btnConsultarAdministradores;
    //consultar gols
    protected JButton btnConsultarGols;

    public MenuApp(){
        inicializar();
    }

    private void inicializar(){
        this.setTitle("Menu");
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

    public JPanel getPnlFormulario(){
        if(pnlFormulario == null){
            pnlFormulario = new JPanel(new GridLayout(6,1));
            btnConsultarJogadores = new JButton("Consultar Jogadores");
            btnConsultarTecnicos = new JButton("Consultar Técnicos");
            btnConsultarPartidas = new JButton("Consultar Partidas");
            btnConsultarTimes = new JButton("Consultar Times");
            btnConsultarAdministradores = new JButton("Consultar Administradores");
            btnConsultarGols = new JButton("Consultar Gols");

            pnlFormulario.add(btnConsultarJogadores);
            pnlFormulario.add(btnConsultarTecnicos);
            pnlFormulario.add(btnConsultarPartidas);
            pnlFormulario.add(btnConsultarTimes);
            pnlFormulario.add(btnConsultarAdministradores);
            pnlFormulario.add(btnConsultarGols);
        }
        return pnlFormulario;
    }

    public JPanel getPnlRodape(){
        if(pnlRodape == null){
            btnSair = new JButton("Sair");
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
