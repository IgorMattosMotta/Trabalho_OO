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
        return timeCasa;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public String getPlacar() {
        return placar;
    }

    public String getHorario() {
        return horario;
    }

    public int getId() { return id; }
}
