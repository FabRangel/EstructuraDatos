/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canguros2;

/**
 *
 * @author fabi
 */
public class Cola {
    Nodo inicio = null;
    Nodo fin = null;
    
    void queue(int dato){
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.siguiente = null;
        nuevo.anterior = null;
        if (inicio != null){
            inicio.anterior = nuevo;
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }else{
            inicio = nuevo;
            fin = nuevo;
        }
       // System.out.println("***"+nuevo.dato);
    }
    
    int dequeue(){
        if (fin != null){
            Nodo aux = fin;
         //   System.out.println(aux.dato);
        if(inicio == fin){
                inicio = null;
                fin = null;
            }else{
                fin.siguiente = null;
                fin = fin.anterior;
//                fin.siguiente = null;
       
        }
            aux.siguiente = null;
            aux.anterior = null;
           // System.out.println(aux.dato);
            
        return aux.dato;
            
        } else
        return 0;
    }
    
    int tamaño(){
        Nodo aux = inicio;
        int tamaño = 0;
        while(aux!=null){
            tamaño++;
            aux = aux.siguiente;
        }
        return tamaño;
    }
}

