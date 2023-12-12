/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

import java.util.ArrayList;

/**
 *
 * @author igorm
 */
public class Time {
    private int id;
    private String nomeTime;
    private String cidade;

    @Override
    public String toString() {
        return nomeTime ;
    }

    public Time(int id, String nomeTime, String cidade) {

        this.id = id;

        this.nomeTime = nomeTime;
        this.cidade = cidade;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getCidade() {
        return cidade;
    }

    public int getId() { return id; }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
