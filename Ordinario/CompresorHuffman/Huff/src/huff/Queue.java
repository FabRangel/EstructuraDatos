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
public class Queue {
    int inicio= -1;
    int fin = -1;
    int cola[];
    
    boolean isVacia (){
        if((inicio == -1)&&(fin == -1)){
            return true;
        }else{
            return false;
        }
    }
    
    boolean llena(){

        if(((fin+1)%cola.length) == inicio){
            return true;
        }else{
            return false;
        }
    }
    
    void enQueue(int dato){
        if(llena()){
            System.out.println("La cola está llena");
        }else{
            if(isVacia()){
                inicio = 0;
                fin = 0;
            }else{
                fin = (fin+1)%cola.length;
            }
            cola[fin] = dato;
        }
    }
    
    int deQueue(){
        int numero = 0;
        if(isVacia()){
            System.out.println("La cola está vacía");
        }else{
            numero = cola[inicio];
            if (inicio == fin){
                fin = inicio = -1;
            }else{
                inicio = (inicio+1)%cola.length;
            }
        }
        return numero;
    }
    
}
