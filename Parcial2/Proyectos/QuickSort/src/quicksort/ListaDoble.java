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
public class ListaDoble {
    Nodo inicio = null;
    Nodo fin = null;

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
    
    Nodo nuevaLista (Nodo inicio,Nodo fin ){
        if((inicio == fin)||(inicio == null)||(fin==null)){
            return inicio;
        }
                
        Nodo piv = inicio;
        Nodo piva = inicio;
        int pivoteDato = fin.dato;
        
        while(inicio != fin){
            if(inicio.dato < pivoteDato){
                piva = piv;
                int aux = piv.dato;
                piv.dato = inicio.dato;
                inicio.dato= aux;
                piv = piv.siguiente;
            }
            inicio = inicio.siguiente;
        }
        
        int aux = piv.dato;
        piv.dato = pivoteDato;
        fin.dato = aux;
        return piva;
    }
    
    void QS(Nodo inicio, Nodo fin){
        if(inicio == fin){
            return;
        }
        Nodo piva = nuevaLista(inicio,fin);
        QS(inicio, piva);
        
        if(piva != null && piva == inicio){
            QS(piva.siguiente, fin);
        } else if(piva != null && piva.siguiente != null){
            QS(piva.siguiente.siguiente,fin);
        }
    }
}
