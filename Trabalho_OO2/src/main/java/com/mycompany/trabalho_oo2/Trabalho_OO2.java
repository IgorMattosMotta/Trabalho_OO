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
        AdicionaJson adicionaJson = new AdicionaJson();
        adicionaJson.adicionaJogador(jogadoresLista,timesLista);





        /*String cpf = "11545693064";
        String senha = "senha123";
        ValidaLogin validaLogin = new ValidaLogin(tecnicosLista, adminLista, jogadoresLista);
        if(validaLogin.autenticarTecnico(cpf, senha) != null){
            Tecnico userLogado = validaLogin.autenticarTecnico(cpf, senha);
            System.out.println("Tecnico logado");
        }else if(validaLogin.autenticarAdmin(cpf,senha) != null){
            Admin userLogado = validaLogin.autenticarAdmin(cpf, senha);
            System.out.println("Admin logado");
        } else if(validaLogin.autenticarJogador(cpf,senha) != null){
            Jogador userLogado = validaLogin.autenticarJogador(cpf, senha);
            System.out.println("Jogador logado");
        } else{
            System.out.println("Login inválido");
        }*/

    }
}
        