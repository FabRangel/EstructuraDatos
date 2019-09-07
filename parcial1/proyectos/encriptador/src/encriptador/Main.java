/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int op = 0;
        System.out.print("^***Encriptación***^\n");
        System.out.print("Ingrese la ruta origen\n->");
                Scanner leer = new Scanner(System.in);
                String archivoOrigen= leer.nextLine();
                System.out.print("Ingrese la ruta destino:\n->");
                String archivoDestino= leer.nextLine();
                System.out.print("Ingrese la contraseña:\n->");
                    String contraseña = leer.nextLine();
                    ListaCir key = new ListaCir();
                    for(int i =0;i< (contraseña.length());i++){
                    int c = contraseña.charAt(i);
                    // System.out.println(c);
                    key.insertar(c);
                    }
        
                Lista archivoBytes = new Lista();
                String rutaFichOrigen=archivoOrigen;//Ruta al fichero de origen
                String rutaFichDestino=archivoDestino; //Ruta al fichero de destino
                File ficheroOrigen=new File(rutaFichOrigen);//Creamos objeto de tipo fichero con la ruta origen.
                File ficheroDestino=new File(rutaFichDestino);//Creamos objeto de tipo fichero con la ruta destino.
                BufferedInputStream lectorFichero;//Creo un objeto flujo buffer de lectura .
                BufferedOutputStream escritorFichero;//Creo un objeto flujo buffer de escritura.
                System.out.print("\n1.Encriptar\n2.Desencriptar\n->");
                op = leer.nextInt();
        switch(op){
            case 1:
                try{
                    lectorFichero=new BufferedInputStream(new FileInputStream(ficheroOrigen));//Inicializa el buffer de lectura con un objeto de tipo FileInputStream(Flujo de entrada a fichero).
                    // escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino));//Inicializa el buffer de escritura con un objeto de tipo FileOutputStream( flujo de salida a fichero).
                    int bytes;//variable que irá conteniendo el byte a copiar en cada momento.
                    while((bytes=lectorFichero.read())!=-1){ //mientras no llegue a fin de fichero...
                        archivoBytes.insertarFinal(bytes);
                    
                    }

                    lectorFichero.close();//cerramos el lector
                    // escritorFichero.close();//cerramos el escritor
                    //archivoBytes.recorrer();
                    Lista resultado1 = archivoBytes.encriptar(key);
                    NodoLS aux = resultado1.inicio;
                    escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino));
                    while(aux != null){
                    escritorFichero.write(aux.dato);
                    //System.out.println(aux.dato);
                    aux = aux.siguiente;
                    }
                    escritorFichero.close();
                }
                catch(FileNotFoundException e){
                    e.printStackTrace();//traza de excepcion 
                }
                catch(IOException e){
                e.printStackTrace();//traza de excepcion 
                }
                break;
            case 2:
                try{
                    lectorFichero=new BufferedInputStream(new FileInputStream(ficheroOrigen));//Inicializa el buffer de lectura con un objeto de tipo FileInputStream(Flujo de entrada a fichero).
                    // escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino));//Inicializa el buffer de escritura con un objeto de tipo FileOutputStream( flujo de salida a fichero).
                    int bytes;//variable que irá conteniendo el byte a copiar en cada momento.
                    while((bytes=lectorFichero.read())!=-1){ //mientras no llegue a fin de fichero...
                        archivoBytes.insertarFinal(bytes);

                    }

                    lectorFichero.close();//cerramos el lector
                    
                    Lista resultado2 = archivoBytes.desencriptar(key);
                    NodoLS aux = resultado2.inicio;
                    escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino));
                    while(aux != null){
                    escritorFichero.write(aux.dato);
                    //System.out.println(aux.dato);
                    aux = aux.siguiente;
                    }
                    escritorFichero.close();
                }
                catch(FileNotFoundException e){
                    e.printStackTrace();//traza de excepcion 
                }
                catch(IOException e){
                e.printStackTrace();//traza de excepcion 
                }
                break;
            default:
                System.out.println("Opción incorrecta");
                
             }

    }
}
