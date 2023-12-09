package com.mycompany.trabalho_oo2;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeJson {
    private String nomeArquivo;

    public LeJson(){
    }

    public void getPessoa(ArrayList<Pessoas> pessoasLista){
        //pego o caminho do arquivo
        String nomeArquivo = "C:\\Programas\\UFJF\\OO\\trabalho\\Trabalho_OO\\Trabalho_OO\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data/pessoas.json";

        //tento ler o arquivo pelo caminho dito anteriormente
        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //pego o array de pessoas
            JsonArray jogadoresArray = jsonObject.getAsJsonArray("pessoas");

            //for each para cada pessoa no array de pessoas
            for (JsonElement jogadorElement : jogadoresArray) {
                JsonObject jogadorObject = jogadorElement.getAsJsonObject();
                //pego os atributos de cada pessoa
                String cpf = jogadorObject.get("cpf").getAsString();
                String nome = jogadorObject.get("nome").getAsString();
                int cargo = jogadorObject.get("cargo").getAsInt();
                String senha = jogadorObject.get("senha").getAsString();
                //crio uma nova pessoa com os atributos pegos
                Pessoas novaPessoa = new Pessoas(new CPF(cpf), new Nome(nome), new Cargo(cargo), senha, pessoasLista);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
