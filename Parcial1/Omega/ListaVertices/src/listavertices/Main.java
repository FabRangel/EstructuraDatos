/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listavertices;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class Main {

    public static void main(String[] args) {
        int p=0;
        
        Scanner leer=new Scanner(System.in); 
        String nums = leer.nextLine();
        String [] parts = nums.split(" ");
        String nver = parts[0];
        String nari = parts[1];
        int Nver = Integer.parseInt(parts[0]);
        int Nari = Integer.parseInt(parts[1]);
        Lista lis=new Lista();
        while(leer.hasNext()){
            for(int i=0;i<Nver;i++){
            String  numeros = leer.nextLine();
            int[] lver = new int [Nver]; 
            int[] lari = new int [Nari];
            String [] numero = numeros.split(" ");
            String sver = numero[0];
          //  System.out.println(sver); 
            String sari = numero[1];
         //   System.out.println(sari); 
            p++;
            lver[p]=Integer.parseInt(sver);
         //   System.out.println(lver[p]);        
            p++;
            lari[p]=Integer.parseInt(sari);
         //   System.out.println(lari[p]);
            lis.ady(lver[p],lari[p],Nver);
            
        }
        }
        
         }
        
    }

    

