/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegan;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner (System.in);
        int num1 = leer.nextInt();
        int num2 = leer.nextInt();
        System.out.println(mcd(num1,num2));
    }
    public static int mcd(int num1, int num2){
        if(num2==0){
            return num1;
        }else{
            return mcd(num2,(num1%num2));
        }
    }
}
