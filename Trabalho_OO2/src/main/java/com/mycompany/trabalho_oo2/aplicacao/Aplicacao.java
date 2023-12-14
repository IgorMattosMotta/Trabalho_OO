package com.mycompany.trabalho_oo2.aplicacao;

import com.mycompany.trabalho_oo2.Session;

import javax.swing.*;

public class Aplicacao {
    public static void main(String[] args) {
      /*  SwingUtilities.invokeLater(() -> {
                LoginApp login = new LoginApp() {
                };
                login.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            TimesApp login = new TimesApp() {
            };
            login.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            MenuApp menuApp = new MenuApp() {
            };
            menuApp.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            JogadoresApp jogadoresApp = new JogadoresApp() {
            };
            jogadoresApp.setVisible(true);
        });
        SwingUtilities.invokeLater(() -> {
            PartidasApp partidasApp = new PartidasApp() {
            };
            partidasApp.setVisible(true);
        });
        /*
        SwingUtilities.invokeLater(() -> {
            TecnicosApp tecnicosApp = new TecnicosApp() {
            };
            tecnicosApp.setVisible(true);
        });


        SwingUtilities.invokeLater(() -> {
            EdicaoTecnico edicaoTecnico = new EdicaoTecnico() {
            };
            edicaoTecnico.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            EdicaoJogador edicaoJogador = new EdicaoJogador() {
            };
            edicaoJogador.setVisible(true);
        });
        SwingUtilities.invokeLater(() -> {
            EdicaoPartida edicaoPartida = new EdicaoPartida() {
            };
            edicaoPartida.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            EdicaoTime edicaoTime = new EdicaoTime(new Session(1, "845.496.690-04", "Pablo Veggeti"), new Time(1, "Vasco da Gama", "Rio de Janeiro")) {
            };
            edicaoTime.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            Login Login = new Login() {
            };
            Login.setVisible(true);
        });

       */
        SwingUtilities.invokeLater(() -> {
            CadastroAdmin CadastroAdmin = new CadastroAdmin(new Session(1, "845.496.690-04", "Pablo Veggeti")) {
            };
            CadastroAdmin.setVisible(true);
        });
    /*
        SwingUtilities.invokeLater(() -> {
            ConsultarPartidaEspecifica ConsultarPartidaEspecifica = new ConsultarPartidaEspecifica(new Session(1, "845.496.690-04", "Pablo Veggeti"), 1) {
            };
            ConsultarPartidaEspecifica.setVisible(true);
        });*/


    }
}
