/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
public class Main {
    public static void main (String [] args){
        Lista l1 = new Lista();        
        System.out.println("Lista:");
        l1.insertar(870);
        l1.insertar(118);
        l1.insertar(555);
        l1.insertar(300);
        l1.insertar(19);
        l1.insertar(102);
        l1.insertar(25);
       // unirListas(l1,l2);
        //l1.recorrer();
        l1.ordenarRadix();
        //l1.recorrer();
        

    }
}