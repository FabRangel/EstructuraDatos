/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canguros2;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cola canguros = new Cola();
        Cola resultado = new Cola();
        String comando;
        int C,d,N,Mi;
        Scanner leer = new Scanner (System.in);
        C = leer.nextInt();
        N = leer.nextInt();
        while(N>0){
            Scanner read = new Scanner (System.in);
            comando = read.nextLine();
            if((comando.charAt(0))=='N'){
                Mi = leer.nextInt();
                canguros.queue(Mi);
            }else if((comando.charAt(0))=='A'){
                C = (C-(canguros.inicio.dato))-1;
                canguros.dequeue();
            }else if((comando.charAt(0))=='C'){
                int size=canguros.tamaño();
                resultado.queue(size);
            }else if((comando.charAt(0))=='R'){
                resultado.dequeue();
            }
            N--;
        }//while
        while(resultado.inicio != null){
            System.out.println(resultado.inicio);
            resultado.dequeue();
        }
    }
    
}
