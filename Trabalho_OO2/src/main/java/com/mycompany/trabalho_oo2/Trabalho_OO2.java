package com.mycompany.trabalho_oo2;
/* Igor Mattos - 202276006
   Álvaro Davi -  202176037
   Davi
 */

import com.mycompany.trabalho_oo2.aplicacao.Login;

import java.util.ArrayList;

public class Trabalho_OO2 {

    public static void main(String[] args) {
        //ao iniciar o programa, o mesmo deve ler os arquivos json e armazenar os dados em listas
        ArrayList<Time> timesLista = new ArrayList<>();
        ArrayList<Tecnico> tecnicosLista = new ArrayList<>();
        ArrayList<Jogador> jogadoresLista = new ArrayList<>();
        ArrayList<Admin> adminLista = new ArrayList<>();
        LeJson leJson = new LeJson();
        leJson.getTimes(timesLista);
        leJson.getTecnico(tecnicosLista, timesLista);
        leJson.getJogador(jogadoresLista, timesLista);
        leJson.getAdministrdor(adminLista);
        Login login = new Login(jogadoresLista, adminLista, tecnicosLista) {
        };
        login.setVisible(true);
    }
}
        