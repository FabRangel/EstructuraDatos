/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String frase = "Raul";
        char[] caracteres = new char[frase.length()];
        Cola colita = new Cola();
        //System.out.println(frase.length());
        for(int i=0;i<=frase.length();i++){
            caracteres[i]=frase.charAt(i);
            colita.push(caracteres[i]);
        }
        colita.ordenar();
        colita.algoritmoHuffman();
        
    }
    
    
 
    
    
    
}
  
