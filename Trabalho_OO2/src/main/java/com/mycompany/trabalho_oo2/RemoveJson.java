package com.mycompany.trabalho_oo2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveJson {
    private String nomeArquivo;

    public RemoveJson(){
        this.nomeArquivo = System.getProperty("user.dir")+"\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data";
    }

    public void removeTime(int idTimeParaExcluir){
        String nomeArquivo = this.nomeArquivo+"\\times.json";
        try (FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray timesArray = jsonObject.getAsJsonArray("times");

            int indiceParaExcluir = -1;

            for (int i = 0; i < timesArray.size(); i++) {
                JsonObject time = timesArray.get(i).getAsJsonObject();
                int idTime = time.get("id").getAsInt();

                if (idTime == idTimeParaExcluir) {
                    indiceParaExcluir = i;
                    break;
                }
            }

            if (indiceParaExcluir != -1) {
                timesArray.remove(indiceParaExcluir);
                //System.out.println("Time removido com sucesso!");

                try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                    Gson gson = new Gson();
                    gson.toJson(jsonObject, fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Time não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTecnico(String cpf){
        String nomeArquivo = this.nomeArquivo+"\\tecnicos.json";
        try (FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray tecnicosArray = jsonObject.getAsJsonArray("tecnicos");

            int indiceParaExcluir = -1;

            for (int i = 0; i < tecnicosArray.size(); i++) {
                JsonObject time = tecnicosArray.get(i).getAsJsonObject();
                String cpfTecnico = time.get("cpf").getAsString();

                if (cpfTecnico.equals(cpf)){
                    indiceParaExcluir = i;
                    break;
                }
            }

            if (indiceParaExcluir != -1) {
                tecnicosArray.remove(indiceParaExcluir);
                //System.out.println("Time removido com sucesso!");

                try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                    Gson gson = new Gson();
                    gson.toJson(jsonObject, fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Técnico não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removePartida(int id){
        String nomeArquivo = this.nomeArquivo+"\\partidas.json";
        try (FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray partidaArray = jsonObject.getAsJsonArray("partidas");

            int indiceParaExcluir = -1;

            for (int i = 0; i < partidaArray.size(); i++) {
                JsonObject time = partidaArray.get(i).getAsJsonObject();
                int idPartida = time.get("id").getAsInt();

                if (id == idPartida){
                    indiceParaExcluir = i;
                    break;
                }
            }

            if (indiceParaExcluir != -1) {
                partidaArray.remove(indiceParaExcluir);

                try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                    Gson gson = new Gson();
                    gson.toJson(jsonObject, fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Partida não encontrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeJogador(String cpf){
        String nomeArquivo = this.nomeArquivo+"\\jogadores.json";
        try (FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jogadoresArray = jsonObject.getAsJsonArray("jogadores");

            int indiceParaExcluir = -1;

            for (int i = 0; i < jogadoresArray.size(); i++) {
                JsonObject time = jogadoresArray.get(i).getAsJsonObject();
                String cpfTecnico = time.get("cpf").getAsString();

                if (cpfTecnico.equals(cpf)){
                    indiceParaExcluir = i;
                    break;
                }
            }

            if (indiceParaExcluir != -1) {
                jogadoresArray.remove(indiceParaExcluir);

                try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                    Gson gson = new Gson();
                    gson.toJson(jsonObject, fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Jogador não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeGol(int id){
        String nomeArquivo = this.nomeArquivo+"\\gols.json";
        try (FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray golArray = jsonObject.getAsJsonArray("gols");

            int indiceParaExcluir = -1;

            for (int i = 0; i < golArray.size(); i++) {
                JsonObject gol = golArray.get(i).getAsJsonObject();
                int idGol = gol.get("id").getAsInt();

                if (id == idGol){
                    indiceParaExcluir = i;
                    break;
                }
            }

            if (indiceParaExcluir != -1) {
                golArray.remove(indiceParaExcluir);

                try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                    Gson gson = new Gson();
                    gson.toJson(jsonObject, fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Gol não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeAdmin(String cpf){
        String nomeArquivo = this.nomeArquivo+"\\administradores.json";
        try (FileReader fileReader = new FileReader(nomeArquivo)) {
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray administradoresArray = jsonObject.getAsJsonArray("administradores");

            int indiceParaExcluir = -1;

            for (int i = 0; i < administradoresArray.size(); i++) {
                JsonObject administrador = administradoresArray.get(i).getAsJsonObject();
                String cpfAdministrador = administrador.get("cpf").getAsString();

                if (cpfAdministrador.equals(cpf)){
                    indiceParaExcluir = i;
                    break;
                }
            }

            if (indiceParaExcluir != -1) {
                administradoresArray.remove(indiceParaExcluir);

                try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
                    Gson gson = new Gson();
                    gson.toJson(jsonObject, fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Administradores não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
