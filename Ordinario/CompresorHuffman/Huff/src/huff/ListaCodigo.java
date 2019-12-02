/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huff;

/**
 *
 * @author fabi
 */
public class ListaCodigo {
    NodoCodigo raiz = null;
    NodoCodigo aux = null; 
    
    NodoCodigo devolverAux(){
        return aux;
    }
    
    NodoCodigo obtenerRaiz (){
        return raiz;
    }
    
   void insertar(NodoCodigo nodo){
       NodoCodigo nuevo = new NodoCodigo();
       nuevo.caracter = nodo.caracter;
       nuevo.codigo = nodo.codigo;
       nuevo.siguiente = nodo.siguiente;
       NodoCodigo aux = new NodoCodigo();
       NodoCodigo aux2 = new NodoCodigo(); 
       
       if(raiz == null){
           raiz = nuevo;
           aux = nuevo;
           nuevo.siguiente = null;
       }else{
           aux = raiz; 
           while(aux != null){
               aux2 = aux.siguiente;
               if(nuevo.caracter <= aux.caracter){
                   nuevo.siguiente = raiz;
                   raiz = nuevo;
                   break;
               }else{
                   if((nuevo.caracter > aux.caracter)&&(aux2 == null)){
                       aux.siguiente = nuevo;
                       nuevo.siguiente = null;
                       break;
                   }else{
                       if((aux.caracter < nuevo.caracter)&&(aux2.caracter >= nuevo.caracter)){
                           aux.siguiente = nuevo;
                           nuevo.siguiente = aux2;
                           break;
                       }else{
                           aux = aux.siguiente;
                       }
                   }
               }
           }
       }
   }
}
