package aplicacao;

import javax.swing.*;

public class Aplicacao {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                LoginApp login = new LoginApp() {
                };
                login.setVisible(true);
        });
    }
}
