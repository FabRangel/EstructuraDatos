/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torreshanoi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class TorresHanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner leer = new Scanner(System.in);
      
        char t1='A',t2='B',t3='C';
        int discos;
        System.out.println("Numero de discos:");
        discos = leer.nextInt(); 
        hanoi(discos,t1,t2,t3);
    }
    
    public static void hanoi (int discos,char TorreInicio, char TorreAuxiliar, char TorreDestino ) throws IOException{
        //caso base
        File f; 
        f = new File("/home/fabi/proyectos/hanoi2.txt");    
        FileWriter fw = new FileWriter(f.getAbsoluteFile(),true);//para que no se sobreescriba
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter escritura = new PrintWriter(fw);
        if(discos == 1){
            System.out.println(discos+" "+TorreInicio+" "+TorreDestino);
            escritura.println(discos+" "+TorreInicio+" "+TorreDestino);
        }else{
            hanoi(discos-1,TorreInicio,TorreDestino,TorreAuxiliar);
            System.out.println(discos+" "+TorreInicio+" "+TorreDestino);
            escritura.println(discos+" "+TorreInicio+" "+TorreDestino);
            hanoi(discos-1,TorreAuxiliar,TorreInicio,TorreDestino);
        }
          escritura.close();
    }
    
          
    
}
