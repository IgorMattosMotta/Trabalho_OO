package com.mycompany.trabalho_oo2;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class EditaJson {
    private String nomeArquivo;
    protected Session session;

    public EditaJson(Session session){
        this.session = session;
        if(session.getCargo() ==1) {
            this.nomeArquivo = System.getProperty("user.dir") + "\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data";
        }
    }

    public void editaJogador(
            List<Jogador> jogadoresLista, List<Time> timesLista,
            String cpf, String nome, int numCamisa, int idTime, boolean titular
    ){
        //edita o objeto tecnico na lista de tecnicos
        int idTimeJogador = 0;
        Time timeJogador = null;
        for (Time time : timesLista){
            if (time.getId() == idTime){
                timeJogador = time;
                idTimeJogador = time.getId();
                break;
            }
        }

        for (Jogador jogador : jogadoresLista){
            if (jogador.getCpf().equals(cpf)){
                jogador.setNome(nome);
                //jogador.setPosicao(posicao);
                jogador.setNumCamisa(numCamisa);
                jogador.setTime(timeJogador);
                jogador.setTitular(titular);
                break;
            }
        }

        //edita o objeto jogador no arquivo json
        try{
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(this.nomeArquivo+"\\jogadores.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jogadoresArray = jsonObject.getAsJsonArray("jogadores");

            int indiceJogador = 0;

            for (JsonElement jsonElement1 : jogadoresArray){
                JsonObject jogador = jsonElement1.getAsJsonObject();
                if (jogador.get("cpf").getAsString().equals(cpf)){
                    break;
                }
                indiceJogador++;
            }
            System.out.println(indiceJogador);
            JsonObject primeiroJogador = jogadoresArray.get(indiceJogador).getAsJsonObject();

            primeiroJogador.addProperty("nome", nome);
            primeiroJogador.addProperty("numCamisa", numCamisa);
            primeiroJogador.addProperty("titular", titular);
            //primeiroJogador.addProperty("posicao", posicao);
            primeiroJogador.addProperty("idTime", idTimeJogador);

            try (FileWriter fileWriter = new FileWriter(this.nomeArquivo+"\\jogadores.json")) {
                Gson gson = new Gson();
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Arquivo JSON atualizado com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editaTecnico(
            List<Tecnico> tecnicosLista,List<Time> timesLista,
            String cpf,String nome,int idTime
    ){
        //edita o objeto tecnico na lista de tecnicos
        int idTimeTecnico = 0;
        Time timeTecnico = null;
        for (Time time : timesLista){
            if (time.getId() == idTime){
                timeTecnico = time;
                idTimeTecnico = time.getId();
                break;
            }
        }

        for (Tecnico tecnico : tecnicosLista){
            if (tecnico.getCpf().equals(cpf)){
                tecnico.setNome(nome);
                tecnico.setTime(timeTecnico);
                break;
            }
        }

        //edita o objeto tecnico no arquivo json
        try{
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(this.nomeArquivo+"\\tecnicos.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray tecnicosArray = jsonObject.getAsJsonArray("tecnicos");

            int indiceTecnico = 0;

            for (JsonElement jsonElement1 : tecnicosArray){
                JsonObject tecnico = jsonElement1.getAsJsonObject();
                if (tecnico.get("cpf").getAsString().equals(cpf)){
                    break;
                }
                indiceTecnico++;
            }
            System.out.println(indiceTecnico);
            JsonObject primeiroJogador = tecnicosArray.get(indiceTecnico).getAsJsonObject();

            primeiroJogador.addProperty("nome", nome);
            primeiroJogador.addProperty("idTime", idTimeTecnico);

            try (FileWriter fileWriter = new FileWriter(this.nomeArquivo+"\\tecnicos.json")) {
                Gson gson = new Gson();
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Arquivo JSON atualizado com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editaAdmin(
            List<Admin> adminLista,
            String cpf,String nome
    ){
        for (Admin admin : adminLista){
            if (admin.getCpf().equals(cpf)){
                admin.setNome(nome);
                break;
            }
        }

        //edita o objeto admin no arquivo json
        //edita o objeto tecnico no arquivo json
        try{
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(this.nomeArquivo+"\\administradores.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray tecnicosArray = jsonObject.getAsJsonArray("administradores");

            int indiceAdmin = 0;

            for (JsonElement jsonElement1 : tecnicosArray){
                JsonObject admin = jsonElement1.getAsJsonObject();
                if (admin.get("cpf").getAsString().equals(cpf)){
                    break;
                }
                indiceAdmin++;
            }
            System.out.println(indiceAdmin);
            JsonObject primeiroJogador = tecnicosArray.get(indiceAdmin).getAsJsonObject();

            primeiroJogador.addProperty("nome", nome);

            try (FileWriter fileWriter = new FileWriter(this.nomeArquivo+"\\administradores.json")) {
                Gson gson = new Gson();
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Arquivo JSON atualizado com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editaPartida(
            String placar, String hora, int idTimeCasa, int idTimeVisitante, int idPartida
    ){

        //edita o objeto partida no arquivo json
        try{
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(this.nomeArquivo+"\\partidas.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray partidasArray = jsonObject.getAsJsonArray("partidas");

            int indicePartida = 0;

            for (JsonElement jsonElement1 : partidasArray){
                JsonObject partida = jsonElement1.getAsJsonObject();
                if (partida.get("id").getAsInt() == idPartida){
                    break;
                }
                indicePartida++;
            }
            System.out.println(indicePartida);
            JsonObject primeiroJogador = partidasArray.get(indicePartida).getAsJsonObject();

            primeiroJogador.addProperty("timeCasa", idTimeCasa);
            primeiroJogador.addProperty("timeVisitante", idTimeVisitante);
            primeiroJogador.addProperty("placar", placar);
            primeiroJogador.addProperty("horario", hora);

            try (FileWriter fileWriter = new FileWriter(this.nomeArquivo+"\\partidas.json")) {
                Gson gson = new Gson();
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Arquivo JSON atualizado com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editaTime(
            Time timeEdita,
            String nome, String cidade, int idTime
    ){

        timeEdita.setNomeTime(nome);
        timeEdita.setCidade(cidade);


        try{
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(this.nomeArquivo+"\\times.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray timesArray = jsonObject.getAsJsonArray("times");

            int indicetime = 0;

            for (JsonElement jsonElement1 : timesArray){
                JsonObject time = jsonElement1.getAsJsonObject();
                if (time.get("id").getAsInt() == idTime){
                    break;
                }
                indicetime++;
            }
            System.out.println(indicetime);
            JsonObject primeiroJogador = timesArray.get(indicetime).getAsJsonObject();

            primeiroJogador.addProperty("nomeTime", nome);
            primeiroJogador.addProperty("nomeCidade", cidade);

            try (FileWriter fileWriter = new FileWriter(this.nomeArquivo+"\\times.json")) {
                Gson gson = new Gson();
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Arquivo JSON atualizado com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
