package com.mycompany.trabalho_oo2;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AdicionaJson {
    private String nomeArquivo;

    public AdicionaJson() {
        this.nomeArquivo = System.getProperty("user.dir")+"\\data";
    }

    public void adicionaJogador(
            List<Jogador> jogadoresLista, List<Time> timesLista,
            String cpf,String nome,int cargo,String senha,String posicao, int numCamisa,int idTime, boolean titular
    ){
        Time timeJogador = null;
        for (Time time : timesLista){
            if (time.getId() == idTime){
                timeJogador = time;
                break;
            }
        }
        CPF classCpf = new CPF(cpf);
        Jogador jogador = new Jogador(classCpf, nome, cargo, senha, posicao, numCamisa, timeJogador, titular);
        jogadoresLista.add(jogador);

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
            novoTecnico.addProperty("cpf", cpf);
            novoTecnico.addProperty("nome", nome);
            novoTecnico.addProperty("cargo", cargo);
            novoTecnico.addProperty("senha", senha);
            novoTecnico.addProperty("idTime", idTime);

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
            List<Time> timesLista,
            int id, String nome, String cidade
    ){
        String nomeArquivo = this.nomeArquivo+"/times.json";

        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray timesArray = jsonObject.getAsJsonArray("times");

            JsonObject novoTime = new JsonObject();
            novoTime.addProperty("id", id);
            novoTime.addProperty("nome", nome);
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

    public void adicionaGol(
            List<Gols> golsLista, List<Jogador> jogadoresLista, List<Partida> partidasLista,
            int id,int cpfJogador, int idPartida, String minuto
    ){

        //procura o jogador que fez o gol
        Jogador jogadorGol = null;
        for(Jogador jogador : jogadoresLista){
            if(jogador.getCpf().equals(cpfJogador)){
                jogadorGol = jogador;
                break;
            }
        }
        //procura a partida que o gol foi feito
        Partida partidaGol = null;
        for(Partida partida : partidasLista){
            if(partida.getId() == idPartida){
                partidaGol = partida;
                break;
            }
        }

        Gols gol = new Gols(id,jogadorGol, partidaGol, minuto);

        golsLista.add(gol);
        String nomeArquivo = this.nomeArquivo+"/gols.json";
        try(FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray golsArray = jsonObject.getAsJsonArray("gols");

            JsonObject novoGol = new JsonObject();
            novoGol.addProperty("id", id);
            novoGol.addProperty("cpfJogador", cpfJogador);
            novoGol.addProperty("idPartida", idPartida);
            novoGol.addProperty("minuto", minuto);

            golsArray.add(novoGol);

            jsonObject.add("gols", golsArray);

            try(FileWriter fileWriter = new FileWriter(nomeArquivo)){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionaPartida(
            List<Partida> partidasLista, List<Time> timesLista, List<Gols> golsLista,
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

        Partida partida = new Partida(id, time1, time2,placar, hora);
        partidasLista.add(partida);

        String nomeArquivo = this.nomeArquivo+"/partidas.json";
        try(FileReader fileReader = new FileReader(nomeArquivo)){
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

            try(FileWriter fileWriter = new FileWriter(nomeArquivo)){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
