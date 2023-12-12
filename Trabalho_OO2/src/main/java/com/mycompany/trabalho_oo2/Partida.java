/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class Partida {
    private int id;
    private Time timeCasa;
    private Time timeVisitante;
    private String placar;
    private String horario;

    public Partida(int id, Time timeCasa, Time timeVisitante, String placar, String horario) {
        this.id = id;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.placar = placar;
        this.horario = horario;
    }

    public Time getTimeCasa() {
        return this.timeCasa;
    }

    public Time getTimeVisitante() {
        return this.timeVisitante;
    }

    public String getPlacar() {
        return this.placar;
    }

    public String getHorario() {
        return this.horario;
    }

    public int getId() { return this.id; }

    public void setTimeCasa(Time timeCasa) {
        this.timeCasa = timeCasa;
    }

    public void setTimeVisitante(Time timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public void setPlacar(String placar) {
        this.placar = placar;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


}
