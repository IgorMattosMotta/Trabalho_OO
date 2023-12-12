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
        this.nomeArquivo = System.getProperty("user.dir")+"\\Trabalho_OO2\\src\\main\\java\\com\\mycompany\\trabalho_oo2\\data";
    }

    public void getTimes(ArrayList<Time> timesLista){
        //pego o caminho do arquivo
        String nomeArquivo = this.nomeArquivo+"/times.json";
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
        String nomeArquivo = this.nomeArquivo+"/partidas.json";
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

    public void getTecnico(ArrayList<Tecnico> tecnicosLista,ArrayList<Time> timesLista){
        //pego o caminho do arquivo
        String nomeArquivo = this.nomeArquivo+"/tecnicos.json";
        //tento ler o arquivo pelo caminho dito anteriormente
        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //pego o array de partidas
            JsonArray tecnicosArray = jsonObject.getAsJsonArray("tecnicos");

            //for each para cada pessoa no array de pessoas
            for (JsonElement tecnicoElement : tecnicosArray) {
                JsonObject tecnicoObject = tecnicoElement.getAsJsonObject();
                //pego os atributos de cada partida
                String cpf = tecnicoObject.get("cpf").getAsString();
                int idTime = tecnicoObject.get("time").getAsInt();
                String nome = tecnicoObject.get("nome").getAsString();
                String senha = tecnicoObject.get("senha").getAsString();


                //acho o time da casa e o time visitante
                Time timeTecnico = null;
                for (Time time : timesLista){
                    if (time.getId() == idTime){
                        timeTecnico = time;
                    }
                }
                //crio uma nova partida com os atributos pegos
                Tecnico novoTecnico = new Tecnico(new CPF(cpf), nome, 3, senha, timeTecnico);
                tecnicosLista.add(novoTecnico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getJogador(ArrayList<Jogador> jogadoresLista,ArrayList<Time> timesLista){
        String nomeArquivo = this.nomeArquivo+"/jogadores.json";
        //tento ler o arquivo pelo caminho dito anteriormente
        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //pego o array de jogadores
            JsonArray jogadoresArray = jsonObject.getAsJsonArray("jogadores");

            //for each para cada jogador no array de jogadores
            for (JsonElement jogadorElement : jogadoresArray) {
                JsonObject jogadorObject = jogadorElement.getAsJsonObject();
                //pego os atributos de cada jogador
                String cpf = jogadorObject.get("cpf").getAsString();
                int idTime = jogadorObject.get("idTime").getAsInt();
                String nome = jogadorObject.get("nome").getAsString();
                String senha = jogadorObject.get("senha").getAsString();
                int numCamisa = jogadorObject.get("numCamisa").getAsInt();
                String posicao = jogadorObject.get("posicao").getAsString();
                boolean titular = jogadorObject.get("titular").getAsBoolean();
                int reflexo = jogadorObject.get("reflexo").getAsInt();
                int chute = jogadorObject.get("chute").getAsInt();
                int marcacao = jogadorObject.get("marcacao").getAsInt();
                int passe = jogadorObject.get("passe").getAsInt();
                int velocidade = jogadorObject.get("velocidade").getAsInt();

                //acho o time do jogador
                Time timeJogador = null;
                for (Time time : timesLista){
                    if (time.getId() == idTime){
                        timeJogador = time;
                        break;
                    }
                }
                //crio um novo jogador com os atributos pegos
                Jogador novoJogador;
                switch (posicao){
                    case "AT":
                        novoJogador = new Atacante(new CPF(cpf), nome, 1, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                        break;
                    case "MC":
                        novoJogador = new Meia(new CPF(cpf), nome, 1, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                        break;
                    case "ZG":
                        novoJogador = new Zagueiro(new CPF(cpf), nome, 1, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                        break;
                    case "G":
                        novoJogador = new Goleiro(new CPF(cpf), nome, 1, senha, posicao, numCamisa, timeJogador, titular, reflexo, chute, marcacao, passe, velocidade);
                        break;
                    default:
                        novoJogador = null;
                        throw new RuntimeException("Jogador vazio ou posicao não reconhecida!!");
                }
                jogadoresLista.add(novoJogador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAdministrdor(ArrayList<Admin> administradoresLista){
        String nomeArquivo = this.nomeArquivo+"/administradores.json";
        //tento ler o arquivo pelo caminho dito anteriormente
        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //pego o array de admins
            JsonArray administradoresArray = jsonObject.getAsJsonArray("administradores");

            //for each para cada admin no array de admins
            for (JsonElement administradorElement : administradoresArray) {
                JsonObject administradorObject = administradorElement.getAsJsonObject();
                //pego os atributos de cada partida
                String cpf = administradorObject.get("cpf").getAsString();
                String nome = administradorObject.get("nome").getAsString();
                String senha = administradorObject.get("senha").getAsString();

                //crio um novo admin com os atributos pegos
                Admin novoAdmin = new Admin(new CPF(cpf), nome, 1, senha);
                administradoresLista.add(novoAdmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getGols(ArrayList<Gols> golsLista,ArrayList<Jogador> jogadoresLista,ArrayList<Partida> partidasLista){
        String nomeArquivo = this.nomeArquivo+"/gols.json";
        //tento ler o arquivo pelo caminho dito anteriormente
        try(FileReader fileReader = new FileReader(nomeArquivo)){
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            //pego o array de gols
            JsonArray golsArray = jsonObject.getAsJsonArray("gols");

            //for each para cada gol no array de gols
            for (JsonElement golElement : golsArray) {
                JsonObject golObject = golElement.getAsJsonObject();
                //pego os atributos de cada jogador
                int id = golObject.get("id").getAsInt();
                //System.out.println(id);
                String cpf = golObject.get("cpf").getAsString();
                //System.out.println(cpf);
                int idPartida = golObject.get("partida").getAsInt();
                //System.out.println(idPartida);
                String tempo = golObject.get("tempo").getAsString();
                //System.out.println(tempo);

                //acho o jogador do gol
                String cpfJogador = cpf.replaceAll("[^0-9]", "");
                Jogador jogadorGol = null;
                for (Jogador jogador : jogadoresLista){
                    if (jogador.getCpf().equals(cpfJogador)){
                        jogadorGol = jogador;
                    }
                }

                //acha a partida do gol
                Partida partidaGol = null;
                for (Partida partida : partidasLista){
                    if (partida.getId() == idPartida){
                        partidaGol = partida;
                    }
                }


                //crio um novo jogador com os atributos pegos
                Gols novoGol = new Gols(id,jogadorGol,partidaGol,tempo);
                golsLista.add(novoGol);
                //jogadorGol.adicionarGol(novoGol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
