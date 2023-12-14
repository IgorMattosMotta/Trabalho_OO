
package com.mycompany.trabalho_oo2;

//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
public class Tecnico extends Pessoa{
    private Time time;

    public Tecnico(CPF cpf, String nome, int cargo, String senha, Time time) {
        super(cpf,nome,cargo,senha);
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time timeTecnico) {
        this.time = timeTecnico;
    }
}
