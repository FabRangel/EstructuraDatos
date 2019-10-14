/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegaq1;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaQ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n,i;
        long  d;
        Scanner leer= new Scanner(System.in);
        n = leer.nextInt();
        long [][] array = new long[n][3];
        for(i=0;i<n;i++){
            d = leer.nextLong();
            array[i][1]= d;
            array[i][2]= (d*2)+1;
        }
        for(i=0;i<n;i++){
            if(array[i][1]==0){
                System.out.println(array[i][1]);
            }else{
                System.out.println(array[i][1]+"/"+array[i][2]);
            }
        
    }
    
}
}
   