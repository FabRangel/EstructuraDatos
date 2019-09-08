import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Archivo {
     void muestraContenido(String archivo) throws FileNotFoundException, IOException {
       
        String cadena; //String para la cadena que es la linea de mi texto
        //Para leer el archivo
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        
        
        //Contadores
        int a=0; // lineas
        int p=0; // numeros
           
            //Para obtener los primeros dos numeros
            System.out.println("Primera cadena: "+cadena);//***
            
            String[] parts = cadena.split(" ");
            
            String part1 = parts[0].trim(); // 123
            part1 = part1.substring(1,2); 
            String part2 = parts[1];
            System.out.println(part1.length()+ part1 + part2);
          //  System.out.println(parts[0]);//***
          //  System.out.println(parts[1]);//***
            int num1 = Integer.parseInt(part1); 
            System.out.println("primer numero:"+num1);//***
            int num2 = Integer.parseInt(parts[1]); 
            System.out.println("segundo numero:"+num2);//**
            int tnum= num1+num2;
            System.out.println("El total de lineas a leer "+tnum); //***
            String arreglo[]= new String[tnum];
            int[] numero=new int[(tnum*2)+2]; 
         
                
        while((cadena = b.readLine())!=null) {          
            System.out.println("La cadena :"+cadena);//**
            arreglo[a]=cadena; //El arreglo[a] igual a la linea que esta recorriendo
            //Obtener los numeros 
            parts = arreglo[a].split(" ");
            part1 = parts[0]; 
            part2 = parts[1];
            System.out.println(parts[0]);//**
            System.out.println(parts[1]);//***
            p++;
            numero[p]=Integer.parseInt(parts[0]);
                    
            p++;
            numero[p]=Integer.parseInt(parts[1]);
            a++;
        } b.close();
     }
}