/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Atacante extends Jogador{
    private int reflexo;
    private int chute;
    private int marcação;
    private int passe;
    private int velocidade;
    private float notaGeral;

    @Override
    public String toString() {
        return super.toString();
    }

    public Atacante(CPF cpf, String nome, int cargo, String senha, String posicao, int numCamisa, Time time, boolean titular, int reflexo, int chute, int marcação, int passe, int velocidade) {
        super(cpf, nome, cargo, senha, posicao, numCamisa, time, titular);
        this.reflexo = reflexo;
        this.chute = chute;
        this.marcação = marcação;
        this.passe = passe;
        this.velocidade = velocidade;
    }
    public void setReflexo(int val)
    {
        this.reflexo = val;
    }
    
    public int getReflexo()
    {
        return reflexo;
    }
    
    public void setChute(int val)
    {
        this.chute = val;
    }
    
    public int getChute()
    {
        return chute;
    }
    
    public void setMarcação(int val)
    {
        this.marcação = val;
    }
    
    public int getMarcação()
    {
        return marcação;
    }
    
    public void setPasse(int val)
    {
        this.passe = val;
    }
    
     public int getPasse()
    {
        return passe;
    }
     
     public void setVelocidade(int val)
    {
        this.velocidade = val;
    }
     
      public int getVelocidade()
    {
        return velocidade;
    }
      
    /**
     *
     * @param jogador
     * @return
     */
    @Override
      public float calculaNotaGeral(Jogador jogador)
      {
          
          this.notaGeral = (float) (reflexo+chute*3+marcação+passe*2+velocidade*3);
          return notaGeral;
      }
}
