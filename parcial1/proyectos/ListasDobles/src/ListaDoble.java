/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
public class ListaDoble {
    Nodo inicio = null;
    Nodo fin = null;

    void insertarInicio(int d){
        Nodo nuevo = new Nodo();
        nuevo.dato = d;
        nuevo.siguiente = null;
        nuevo.anterior = null;
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else {
            inicio.anterior = nuevo;
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }    
    }
    
    void insertarFinal(int d){
        Nodo nuevo = new Nodo();
        nuevo.dato = d;
        nuevo.siguiente = null;
        nuevo.anterior = null;
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;
        }
    }
    
    void recorrer(){
        Nodo aux = inicio;
        while (aux != null){
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
    
    void insertarOrdenado(int d){
        Nodo nuevo = new Nodo();
        nuevo.dato = d;
        nuevo.siguiente = null;
        nuevo.anterior = null;
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else{
            Nodo aux = inicio;
            while((aux != null)&&(aux.dato < d)){
                aux = aux.siguiente;
            }
            if(aux == null){
                nuevo.anterior = fin;
                fin.siguiente = nuevo;
                fin = nuevo;
            }else if(aux.anterior == null){
                nuevo.siguiente = inicio;
                inicio.anterior = nuevo;
                inicio = nuevo;
            }else {
                Nodo ant = aux.anterior;
                ant.siguiente = nuevo;
                nuevo.anterior = ant;
                nuevo.siguiente = aux;
                aux.anterior = nuevo;
            }
        }
    }
    
    void isOrdenado(){
       if((inicio == null)&&(fin == null)){
       System.out.println("*La lista está vacia*");
       }else if(inicio == fin){
           System.out.println("*La lista sólo tiene un dato*");
       }else{
           Nodo aux = inicio;
           while((aux != null)&& (aux.dato <= aux.siguiente.dato)){
               aux = aux.siguiente;
           }
           if (aux==null){
               System.out.println("La lista ya está ordenada de menor a mayor");
           }else{
               System.out.println("La lista de menor a mayor es:");
               ordenarBurbuja();
           }
           }
    }

    void ordenarBurbuja(){
        Nodo e = inicio;
        while (e != null){
            Nodo i = e.siguiente;
            while (i != null){
                if(e.dato > i.dato){
                    int aux = e.dato;
                    e.dato = i.dato;
                    i.dato = aux;
                }
                i = i.siguiente;
            }
            e = e.siguiente;
        }
        recorrer();
    }
    
    void eliminarInicio(){
        if((inicio != fin)&&(fin != null)){
            Nodo aux = inicio;
            aux = aux.siguiente;
            aux.anterior = null;
            inicio.siguiente=null;
            inicio = aux;
        }
    }
    
    void eliminarFinal(){
        if(fin != null){
            Nodo aux = fin;
            aux = fin.anterior;
            aux.siguiente = null;
            fin.anterior = null;
            fin = aux;
        }
    }
    
    void buscarDato(int d){
        if(inicio != null){
            Nodo aux = inicio;
            while((aux != fin)&&(aux.dato != d)){
                aux = aux.siguiente;
            }
            if(aux == fin){
                System.out.println("No está");
            }else {
                System.out.println("Está");
            }
         }
    }
    
    /*void eliminarMuchos(int d){
        if((inicio == null)&&(fin == null)){
            System.out.println("La lista está vacía");
        }
        Nodo aux = inicio;
        while((aux != fin)&&(fin != null)){
            if(aux.dato == d){
            aux = aux.siguiente;
            }    
        aux = inicio;
        while((aux != fin)&&(fin != null)&&(aux.dato != d)){
            =aux;
            aux=aux.siguiente;
            }
        if((aux!=null)&&(ant!=null)){
            ant.siguiente=aux.siguiente;
            aux.siguiente=null;
            }
        }
   }*/
}



