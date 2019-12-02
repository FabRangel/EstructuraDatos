    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huff;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class Huff {

    /**
     * @param args the command line arguments
     */
     int longitud;
     String texto ="";
     int [] frecuenciaSimbolos = new int[128];
     Lista listaPesos = new Lista();
     Queue colaCaracteres;
     NodoLista raiz; 
     ListaCodigo listaCodigo = new ListaCodigo(); 
     NodoCodigo raizCodigo;
     String codigo; 
     Archivo archivoHuff = new Archivo();
     int contadorNodos = 0; 
     int contadorProfundidad;
     boolean caracterValido;
     
     
         
    void frecuencia(String txt){
        char aux;
        int numAscii;
        longitud = txt.length();
        for(int i=0;i<longitud;i++){
            aux = txt.charAt(i);
            numAscii=(int)aux;
            frecuenciaSimbolos[numAscii] = frecuenciaSimbolos [(int)aux]+1;
            if((numAscii == 32)||(numAscii >= 97 && numAscii <=122)||(numAscii >=48 && numAscii <= 57)||(numAscii==44)||(numAscii == 46 )){
                caracterValido = true;
            }else{
                caracterValido = false;
            }
        }
        texto=txt;
    }
    
    int simbolosLeidos(){
        int contador=0;

        for(int i=0; i<frecuenciaSimbolos.length;i++){
            if(frecuenciaSimbolos[i]>0){
                contador++;
            }
        }
        return contador;
    }
    
    void ordenar(){
        colaCaracteres = new Queue();
        colaCaracteres.cola=new int[simbolosLeidos()];

        for(int i=0; i<frecuenciaSimbolos.length;i++){
 
            if(frecuenciaSimbolos[i]>0){
                Simbolo simbolo = new Simbolo();

                simbolo.caracter = ((char)i);

                simbolo.frecuencia = frecuenciaSimbolos[i];

                listaPesos.insertar(simbolo, null, null);

                colaCaracteres.enQueue((char)i);
                contadorNodos++;

            }
        }

    }
    
    void dequeueColaCaracteres(){
        int ascii;
        while(colaCaracteres.isVacia() != true){
            ascii = colaCaracteres.deQueue();
            recorrido(ascii);
        }
    }
    
    void nodosArbol(){
        NodoLista derecha,izquierda;
        int sumaFrecuencia;
        Simbolo nuevosimbolo;
        raiz = listaPesos.raiz;
        
        while(listaPesos.raiz.siguiente != null){
            izquierda = listaPesos.raiz;
            izquierda.arista = 1;
            listaPesos.raiz = izquierda.siguiente;
            derecha = listaPesos.raiz;
            derecha.arista = 0;
            
            sumaFrecuencia = derecha.simbolo.frecuencia + izquierda.simbolo.frecuencia;
            nuevosimbolo = new Simbolo();
            nuevosimbolo.caracter='*';
            nuevosimbolo.frecuencia = sumaFrecuencia;
            
            listaPesos.insertar(nuevosimbolo, izquierda, derecha);
            listaPesos.raiz = listaPesos.raiz.siguiente;
            contadorNodos++;
        }
    }
    
    void recorrido(int ascii){
        int caracter,auxProf;
        String codigoInv="";
        listaPesos.raiz=raiz;
        contadorProfundidad=0;
        
        while(listaPesos.raiz != null){
            caracter = listaPesos.raiz.simbolo.caracter;
            auxProf = contadorProfundidad;
            
            if(ascii == caracter){
                while(listaPesos.raiz.padre != null){
                    codigoInv = codigoInv + listaPesos.raiz.arista;
                    listaPesos.raiz = listaPesos.raiz.padre;
                    contadorProfundidad++;
                }
                StringBuilder sb = new StringBuilder(codigoInv);
                codigo = sb.reverse().toString();
                codificacion(caracter,codigo);
                
                if(contadorProfundidad < auxProf){
                    contadorProfundidad = auxProf;
                }
            }
            listaPesos.raiz = listaPesos.raiz.siguiente;
        }
    }
    
    void codificacion(int caracter,String codigo){
        NodoCodigo nodocodigo = new NodoCodigo();
        nodocodigo.caracter = caracter;
        nodocodigo.codigo = codigo;
        raizCodigo = nodocodigo;
        listaCodigo.insertar(nodocodigo);
    }
    

    
    void imprimirArchivo(){
        try{
            archivoHuff.crearArchivo(texto, listaCodigo);
            archivoHuff.ascii();
            archivoHuff.decod();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    String cargarArchivo(String ruta){
        Archivo archivo = new Archivo();		
	return archivo.leerArchivo(ruta);
	}
        
}
