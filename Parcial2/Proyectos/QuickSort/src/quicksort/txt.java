/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author fabi
 */
 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class txt{
    
    public static void obteniendoDatos(String archivo,ListaDoble lista) throws FileNotFoundException, IOException {
        String cadena;
        int numero;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            numero = Integer.parseInt(cadena);
            lista.insertarFinal(numero);
        }
        b.close();
        
    }
    public static void escribir(String archivo,ListaDoble lista) throws IOException  {

        File f; 
        f = new File(archivo);
      
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter escritura = new PrintWriter(fw);
            Nodo aux = lista.inicio;
            while(aux != null){
                escritura.println(aux.dato);
                aux = aux.siguiente;
            }
            escritura.close();


        }
    
   
}
    
