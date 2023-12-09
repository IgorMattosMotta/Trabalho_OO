package aplicacao;

import javax.swing.*;

public class Aplicacao {
    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(() -> {
                LoginApp login = new LoginApp() {
                };
                login.setVisible(true);
        });*/

        /*SwingUtilities.invokeLater(() -> {
            TimesApp login = new TimesApp() {
            };
            login.setVisible(true);
        });*/

        SwingUtilities.invokeLater(() -> {
            MenuApp menuApp = new MenuApp() {
            };
            menuApp.setVisible(true);
        });

        /*SwingUtilities.invokeLater(() -> {
            JogadoresApp jogadoresApp = new JogadoresApp() {
            };
            jogadoresApp.setVisible(true);
        });*/

        /*SwingUtilities.invokeLater(() -> {
            PartidasApp partidasApp = new PartidasApp() {
            };
            partidasApp.setVisible(true);
        });*/

        /*SwingUtilities.invokeLater(() -> {
            TecnicosApp tecnicosApp = new TecnicosApp() {
            };
            tecnicosApp.setVisible(true);
        });*/
    }
}
