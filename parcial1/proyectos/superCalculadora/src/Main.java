
import static java.lang.Character.getNumericValue;
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
    public static void main (String [] args ){
        Scanner leer=new Scanner(System.in); 
        //int numero1,numero2,op,num,a;
        String numero1 = "";
        String numero2 = "";
        int op;
        lista num1 = new lista();
        lista num2 = new lista();
        lista resul = new lista();
        System.out.println("****Super Calculadora****");
        System.out.println(">>Ingrese el primer número");
        numero1 = leer.nextLine();
        char[] cadenaChars1 = new char[numero1.length()]; 
        for (int i=0; i<numero1.length(); i++) {
        cadenaChars1[i] = numero1.charAt(i); }
        for (int i=(numero1.length())-1; i>=0; i--) {
        int dato = Character.getNumericValue(cadenaChars1[i]);
        num1.insertar(dato);
        }
        System.out.println(">>Ingrese el segundo número");
        numero2 = leer.nextLine();
        char[] cadenaChars2 = new char[numero2.length()]; 
        for (int i=0; i<numero2.length(); i++) {
        cadenaChars2[i] = numero2.charAt(i); 
        }
        for (int i=(numero2.length())-1; i>=0; i--) {
        int dato = Character.getNumericValue(cadenaChars2[i]);
        num2.insertar(dato);
        }
        System.out.print("\n**1) Suma\n**2) Resta\n**3) Multiplicación\n**4) División\n>>");
        op = leer.nextInt();
        System.out.println("\n");
        switch(op){
            case 1: 
                resul.suma(num1,num2);
                break;
            case 2:
                resul.resta(num1,num2);
                break;
            case 3:
                resul.multiplicacion(num1,num2);
                break;
            case 4:
                resul.division(num1,num2);
                break;
        }
    }
}
