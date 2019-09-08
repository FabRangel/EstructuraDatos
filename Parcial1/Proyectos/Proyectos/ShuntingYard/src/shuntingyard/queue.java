/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuntingyard;

/**
 *
 * @author fabi
 */
public class queue {
    NodoQueue inicio = null;
    NodoQueue fin = null;
    
    void queue(char dato){
        NodoQueue nuevo = new NodoQueue();
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
    
    char dequeue(){
        if (fin != null){
            NodoQueue aux = fin;
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
    
}
