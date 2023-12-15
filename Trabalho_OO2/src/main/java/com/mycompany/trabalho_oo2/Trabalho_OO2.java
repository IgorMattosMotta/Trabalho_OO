package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025

import com.mycompany.trabalho_oo2.aplicacao.Login;

import java.util.ArrayList;

public class Trabalho_OO2 {

    public static void main(String[] args) {
        //ao iniciar o programa, o mesmo deve ler os arquivos json e armazenar os dados em listas
        ArrayList<Time> timesLista = new ArrayList<>();
        ArrayList<Tecnico> tecnicosLista = new ArrayList<>();
        ArrayList<Jogador> jogadoresLista = new ArrayList<>();
        ArrayList<Admin> adminLista = new ArrayList<>();
        LeJson leJson = new LeJson(new Session(1, "669.272.660-38", "Editor"));
        leJson.getTimes(timesLista);
        leJson.getTecnico(tecnicosLista, timesLista);
        leJson.getJogador(jogadoresLista, timesLista);
        leJson.getAdministrdor(adminLista);
        Login login = new Login(jogadoresLista, adminLista, tecnicosLista) {
        };
        login.setVisible(true);

    }
}
        