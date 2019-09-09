
import java.util.Scanner;
import java.util.StringTokenizer;

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

    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Lista Lista= new Lista();
        int x=1, opcion;
        String pal, aux;
        int leng=leer.nextInt();
        pal=leer.nextLine();
       StringTokenizer pedazos= new StringTokenizer(pal);
        while(pedazos.hasMoreTokens()){
               aux=pedazos.nextToken();
               aux=aux.toLowerCase();
               Lista.insertarFinal(aux);
               leng--;
        }
       Lista.Anagrama();
       System.out.println();
      
    }
}

