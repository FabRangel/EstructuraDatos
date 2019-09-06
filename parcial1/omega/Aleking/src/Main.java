
import java.util.Scanner;

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
        Scanner leer=new Scanner(System.in); 
        int n = leer.nextInt();
        Lista lista = new Lista(); 
        for(int i = 0;i<n;i++){   
            int m = leer.nextInt();
            lista.insertar(m);
        }
        int op = leer.nextInt();
        if (op == 1){
            lista.imprimirUno();
        }else if(op == 2){
            lista.imprimirDos();
        }else if(op == 3){
            lista.imprimirTres();
        }
    
     }
}
