/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegaj;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int cont;
	String P,T;
        
        P = leer.nextLine();
        T= leer.nextLine();
	System.out.println(comparar(P,T,0));
    }
    
public static int comparar(String P,String T,int dato){
	int i,len,cont=0,record=dato;
	len= P.length();
	for(i=0;i<len;i++){
		if(P[i]==T.indexOf(T)[dato]){
		  	cont++;
		}
		dato++;
	}
	if(dato==T.length()){
		return cont;
	}else{
		return cont+comparar(P,T,record+1);
	}
}
}



