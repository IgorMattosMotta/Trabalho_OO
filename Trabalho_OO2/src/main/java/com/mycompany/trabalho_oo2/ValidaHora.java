package com.mycompany.trabalho_oo2;

public class ValidaHora {
    public static boolean validarHora(String hora) {
        try {
            // Dividir a string da hora em partes (horas, minutos)
            String[] partes = hora.split(":");

            // Verificar se há duas partes
            if (partes.length != 2) {
                return false;
            }

            // Converter cada parte para inteiro
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);

            // Verificar se os valores estão dentro do intervalo válido
            if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59) {
                return false;
            }
            return true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
