package com.mycompany.trabalho_oo2;

public class ValidaPlacar {
    public static boolean validarPlacar(String placar) {
        // Verificar se a string não é nula e tem o formato esperado
        if (placar != null && placar.matches("\\d+[xX]\\d+")) {
            // Verificar se os placares são válidos
            String[] placares = placar.split("[xX]");
            int placarTime1 = Integer.parseInt(placares[0]);
            int placarTime2 = Integer.parseInt(placares[1]);

            return placarTime1 >= 0 && placarTime2 >= 0;
        }

        return false;
    }
}