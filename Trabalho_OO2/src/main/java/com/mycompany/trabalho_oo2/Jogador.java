package com.mycompany.trabalho_oo2;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author igorm
 */
public class Jogador extends Pessoa{
    private String posicao;
    private int numCamisa;
    private Time time;
    private boolean titular;
    private List<Gols> gols;


    public Jogador(CPF cpf, Nome nome, Cargo cargo, String senha, String posicao, int numCamisa, Time time, boolean titular) {
        super(cpf, nome, cargo, senha);
        this.posicao = posicao;
        this.numCamisa = numCamisa;
        this.time = time;
        this.titular = titular;
        this.gols = new ArrayList<>();
    }
    public Time getTime() {
        return time;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getNumCamisa() {
        return numCamisa;
    }

    public boolean isTitular() {
        return titular;
    }

    public void adicionarGol(Gols gol) {
        this.gols.add(gol);
    }
}
