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
public class Determinantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] matriz = {
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5}
            };
        CalcularDeterminantes calcular  = new CalcularDeterminantes();
        int determinante = calcular.determinantes(matriz);
        System.out.println(determinante);
        } 
    }
