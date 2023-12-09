package com.mycompany.trabalho_oo2;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.util.ArrayList;

public class LeJson {
    private String nomeArquivo;

    public LeJson(){
    }

    public void getPessoas(ArrayList<Pessoas> pessoasLista){
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

    public void getTimes(ArrayList<Time> timesLista){
        //pego o caminho do arquivo
        String nomeArquivo = "C:\\Programas\\UFJF\\OO\\trabalho\\Trabalho_OO\\Trabalho_OO\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data/times.json";
        //tento ler o arquivo pelo caminho dito anteriormente
        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //pego o array de pessoas
            JsonArray timesArray = jsonObject.getAsJsonArray("times");

            //for each para cada pessoa no array de pessoas
            for (JsonElement timeElement : timesArray) {
                JsonObject timeObject = timeElement.getAsJsonObject();
                //pego os atributos de cada pessoa
                int id = timeObject.get("id").getAsInt();
                String nome = timeObject.get("nomeTime").getAsString();
                String cidade = timeObject.get("cidade").getAsString();
                //crio um novo time com os atributos pegos
                Time novoTime = new Time(id,nome,cidade);
                timesLista.add(novoTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPartidas(ArrayList<Partida> partidasLista, ArrayList<Time> timesLista){
        //pego o caminho do arquivo
        String nomeArquivo = "C:\\Programas\\UFJF\\OO\\trabalho\\Trabalho_OO\\Trabalho_OO\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data/partidas.json";
        //tento ler o arquivo pelo caminho dito anteriormente
        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //pego o array de partidas
            JsonArray partidasArray = jsonObject.getAsJsonArray("partidas");

            //for each para cada pessoa no array de pessoas
            for (JsonElement partidaElement : partidasArray) {
                JsonObject partidaObject = partidaElement.getAsJsonObject();
                //pego os atributos de cada partida
                int id = partidaObject.get("id").getAsInt();
                int idTimeCasa = partidaObject.get("timeCasa").getAsInt();
                int idTimeVisitante = partidaObject.get("timeVisitante").getAsInt();
                String placar = partidaObject.get("placar").getAsString();
                String horario = partidaObject.get("horario").getAsString();

                Time timeCasa = null;
                Time timeVisitante = null;
                //acho o time da casa e o time visitante
                for (Time time : timesLista){
                    if (time.getId() == idTimeCasa){
                        timeCasa = time;
                    }
                    if (time.getId() == idTimeVisitante){
                        timeVisitante = time;
                    }
                }

                //crio uma nova partida com os atributos pegos
                Partida novaPartida = new Partida(id,timeCasa,timeVisitante,placar,horario);
                partidasLista.add(novaPartida);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
