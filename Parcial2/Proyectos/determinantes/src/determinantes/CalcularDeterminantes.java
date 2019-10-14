/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinantes;

/**
 *
 * @author fabi
 */
public class CalcularDeterminantes {
    
    
    int [][] obtenermatriz (int [][] matriz ,int indice){
        int size = matriz.length -1;
        int contador = 0;
        int [][]matriznueva = new int [size][size];
        for (int i = 1;i <matriz.length;i++){
            for(int j = 0; i<matriz.length;i++){
                if (j != indice){
                    matriznueva[i-1][contador] = matriz[i][j];
                    contador++;
                }
            }
        }return matriznueva;
    }
   
    int determinantes (int [][] matriz){
        if((matriz.length == 1)&&(matriz[0].length == 1)){
            return matriz [0][0];
        }else{
            int contador = 0;
            for (int i = 0;i < matriz.length;i++){
                if(i%2 == 0){
                    contador = contador + matriz[0][i]* determinantes(obtenermatriz(matriz,i));
                }else{
                    contador = contador - matriz[0][i]* determinantes(obtenermatriz(matriz,i));
                }
            }return contador;
        }
    }
}
