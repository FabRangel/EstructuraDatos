/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuntingyard;

import java.util.Stack;
import shuntingyard.stack;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class Main {
        public static void main(String[] args) {
   
       Scanner scanner = new Scanner(System.in);
       
       String expresion = scanner.next();
       
       System.out.println(expresion);
       
       ShuntingYard sy = new ShuntingYard ();
       sy.evalua(expresion);
    }
    
}
