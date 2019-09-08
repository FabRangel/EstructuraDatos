package encriptador;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ArchivoBinario {
  
   static Lista nose(String origen, String destino){
       Lista archivoBytes = new Lista();
        String rutaFichOrigen=origen;//Ruta al fichero de origen
        String rutaFichDestino=destino; //Ruta al fichero de destino
        File ficheroOrigen=new File(rutaFichOrigen);//Creamos objeto de tipo fichero con la ruta origen.
        File ficheroDestino=new File(rutaFichDestino);//Creamos objeto de tipo fichero con la ruta destino.
        BufferedInputStream lectorFichero;//Creo un objeto flujo buffer de lectura .
        BufferedOutputStream escritorFichero;//Creo un objeto flujo buffer de escritura.
        try{
            lectorFichero=new BufferedInputStream(new FileInputStream(ficheroOrigen));//Inicializa el buffer de lectura con un objeto de tipo FileInputStream(Flujo de entrada a fichero).
            escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino));//Inicializa el buffer de escritura con un objeto de tipo FileOutputStream( flujo de salida a fichero).
            int bytes;//variable que irá conteniendo el byte a copiar en cada momento.
            while((bytes=lectorFichero.read())!=-1){ //mientras no llegue a fin de fichero...
                archivoBytes.insertarFinal(bytes);
              //  archivoBytes.insertarFinal(bytes);
             //   System.out.print(bytes);//se imprime el byte a copiar convertido a caracter por consola(no tiene sentido) 
                escritorFichero.write(bytes);//se copia el flujo de bytes al fichero destino.
            }
            
            lectorFichero.close();//cerramos el lector
            escritorFichero.close();//cerramos el escritor
            archivoBytes.recorrer();
            
            
        }
        catch(FileNotFoundException e){
            e.printStackTrace();//traza de excepcion 
            
        }
        catch(IOException e){
            e.printStackTrace();//traza de excepcion 
        }return archivoBytes;
    }
}