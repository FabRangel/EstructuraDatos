
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
public class Main {
    public static void main (String [] args){
     Scanner leer=new Scanner(System.in); 
        //int unico; 
        ListaDoble lista = new ListaDoble();        
        System.out.println("Lista:");
        lista.insertarFinal(3);
        lista.insertarFinal(9);
        lista.insertarFinal(6);
        lista.insertarFinal(3);
        lista.recorrer();
        System.out.println("********************");
        System.out.println("Inserte un elemento a buscar en la lista:");
        int buscar; 
        buscar = leer.nextInt(); 
        lista.buscarDato(buscar);
        System.out.println("********************");
        /*System.out.println("Inserte un elemento que no se encuentre en la lista:");
        unico = leer.nextInt(); 
        lista.insertarUnico(unico);
        System.out.println("Lista:");
        lista.recorrer();
        System.out.println("********************");*/
        lista.isOrdenado();
        System.out.println("********************");
       /* System.out.println("Inserte un elemento a eliminar:");
        int eliminar;
        eliminar = leer.nextInt();*/
         System.out.println("Eliminando el ultimo elemento");
         lista.eliminarFinal();
         lista.recorrer();
         System.out.println("Eliminando el primer elemento");
         lista.eliminarInicio();
         lista.recorrer();
    }
}
