/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;
//Grupo:
//Igor Mattos da Motta - 202276006
//Álvaro Davi Carneiro dos Santos - 202176037
//Davi Laranjo Villa - 202235025
import javax.swing.*;

public class CPF {
    private static String cpf;
    public CPF(String cpf) {
        this.cpf = retiraCaracEspecial(cpf);
    }
    public static String getCpf() {
        return cpf;
    }
    
     public static String validacpf(String cpf){
         if(!ehValido(cpf)){
             JOptionPane.showMessageDialog(null, "CPF INVÁLIDO!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
             return null;
         }else{
             return retiraCaracEspecial(cpf);
         }
    }


    public static boolean ehValido(String cpf){
        try {
            cpf = retiraCaracEspecial(cpf);
            int[] arrayCpf = transformaCpfArrayInt(cpf);

            return verificaCodigo(1, arrayCpf) == true;
        }catch (RuntimeException e){
            return false;
        }
        
    }

    private static int[] transformaCpfArrayInt(String cpf){
        int[] arrayCpf = new int[11];
        for(int i = 0; i <= 10; i++){
            arrayCpf[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }
        return arrayCpf;
    }
    
    private static String retiraCaracEspecial(String cpf){
        if(cpf.contains(".") || cpf.contains("-")){
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
    }
        return cpf;
    }
        
    private static boolean  verificaCodigo(int posicaoCod, int[] cpf){
        int j;
        if(posicaoCod == 1){
            j = 10;
        }else{
            j= 11;
        }
        //Diz até onde eu devo contar
        int parametro = 7 + posicaoCod;
        
        int res = 0;
        
        for(int i = 0; i <= parametro; i++){
            res += j * cpf[i];
            j--;
        }
        
        int restoDiv = res % 11;
        
        if(restoDiv < 2){
            if(cpf[parametro + 1] == 0){
                if(posicaoCod == 1){
                    return verificaCodigo(2, cpf);
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{
            int dif = 11 - restoDiv;
            if(cpf[parametro + 1] == dif){
                if(posicaoCod == 1){
                    return verificaCodigo(2, cpf);
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }
    }
}
