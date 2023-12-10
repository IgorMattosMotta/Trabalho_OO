/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa 202235025
public class Meia extends Jogador{
    private int reflexo;
    private int chute;
    private int marcação;
    private int passe;
    private int velocidade;
    private float notaGeral;
    
    private Meia(String cpf, String nome, String cargo, String senha, String posicao, Gols numGols, int numCamisa, String time, boolean titular) {
        super(cpf, nome, cargo, senha,posicao,numGols,numCamisa,time,titular);
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
     
     * @return
     */
      // Função que calcula a nota geral do jogador, com diferentes pesos nos atributos
      // baseado nas necessidades da posição do jogador
    @Override
      public float calculaNotaGeral()
      {
          
          this.notaGeral = (float) (reflexo*2+chute*1.5+marcação*3+passe*2+velocidade*1.5);
          return notaGeral;
      }
}