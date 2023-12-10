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
}
