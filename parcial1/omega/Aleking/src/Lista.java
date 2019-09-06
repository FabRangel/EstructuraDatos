/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
public class Lista {
    Nodo inicio = null;
    Nodo fin = null;
    
    void insertar(int d){
        Nodo nuevo = new Nodo();
        nuevo.dato = d;
        nuevo.sig = null;
        nuevo.ant = null;
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else {
            inicio.ant = nuevo;
            nuevo.sig = inicio;
            inicio = nuevo;
        }  
    }
    
    void recorrer(){
        Nodo aux = inicio;
        while (aux != null){
            System.out.println(aux.dato);
            aux = aux.sig;
        }
    }
    
    void imprimirUno(){
        Nodo aux = inicio;
        while(aux!=null){
        System.out.println(aux.dato);
            aux = aux.sig;
        }
    }
    
    void imprimirDos(){
        Nodo aux = fin;
        while (aux != null){    
        System.out.println(aux.dato);
            aux = aux.ant;
        }
    }
    
    void imprimirTres(){
        Nodo e = inicio;
        Nodo aux1 = inicio;
        while (e != null){
            Nodo i = e.sig;
            while (i != null){
                if(e.dato < i.dato){
                    int aux = e.dato;
                    e.dato = i.dato;
                    i.dato = aux;
                }
                i = i.sig;
            }
            e = e.sig;
        }
        while(aux1 != null){
            System.out.println(aux1.dato);
            aux1= aux1.sig;
        }
    }
    
}
