package com.mycompany.trabalho_oo2;
import java.util.ArrayList;

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
        //AdicionaJson adicionaJson = new AdicionaJson();
        //adicionaJson.adicionaJogador(jogadoresLista,timesLista);

        System.out.println("Tecnicos Cadastrados:");
        for(Tecnico tecnico : tecnicosLista){
            System.out.println(tecnico.getNome());
        }

        System.out.println("Jogadores Cadastrados:");
        for(Jogador jogador : jogadoresLista){
            System.out.println(jogador.getNome());
        }

        System.out.println("Times Cadastrados:");
        for(Time time : timesLista){
            System.out.println(time.getCidade());
        }



    }
}
        