/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuntingyard;
import java.util.Scanner;
import java.util.Stack;
import shuntingyard.stack;


/**
 *
 * @author fabi
 */
public class ShuntingYard {
    
   
    queue StringtoChar(String string){
        queue cola = new queue ();
        for (int i = 0; i < string.length(); i++) {
            cola.queue(string.charAt(i));
          //  System.out.println(string.charAt(i));
        }
        return cola;
    }
    
    boolean isLetra(char caracter){
             switch (caracter){
                 case '+':
                     return false;
                 case '-':
                     return false;
                 case '*':
                     return false;
                 case '/':
                     return false;
                 case '^':
                     return false;
                 case '(':
                     return false;
                 case ')':
                    return false;
                 default:
                     return true;
             }
    }
    
    int peso(char signo){
         switch (signo){
                 case '+':
                 case '-':
                    return 1;
                 case '*':
                 case '/':
                    return 2;
                 case '^':
                    return 3;
                 case '(':
                    return 4;
                 case ')':
                    return 0;
                 default: 
                    return -1;
             }
    }
    
    boolean isAfueraMayorQueDentro(char dentro,char fuera){
        return peso(fuera)>peso(dentro);
    }
    
    void evalua(String expresion){
         queue entrada = StringtoChar(expresion);
         queue salida = new queue();
         stack pila = new stack();
         
         char caracter;
         
         while((caracter = entrada.dequeue ())!=0){
            if(isLetra(caracter)){
              //  System.out.println(caracter);
                salida.queue(caracter);   
            }else{
                if(pila.ispilavacia()){
                    pila.push(caracter);
                }else{
                    if(peso(caracter) == 0){
                        char c;
                        while((c=pila.pop())!= '('){
                           salida.queue(c);
                           }
                    }else{
                    char signo = pila.pop();
                    if(signo == '('){
                        pila.push(signo);
                        pila.push(caracter);
                    }else 
                    if(isAfueraMayorQueDentro(signo,caracter)){
                        pila.push(signo);
                        pila.push(caracter);
                    }else{
                        salida.queue(signo);
                        pila.push(caracter);
                    } 
                  }
                }
            }
         }
        //System.out.println();
        while((caracter=pila.pop())!= 0){
            salida.queue(caracter);
        }
        
        while((caracter=salida.dequeue())!=0){
            System.out.print(caracter);
        }
         System.out.println();
       }
    }
    

