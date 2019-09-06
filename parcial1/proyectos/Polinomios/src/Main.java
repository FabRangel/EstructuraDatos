/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main (String [] args) throws FileNotFoundException, IOException{
        
        int monopoli1=0,monopoli2=0;
        
        
        try(FileReader fr = new FileReader ("/home/fabi/proyectos/polinomios.txt")){
            int caracterLeido = fr.read();
           // for(int i=0;i<=1;i++){
            while (caracterLeido != '\n'){
                char caracter = (char) caracterLeido;
             //   if(i==0){
               //     monopoli1=caracter;
               // }
                
               //System.out.println(caracter);
                
               caracterLeido = fr.read();
            }
        }catch (IOException ex){
            System.err.println("Error");
            ex.printStackTrace();
            }

        }
        
    }

