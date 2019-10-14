/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static quicksort.txt.escribir;
import static quicksort.txt.obteniendoDatos;

/**
 *
 * @author fabi
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        ListaDoble lista = new ListaDoble();
        obteniendoDatos("/home/fabi/proyectos/QS.txt",lista);
       // lista.recorrer();
        
        Nodo nuevo = lista.inicio;
        while(nuevo.siguiente != null){
            nuevo = nuevo.siguiente;
        }
        lista.QS(lista.inicio,nuevo);
        System.out.println("\n");
       // lista.recorrer();
        escribir("/home/fabi/proyectos/QSsalida1.txt",lista);
       
    }
    
}
   

