/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author fabi
 */
public class Archivo {
    
    String leerArchivo (String ruta){
        File archivoFuente = new File(ruta);
        String cadena ="";
		try
		{
                    FileReader file = new FileReader(archivoFuente);
                    BufferedReader buffer = new BufferedReader(file);

                    String aux;
		
                    while((aux = buffer.readLine())!=null)
		    cadena = cadena + aux;	
                    cadena = cadena.toLowerCase();
		}
		catch(FileNotFoundException e)
		{
			 e.printStackTrace();
		}
		catch (Exception e) 
		{				
			 e.printStackTrace();
		}
		return cadena;		
    }
    
    void crearArchivo (String texto, ListaCodigo codigo) throws IOException{
        String ruta = "/home/fabi/proyectos/ordinarioHuff.txt";
        File archivo = new File (ruta);
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        NodoCodigo nodito = codigo.obtenerRaiz();
        
        char aux;
        
        for(int i = 0;i<texto.length();i++){
            aux = texto.charAt(i);
            while(nodito != null){
                if(aux == nodito.caracter){
                    bw.write(nodito.codigo);
                    nodito = codigo.raiz;
                    break;
                }
                nodito = nodito.siguiente; 
            }
        }
        bw.close();
    }
    
    void ascii () throws IOException{
        String ruta = "/home/fabi/proyectos/ordinarioAscii.txt";
      //  String ruta = "/home/fabi/proyectos/ordinario.txt";
        String texto = leerArchivo("/home/fabi/proyectos/ordinarioHuff.txt");
      //  String texto = leerArchivo("/home/fabi/proyectos/ordinarioAscii.txt");
        File archivo = new File (ruta);
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        int bits = 0; 
        String numBytes="";
        int decimal; 
        
        for(int i=0; i<texto.length();i++){
            numBytes = numBytes + texto.charAt(i);
            bits ++;
            
            if(bits == 7){
                decimal = binAdec(numBytes);
                bw.write((char)decimal);
                bits = 0;
                numBytes = "";
            }
            if((i== texto.length()-1)&&(bits < 7)){
                decimal = binAdec(numBytes);    
                bw.write((char)decimal);
            }
        }
        bw.close();
    }
    
     void decod () throws IOException{
        String ruta = "/home/fabi/proyectos/ordinario.txt";
      //  String ruta = "/home/fabi/proyectos/ordinario.txt";
        String texto = leerArchivo("/home/fabi/proyectos/ordinarioHuff.txt");
      //  String texto = leerArchivo("/home/fabi/proyectos/ordinarioAscii.txt");
        File archivo = new File (ruta);
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        int bits = 0; 
        String numBytes="";
        int decimal; 
        
        for(int i=0; i<texto.length();i++){
            numBytes = numBytes + texto.charAt(i);
            bits ++;
            
            if(bits == 7){
                decimal = binAdec(numBytes);
                bw.write((char)decimal);
                bits = 0;
                numBytes = "";
            }
            if((i== texto.length()-1)&&(bits < 7)){
                decimal = binAdec(numBytes);    
                bw.write((char)decimal);
            }
        }
        bw.close();
    }


   int binAdec(String numBinario){
       int longitud = numBinario.length();
       int res = 0;
       int potencia = longitud -1;
       for(int i = 0; i < longitud; i++){
           if(numBinario.charAt(i)=='1'){
               res = (int) (res + Math.pow(2,potencia));
           }
           potencia--;
       }
       return res;
   }
}
