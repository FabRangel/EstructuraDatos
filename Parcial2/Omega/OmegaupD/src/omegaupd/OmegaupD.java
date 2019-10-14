/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegaupd;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaupD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int n= leer.nextInt();
        int nodo = 0;
        int nIzq = 0;
        int nDer = 0;
        for( int i = 1; i <= n; i++ ){
            nodo = leer.nextInt();
            nIzq = leer.nextInt();
            nDer = leer.nextInt();
            arbol[nodo].izq = nIzq;
            arbol[nodo].der = nDer;
        }
        busca(1,1);
        int nivel = 1;
        int maximo = 0;
        for( int i = 1; i <= n; i++ ){
            int distancia = ( niveles[i].maximo  - niveles[i].minimo );
            if( distancia > maximo ){
                maximo = distancia;
                nivel = i;
            }
        }
        System.out.println(nivel+""+maximo+1);
    }
    
    public static void busca( int nodo, int nivel ){
        Nodo[] arbol= new Nodo[10005];
        Nivel niveles= new Nivel();
        int cont = 0;
        if( arbol.nodo.izq == -1 && arbol.nodo.der == -1 ){
            comprueba(nivel,cont++ );
            arbol[nodo].posicion = cont;
        }else{
            if( arbol.nodo.izq != -1 ){
                busca(arbol.nodo.izq, nivel +1 );
        }
        comprueba(nivel, cont++ );
        arbol[nodo].posicion = cont;
    
        if( arbol.nodo.der != -1 ){
            busca(arbol.nodo.der, nivel +1 );
        }
    }
    
    }
    
    public static void comprueba( int nivel, int posicion ){
        if( niveles.nivel.minimo == 0 ){
            niveles.nivel.minimo = posicion;
        }else if( niveles.nivel.maximo < posicion ){
            niveles.nivel.maximo = posicion;
        }
    }
    
}
    





