/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycle.detection;

import java.util.ArrayList;

/**
 *
 * @author fabi
 */
class  SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
     }
  
public class cycledetetion {
    static boolean hasCycle(SinglyLinkedListNode Head){
        
    }
    
    
    public static void main (String[] args ){
        ArrayList arreglo = new ArrayList<Integer>();
        arreglo.add (1);
        arreglo.add (2);
        arreglo.add (3);
        arreglo.add (4);
        
        boolean resultado = arreglo.contains(1);
        System.out.println(resultado);
    }
    
    static void insertar(SinglyLinkedListNode inicio, int dato){
        SinglyLinkedListNode nuevo = new SinglyLinkedListNode();
        nuevo.data = dato;
        nuevo.next = null;
        if(inicio!= null){
            nuevo.next = inicio;
        }
        inicio = nuevo;
    }
    
    static void recorrer (SinglyLinkedListNode inicio){
        ArrayList arreglo = new ArrayList<SinglyLinkedListNode>()
        
        SinglyLinkedListNode aux=inicio;
        while (aux!= null){
            System.out.println(aux);
            aux = aux.next;
            arreglo.add(aux);
        }
        boolean re
    }

}
