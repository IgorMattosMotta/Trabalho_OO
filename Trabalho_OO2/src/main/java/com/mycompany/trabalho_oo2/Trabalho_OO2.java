package com.mycompany.trabalho_oo2;



import com.mycompany.trabalho_oo2.aplicacao.Login;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Trabalho_OO2 {

    public static void main(String[] args) {
        //ao iniciar o programa, o mesmo deve ler os arquivos json e armazenar os dados em listas
        ArrayList<Time> timesLista = new ArrayList<>();
        ArrayList<Partida> partidasLista = new ArrayList<>();
        ArrayList<Tecnico> tecnicosLista = new ArrayList<>();
        ArrayList<Jogador> jogadoresLista = new ArrayList<>();
        ArrayList<Admin> adminLista = new ArrayList<>();
        ArrayList<Gols> golsLista = new ArrayList<>();
        LeJson leJson = new LeJson();
        leJson.getTimes(timesLista);
        leJson.getPartidas(partidasLista, timesLista);
        leJson.getTecnico(tecnicosLista,timesLista);
        leJson.getJogador(jogadoresLista,timesLista);
        leJson.getAdministrdor(adminLista);
        leJson.getGols(golsLista,jogadoresLista,partidasLista);
            Login login = new Login(jogadoresLista, adminLista, tecnicosLista) {
            };
            login.setVisible(true);

        AdicionaJson adicionaJson = new AdicionaJson();
    }
}
        