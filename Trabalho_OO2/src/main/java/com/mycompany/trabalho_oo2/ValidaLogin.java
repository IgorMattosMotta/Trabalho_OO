package com.mycompany.trabalho_oo2;
import java.util.List;

public class ValidaLogin {
    private List<Tecnico> tecnicosLista;
    private List<Admin> adminLista;
    private List<Jogador> jogadoresLista;

    public ValidaLogin(List<Tecnico> tecnicosLista, List<Admin> adminLista, List<Jogador> jogadoresLista){
        this.tecnicosLista = tecnicosLista;
        this.adminLista = adminLista;
        this.jogadoresLista = jogadoresLista;
    }

    public Tecnico autenticarTecnico(String cpf, String senha) {
        String cpfLogin = cpf.replaceAll("[^0-9]", "");
        for (Tecnico tecnico : tecnicosLista) {
            if (tecnico.getCpf().equals(cpfLogin) && tecnico.validarSenha(senha)) {
                return tecnico;
            }
        }
        return null;
    }

    public Admin autenticarAdmin(String cpf, String senha) {
        String cpfLogin = cpf.replaceAll("[^0-9]", "");
        for (Admin admin : adminLista) {
            if (admin.getCpf().equals(cpfLogin) && admin.validarSenha(senha)) {
                return admin;
            }
        }
        return null;
    }

    public Jogador autenticarJogador(String cpf, String senha) {
        String cpfLogin = cpf.replaceAll("[^0-9]", "");
        for (Jogador jogador : jogadoresLista) {
            if (jogador.getCpf().equals(cpfLogin) && jogador.validarSenha(senha)) {
                return jogador;
            }
        }
        return null;
    }
}
