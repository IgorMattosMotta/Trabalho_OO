package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public abstract class Jogador extends Pessoa{
    private String posicao;
    private Gols numGols;
    private int numCamisa;
    private Time time;
    private boolean titular;


    protected Jogador(CPF cpf, String nome, int cargo, String senha, String posicao, int numCamisa, Time time, boolean titular) {
        super(cpf, nome, cargo, senha);
        this.posicao = posicao;
        this.numCamisa = numCamisa;
        this.time = time;
        this.titular = titular;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    public Time getTime() {
        return time;
    }

    public String getPosicao() {
        return posicao;
    }

    public Gols getNumGols() {
        return numGols;
    }

    public int getNumCamisa() {
        return numCamisa;
    }

    public boolean isTitular() {
        return titular;
    }


    /**
     *
     * @param jogador
     * @return
     */
    public abstract float calculaNotaGeral(Jogador jogador);


}