/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Zagueiro extends Jogador{
    private int reflexo;
    private int chute;
    private int marcação;
    private int passe;
    private int velocidade;
    private float notaGeral;

    public Zagueiro(CPF cpf, String nome, int cargo, String senha, String posicao, int numCamisa, Time time, boolean titular) {
        super(cpf, nome, cargo, senha, posicao, numCamisa, time, titular);
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
          this.notaGeral = (float) (reflexo*2.5+chute+marcação*2.5+passe*2+velocidade*2);
          return notaGeral;
      }
}