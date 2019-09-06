
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
    
     void insertar (int d){
        Nodo nuevo = new Nodo ();
        nuevo.dato = d;
        nuevo.sig = null;
        if(inicio == null){
            inicio = nuevo;
        } else{
            Nodo aux = inicio;
            while(aux.sig != null){
                aux = aux.sig;
            }
        aux.sig = nuevo;
        }
    }
     
     Nodo eliminarInicio(){
         Nodo aux = inicio;
         if(aux != null){
             inicio = inicio.sig;
             aux.sig = null;
         }
         return aux;
     }
     
     void insertarFinal(Nodo nuevo){
         Nodo aux = inicio;
         Nodo ant = null;
         while(aux != null){
             ant = aux;
             aux = aux.sig;
         }
         if(ant == null){
             inicio = nuevo;
         }else{
             ant.sig = nuevo;
         }
     }
     void ordenarRadix(){
         Lista arreglo [] = new Lista [10];
         for(int i = 0; i<10; i++){
             arreglo [i] = new Lista();
         }
         Nodo actual = null;
         int vuelta = 0;
         while ((actual = eliminarInicio() )!= null){
             vuelta++;
             int digito = digito (actual.dato,vuelta);
             arreglo[digito].insertarFinal(actual);
         }
     }
     
     int digito(int dato, int vue){
        int d=0;
        for(int i = 0; i<vue;i++){
            d=dato%10;
            dato=dato/10;
        }
        return d;
     }
     
     void unirListas (Lista lis){
         Nodo aux = inicio;
         Nodo ant = null;
         while(aux != null){
             ant = aux;
             aux = aux.sig;
         }if (ant == null){
             inicio = lis.inicio;
         }else {
             ant.sig = aux.sig;
         }
     }
}