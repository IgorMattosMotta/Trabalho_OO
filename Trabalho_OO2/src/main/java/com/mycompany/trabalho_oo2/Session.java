package com.mycompany.trabalho_oo2;

public final class  Session{
    private static int cargo;
    private static String cpf;
    private static String nome;
    private static String nomeCargo;



    public Session(int cargo, String cpf, String nome) {
        Session.cargo = cargo;
        Session.cpf = cpf;
        Session.nome = nome;
    }

    public int getCargo(){
        return cargo;
    }

    public static String getNomeCargo(int c) {
        switch (c){
            case 1:
                return "Administrador";
            case 2:
                return "Técnico";
            case 3:
                return  "Jogadores";
            default:
                return null;
        }
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }
}
