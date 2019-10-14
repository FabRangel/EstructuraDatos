/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class Buscaminas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int nivel=0,total=0;
        int bombas = 0;
        int fila =0;int columna = 0;
        System.out.println("**** Buscaminas ****\n~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1) Facil\n2) Medio\n3) Dificil\n4) Personalizado");
        do{
        System.out.print(">>");
        nivel = leer.nextInt();
        }while(nivel<1 || nivel > 4);
        
        switch(nivel){
            case 1:
                fila = 10;
                columna = 10;
                bombas = 10;
                total = 90;
                break;
            case 2:
                fila = 20;
                columna = 20;
                bombas = 40;
                total = 360;
                break;
            case 3:
                fila = 30;
                columna = 30;
                bombas = 99;
                total = 801;
                break;
            case 4:
                System.out.print("Ingrese el número de filas\n>>");
                fila = leer.nextInt();
                System.out.print("Ingrese el número de columnas\n>>");
                columna = leer.nextInt();
                System.out.print("Ingrese el número de bombas\n>>");
                bombas = leer.nextInt();
                total = (fila*columna)-bombas;
                break;            
        }
        System.out.print("\033[H\033[2J");//pa borrar
        System.out.flush();//pa borrar
        Celda [][] matriz = new Celda [fila][columna];
        //le ponemos formato celda a cada celdita de la matriz
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
                matriz[i][j]= new Celda();
            }
        }
        //imprimiendo la matriz 
        for(int i=0;i<fila;i++){
            System.out.print("*");
            for(int j=0;j<columna;j++){
                //System.out.print("[-]");
                System.out.print("["+matriz[i][j].abierto+"]");
            }
            System.out.println("*");
        }
        //rellenando con bombas
        int bf=0;int bc=0;
        char dibujoBomba = 216;
        for(int l=0;l<bombas;l++){
            bf = (int) (Math.random() * fila) ;
            bc = (int) (Math.random() * columna) ;
            matriz[bf][bc].dato=dibujoBomba;
        }
        
        int i,j;
        //imprimiendo matriz abierta
     /*   System.out.println("****************************************");
        for(int x=0;x<fila;x++){
            System.out.print("*");
            for(int y=0;y<columna;y++){
                //System.out.print("[-]");
                System.out.print("["+matriz[x][y].dato+"]");
            }
            System.out.println("*");
        }*/
        do{
        do{
        System.out.print("\n\n\n\nIngrese la coordenada (x)\n>>");
        i = leer.nextInt(); 
        System.out.print("Ingrese la coordenada (y)\n>>");
        j=leer.nextInt();
        }while(matriz[i][j].visitado == true ); 
        //matriz[i][j].visitado = true;
        //matriz[i][j].abierto = matriz[i][j].dato;
        if(matriz[i][j].dato==dibujoBomba){
            matriz[i][j].visitado=true;
            matrizAbierta(matriz,fila,columna);
            System.out.println("GAME OVER! :'(");
            System.exit(0);
        }else{
        abrirCeldas(matriz,i,j);
        matrizAbierta(matriz,fila,columna);
        }
        }while(contar(matriz,fila,columna)!=total);
        if(contar(matriz,fila,columna)==total){
            System.out.println("YOU WIN!! :D");
            System.exit(0);
        }
    }
    
    public static void abrirCeldas(Celda [][] matriz,int i, int j){
	int k,l;
        if((i>=0)&&(i<10)&&(j>=0)&&(j<10)&&(matriz[i][j].dato == 216)){
            matriz[i][j].abierto = matriz[i][j].dato;
        }
        else{
        if(((i>=0)&&(i<10))&&((j>=0)&&(j<10))){
            if(matriz[i][j].visitado==false){
			matriz[i][j].visitado = true;
			matriz[i][j].abierto = matriz[i][j].dato;
			if(matriz[i][j].dato==' '){
				for(k=(i-1);k<=(i+1);k++){
					for(l=(j-1);l<=(j+1);l++){
						abrirCeldas(matriz,k,l);
					}
				}
			}
		}
            }
        }
    }
    
    
    
    public static void matrizAbierta(Celda[][] matriz,int fila,int columna){
        //imprimiendo matriz abierta
        System.out.println("****************************************");
        for(int i=0;i<fila;i++){
            System.out.print("*");
            for(int j=0;j<columna;j++){
                if(matriz[i][j].visitado == true){
                System.out.print("["+matriz[i][j].dato+"]");
                }else{
                    System.out.print("[-]");
                }
            }
            System.out.println("*");
        }
    }
    
    public static int contar(Celda[][]matriz,int fila,int columna){
	int i,j,cont=0;
	for(i=0;i<fila;i++){
		for(j=0;j<columna;j++){
			if(matriz[i][j].abierto==matriz[i][j].dato){
				cont++;
			}
		}
	}
	return cont;
}


    
   
}

