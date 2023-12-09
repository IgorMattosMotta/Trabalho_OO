package com.mycompany.trabalho_oo2;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

public abstract class LeJson {
    public static void leJson(String[] args){
        String nomeArquivoJogadores = "C:\\Programas\\UFJF\\OO\\trabalho\\Trabalho_OO\\Trabalho_OO\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data/jogadores.json";

        try(FileReader fileReader = new FileReader(nomeArquivoJogadores)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray jogadoresArray = jsonObject.getAsJsonArray("jogadores");

            for (JsonElement jogadorElement : jogadoresArray) {
                JsonObject jogadorObject = jogadorElement.getAsJsonObject();
                System.out.println("posicao: " + jogadorObject.get("posicao").getAsString());
                System.out.println("numCamisa: " + jogadorObject.get("numCamisa").getAsInt());
                System.out.println("idTime: " + jogadorObject.get("idTime").getAsInt());
                System.out.println("titular: " + jogadorObject.get("titular").getAsBoolean());
                System.out.println("CPFPessoa: " + jogadorObject.get("CPFPessoa").getAsString());
                System.out.println("-----");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
