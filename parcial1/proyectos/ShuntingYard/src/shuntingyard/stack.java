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
public class stack {
    NodoStack inicio;
    void push(char dato){
        NodoStack nuevo=new NodoStack();
        nuevo.dato = dato;
        nuevo.siguiente = null;
        if(inicio == null){
            inicio = nuevo;
        }else {
            nuevo.siguiente = inicio;
            inicio=nuevo;
        }
    }
    char pop(){
        if (inicio!= null){
        NodoStack aux = inicio;
        inicio = inicio.siguiente;
        aux.siguiente = null;
        return aux.dato;
        }else{
        return 0;}
    }
    
    Boolean ispilavacia(){
        return inicio==null;
    }
    
    void imprimir(){
        NodoStack aux=inicio;
        while (aux!=null){
            System.out.println(aux.dato);
            aux=aux.siguiente;
        }
    }

}
