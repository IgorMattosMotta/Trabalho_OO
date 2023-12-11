package com.mycompany.trabalho_oo2;

public class Session {
    private static int cargo;
    private static String cpf;
    private static String nome;

    public Session(int cargo, String cpf, String nome) {
        Session.cargo = cargo;
        Session.cpf = cpf;
        Session.nome = nome;
    }

    public static int getCargo(){
        return cargo;
    }

    public static String getCpf(){
        return cpf;
    }

    public static String getNome(){
        return nome;
    }
}
