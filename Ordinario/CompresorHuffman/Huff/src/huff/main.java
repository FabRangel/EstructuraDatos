/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huff;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class main {
     public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("\t*****~~~~ Compresor Huffman ~~~~*****");
        System.out.print("Ingrese la dirección del archivo origen\n>>");
        Scanner leer = new Scanner(System.in);
        String archivoOrigen = leer.nextLine();

        
        Huff codificacion = new Huff();
        codificacion.cargarArchivo(archivoOrigen);
        codificacion.frecuencia(codificacion.cargarArchivo(archivoOrigen));	
	if (codificacion.caracterValido) {
            codificacion.ordenar();
            codificacion.nodosArbol();	
            codificacion.dequeueColaCaracteres();
            codificacion.imprimirArchivo();	
        }else{
            System.out.println("El archivo contiene caracteres no validos");
        }
    }	
      
}
