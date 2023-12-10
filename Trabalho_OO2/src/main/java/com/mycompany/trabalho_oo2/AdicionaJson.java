package com.mycompany.trabalho_oo2;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
public class AdicionaJson {
    private String nomeArquivo;

    public AdicionaJson() {
        this.nomeArquivo = "C:\\Programas\\UFJF\\OO\\trabalho\\Trabalho_OO\\Trabalho_OO\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data/";
    }

    public void adicionaJogador(List<Jogador> jogadoresLista, List<Time> timesLista){
        int idTime = 1;
        Time timeJogador = null;
        for (Time time : timesLista){
            if (time.getId() == idTime){
                timeJogador = time;
            }
        }
        Nome nome = new Nome("Bruno Guimaraes");
        CPF cpf = new CPF("072.491.550-83");
        Cargo cargo = new Cargo(3);
        Jogador jogador = new Jogador(cpf, nome, cargo, "Guimaraesbrabo", "AT", 10, timeJogador, true);

        jogadoresLista.add(jogador);
    }
}
