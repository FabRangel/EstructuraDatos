/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegab;

import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner (System.in);
        int N,X,Y,C,i,dias=0;
	do{
		N=leer.nextInt();
	}while(N<1 || N>pow(10,9));
        int [][] ciudad = new int[N][];
	do{
            X = leer.nextInt();
            Y = leer.nextInt();
	}while(X<1 || X>N || Y<1 || Y>N);
	do{
		C = leer.nextInt();
	}while(C<1 || C>(N*N));
	inicializar(ciudad,N,X-1,Y-1);
	System.out.println(diasInfeccion(ciudad,N,C,dias));
    }
    
    public static int diasInfeccion(int [][]ciudad,int N,int C,int dias){    
	int cont=0,i,j;
	for(i=0;i<N;i++){
		for(j=0;j<N;j++){
			if(ciudad[i][j]==1){
				cont++;
			}
		}
	}
	if(cont>=C){
		return dias;
	}else{
		infectar(ciudad,N);
		for(i=0;i<N;i++){
			for(j=0;j<N;j++){
				if(ciudad[i][j]==5){
					ciudad[i][j]=1;
				}
			}
		}
		return diasInfeccion(ciudad,N,C,dias+1);
	}
	
    }
    
    public static void infectar(int [][]ciudad,int N){
	int i,j,k,l;
	for(i=0;i<N;i++){
		for(j=0;j<N;j++){
			if(ciudad[i][j]==1){
				for(k=(i-1);k<=(i+1);k++){
					for(l=(j-1);l<=(j+1);l++){
						if((k<N) && (l<N) && (k>=0) && (l>=0) && (k==i || l==j)){
							if(ciudad[k][l]!=1){
								ciudad[k][l]=5;
							}
						}
					}
				}
			}
		}
	}
    }
    
    public static void inicializar(int [][]ciudad,int N,int X, int Y){
	int i,j;
	for(i=0;i<N;i++){
		for(j=0;j<N;j++){
			ciudad[i][j]=0;
		}
	}
	ciudad[X][Y]=1;
    }
    
}







