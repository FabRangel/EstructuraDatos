/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listavertices;

/**
 *
 * @author fabi
 */
public class Lista {
    Nodo inicio=null;
    
     void insertar (int dato){
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.sig = null;
        if (inicio == null){
            inicio = nuevo;
        }else{
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux != null){
                ant = aux;
                aux = aux.sig;
            }
            ant.sig = nuevo;
        }
    }

     void listaAd (int nver){
         Lista array [] = new Lista [nver];
         for(int i = 0; i<nver; i++){
             array [i] = new Lista();
        }
         
     }
     
     void ady(int ver,int aris,int Nver){
        Lista array [] = new Lista [Nver];
         for(int i = 0; i<Nver; i++){
             array [i] = new Lista();
        }
         for(int i = 0; i<array.length; i++){
             array [i] = new Lista();
             if(ver == i){
                 array[i].insertar(aris);
                 array[aris].insertar(i);
                }   
             }
         for(int i=0;i<ver;i++){
             System.out.print(i+":");
             array[i].recorrer();
             System.out.print("\n");
         }
         }
   
        void recorrer (){
        Nodo aux = inicio;
        while (aux!= null) {
            System.out.print(aux.dato+"->");
            aux = aux.sig;
        }
    }

}

