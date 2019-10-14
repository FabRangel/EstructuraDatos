/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegam;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        System.out.println(recursiva(n));
    }
    
    public static int recursiva(int n){
        if(n<=5){
            return 1;
        }else if(n>5){
            return recursiva(n-2)*5 ;
        }else{
            return 0;
        }
    }
}
