/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios.polinomios2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author fabi
 */
public class Main {
    public static void main (String [] args) throws FileNotFoundException, IOException{
    
     Archivo arch=new Archivo();
       arch.muestraContenido("/home/fabi/proyectos/polinomios.txt");
     }
        
    }

