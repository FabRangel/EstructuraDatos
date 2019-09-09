package dosestructuras;
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

public class Main{


    public static void main(String[] args) {
            int N,dato,a;
            String palabra="meter datos";
            Listadoble Pila= new Listadoble();
            Listadoble Cola= new Listadoble();
            Scanner leer = new Scanner (System.in);
            N=leer.nextInt();
            while(N!=0){
                Scanner read = new Scanner (System.in);
                  String opcion = read.nextLine(); 
    	           if(opcion == palabra){
    			if((Cola.inicio!= null) && (Pila.inicio!=null)){
                            System.out.print(Pila.inicio);
                            System.out.println(Cola.inicio);
                            }
    			N--;
		}else{
			dato = leer.nextInt();
                        Pila.insertar(dato);
    			Cola.insertar(dato);
    			N--;
		}
	}
    }
    
}
