package com.mycompany.trabalho_oo2;

import com.google.gson.*;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdicionaJson {
    private String nomeArquivo;

    protected Session session;

    public AdicionaJson(Session session) {
        this.session = session;
        if(session.getCargo() ==1) {
            this.nomeArquivo = System.getProperty("user.dir") + "\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data";
        }
    }

    public void adicionaJogador(
            List<Jogador> jogadoresLista, List<Time> timesLista,
            String cpf,String nome,int cargo,String senha,String posicao, int numCamisa,int idTime, boolean titular, int reflexo, int chute, int marcacao, int passe, int velocidade
    ){
        Time timeJogador = null;
        for (Time time : timesLista){
            if (time.getId() == idTime){
                timeJogador = time;
                break;
            }
        }
        CPF classCpf = new CPF(cpf);
        Jogador jogador;
        switch (posicao){
            case "AT":
                jogador = new Atacante(classCpf, nome, cargo, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                break;
            case "MC":
                jogador = new Meia(classCpf, nome, cargo, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                break;
            case "ZG":
                jogador = new Zagueiro(classCpf, nome, cargo, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                break;
            case "G":
                jogador = new Goleiro(classCpf, nome, cargo, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                break;
            default:
                jogador = null;
                throw new RuntimeException("Jogador vazio!");
        }
        jogadoresLista.add(jogador);
        for(Jogador j: jogadoresLista){
            if (j.getCpf() == cpf){
                JOptionPane.showMessageDialog(null, "Algum campo não está preenchido de forma correta!", "Aviso", JOptionPane.WARNING_MESSAGE);
                new RuntimeException("Jogador já cadastrado!!!");
            }
        }

        String nomeArquivo = this.nomeArquivo+"/jogadores.json";

        try (FileReader fileReader = new FileReader(nomeArquivo)) {
            // Ler o JSON existente
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // Obter a lista de jogadores
            JsonArray jogadoresArray = jsonObject.getAsJsonArray("jogadores");

            // Adicionar o novo jogador à lista
            JsonObject novoJogador = new JsonObject();
            novoJogador.addProperty("posicao", posicao);
            novoJogador.addProperty("numCamisa", numCamisa);
            novoJogador.addProperty("idTime", idTime);
            novoJogador.addProperty("titular", titular);
            novoJogador.addProperty("cpf", cpf);
            novoJogador.addProperty("nome", nome);
            novoJogador.addProperty("cargo", cargo);
            novoJogador.addProperty("senha", senha);
            novoJogador.addProperty("reflexo", reflexo);
            novoJogador.addProperty("chute", chute);
            novoJogador.addProperty("marcacao", marcacao);
            novoJogador.addProperty("passe", passe);
            novoJogador.addProperty("velocidade", velocidade);

            jogadoresArray.add(novoJogador);

            // Atualizar o JSON com a nova lista de jogadores
            jsonObject.add("jogadores", jogadoresArray);

            // Escrever o JSON atualizado de volta no arquivo
            try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, fileWriter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionaTecnico(
            List<Tecnico> tecnicosLista,List<Time> timesLista,
            String cpf,String nome,int cargo,String senha, int idTime
    ){
        Time timeTecnico = null;
        for (Time time : timesLista){
            if (time.getId() == idTime){
                timeTecnico = time;
                break;
            }
        }

        CPF classCpf = new CPF(cpf);
        Tecnico tecnico = new Tecnico(classCpf, nome, cargo, senha, timeTecnico);
        tecnicosLista.add(tecnico);

        String nomeArquivo = this.nomeArquivo+"/tecnicos.json";

        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray tecnicosArray = jsonObject.getAsJsonArray("tecnicos");

            JsonObject novoTecnico = new JsonObject();
            novoTecnico.addProperty("time", idTime);
            novoTecnico.addProperty("cpf", cpf);
            novoTecnico.addProperty("nome", nome);
            novoTecnico.addProperty("cargo", cargo);
            novoTecnico.addProperty("senha", senha);


            tecnicosArray.add(novoTecnico);

            jsonObject.add("tecnicos", tecnicosArray);

            try(FileWriter fileWriter = new FileWriter(nomeArquivo)){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, fileWriter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionaAdmin(
            List<Admin> administradoresLista,
            String cpf,String nome,int cargo,String senha
    ){
        CPF classCpf = new CPF(cpf);
        Admin admin = new Admin(classCpf, nome, cargo, senha);
        administradoresLista.add(admin);

        String nomeArquivo = this.nomeArquivo+"/administradores.json";
        try(FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray administradoresArray = jsonObject.getAsJsonArray("administradores");

            JsonObject novoAdmin = new JsonObject();
            novoAdmin.addProperty("cpf", cpf);
            novoAdmin.addProperty("nome", nome);
            novoAdmin.addProperty("cargo", cargo);
            novoAdmin.addProperty("senha", senha);

            administradoresArray.add(novoAdmin);

            jsonObject.add("administradores", administradoresArray);

            try(FileWriter fileWriter = new FileWriter(nomeArquivo)){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionaTime(
            ArrayList<Time> timesLista,
            String nome, String cidade
    ){
        //cria um id para o time
        boolean idExiste = true;
        int id = 0;
        for (Time time : timesLista) {
            if (time.getNomeTime().equals(nome) && time.getCidade().equals(cidade)) {
                JOptionPane.showMessageDialog(null, "Time já cadastrado!!! [Mude nome]", "Aviso", JOptionPane.WARNING_MESSAGE);
                new RuntimeException("Esse time já foi criado");
            }
        }
        while (idExiste) {
            id = new Random().nextInt(Integer.MAX_VALUE);
            idExiste = false;

            for (Time time : timesLista) {
                if (time.getId() == id) {
                    idExiste = true;
                    break;
                }
            }
        }

        String nomeArquivo = this.nomeArquivo+"/times.json";

        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray timesArray = jsonObject.getAsJsonArray("times");

            JsonObject novoTime = new JsonObject();
            novoTime.addProperty("id", id);
            novoTime.addProperty("nomeTime", nome);
            novoTime.addProperty("cidade", cidade);

            timesArray.add(novoTime);

            jsonObject.add("times", timesArray);

            try(FileWriter fileWriter = new FileWriter(nomeArquivo)){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void adicionaPartida(
            List<Partida> partidasLista, List<Time> timesLista,
            int id, int idTime1, int idTime2, String placar, String hora
    ){
        Time time1 = null;
        Time time2 = null;
        for(Time time : timesLista){
            if(time.getId() == idTime1){
                time1 = time;
                break;
            }
        }

        for(Time time : timesLista){
            if(time.getId() == idTime2){
                time2 = time;
                break;
            }
        }
        if(time1.getId() == time2.getId()){
            throw new RuntimeException("Times não podem ser iguais");
        }else {
            Partida partida = new Partida(id, time1, time2, placar, hora);
            partidasLista.add(partida);
            String nomeArquivo = this.nomeArquivo + "/partidas.json";
            try (FileReader fileReader = new FileReader(nomeArquivo)) {
                JsonElement jsonElement = JsonParser.parseReader(fileReader);
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                JsonArray partidasArray = jsonObject.getAsJsonArray("partidas");

                JsonObject novaPartida = new JsonObject();
                novaPartida.addProperty("id", id);
                novaPartida.addProperty("idTime1", idTime1);
                novaPartida.addProperty("idTime2", idTime2);
                novaPartida.addProperty("hora", hora);
                novaPartida.addProperty("placar", "0x0");

                partidasArray.add(novaPartida);

                jsonObject.add("partidas", partidasArray);

                try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    gson.toJson(jsonObject, fileWriter);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
