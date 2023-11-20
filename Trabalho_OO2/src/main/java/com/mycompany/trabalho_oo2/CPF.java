/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_oo2;

/**
 *
 * @author igorm
 */
public class CPF {
        private String cpf;

    public String getCpf() {
        return cpf;
    }
    
     public void validacpf(String cpf){
         if(!ehValido(cpf)){
             throw new RuntimeException("CPF inválido!");
         }
    }

    public CPF(String cpf) {
        this.cpf = retiraCaracEspecial(cpf);
    }


    private boolean ehValido(String cpf){
        cpf = retiraCaracEspecial(cpf);
        int[] arrayCpf = this.transformaCpfArrayInt(cpf);
        
        if(verificaCodigo(1, arrayCpf) == true){
            return true;
        }else{
            return false;
        }
        
    }
    
    private int[] transformaCpfArrayInt(String cpf){
        int[] arrayCpf = new int[11];
        for(int i = 0; i <= 10; i++){
            arrayCpf[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }
        return arrayCpf;
    }
    
    private String retiraCaracEspecial(String cpf){
        if(cpf.contains(".") || cpf.contains("-")){
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
    }
        return cpf;
    }
        
    private boolean  verificaCodigo(int posicaoCod, int[] cpf){
        int j = 0;
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
