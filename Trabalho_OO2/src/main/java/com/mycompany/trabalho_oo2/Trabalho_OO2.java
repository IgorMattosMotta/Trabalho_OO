/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.trabalho_oo2;
import java.util.ArrayList;

/**
 *
 * @author igorm
 */
public class Trabalho_OO2 {

    public static void main(String[] args) {
         ArrayList<Pessoa> pessoasLista = new ArrayList<Pessoa>();
         try{
            Pessoa eu = new Pessoa("02355164657", "Igor MMDmasdmasd", "Admin", "dasdasdasdas");
            pessoasLista.add(eu);
            for(Pessoa e: pessoasLista){
                System.out.println(e.getCpf().getCpf());
            }
         }
         catch(RuntimeException e){
             System.out.println(e.getMessage());
         }
    }
}
