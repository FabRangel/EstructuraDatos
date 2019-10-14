/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegaq;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner (System.in);
        int q,n;
        int i=0;
        q = leer.nextInt();
        do{
            n = leer.nextInt();
            recursiva(n);
            System.out.println(recursiva(n));
            i++;
        }while(i<q);
        
    }
    
    public static int recursiva(int n){
        if(n==0){
            return 0;
        }else{
            return ((1)/((1+(2*(n-1)))*((2*n)+1))) + recursiva(n-1);
        }
    }
    
}
