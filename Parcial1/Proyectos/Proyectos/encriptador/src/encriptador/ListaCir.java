/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

/**
 *
 * @author fabi
 */
public class ListaCir {
    NodoCir inicio = null;
    
    void insertar(int dato){
        NodoCir nuevo = new NodoCir();
        nuevo.dato = dato;
        nuevo.siguiente = nuevo;
        if(inicio == null){
            inicio = nuevo;
        }else{
            NodoCir aux = inicio.siguiente;
            NodoCir ant =inicio;
            while(aux!=inicio){
                ant = aux;
                aux = aux.siguiente;
            }
            ant.siguiente = nuevo;
            nuevo.siguiente = aux;
        }
    }
    
    void recorrer ()
    {
        if (inicio != null) {
            NodoCir aux=inicio;
            do {
                System.out.print (aux.dato + "->");
                aux = aux.siguiente;                
            } while (aux!=inicio);
            System.out.println();
        }    
    }
    
    void keyEnAscci(){
        if(inicio != null){
        NodoCir aux = inicio;
        ListaCir keyEnAs = new ListaCir();
        do{
        int keyAs = aux.dato;
        keyEnAs.insertar(aux.dato);
        System.out.print(keyAs+"->");
        aux =aux.siguiente;
        }while(aux!=inicio);
        
        }
    }
        
}
