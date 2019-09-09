
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
class Nodo{
	int dato;
	Nodo siguiente;
	Nodo anterior;
}

class Lista{
	Nodo inicio= null;
	Nodo fin = null;
        
        void insertar(int dato){
	Nodo nuevo=nuevoElemento(dato);
	if((inicio==null) && (fin==null)){
		inicio=nuevo;
		fin=nuevo;
	}else{
		fin.siguiente=nuevo;
		nuevo.anterior=fin;
		fin=nuevo;
            }
        }
        
        Nodo nuevoElemento(int dato){
	Nodo q= new Nodo();
	q.dato=dato;
	q.siguiente=null;
	q.anterior=null;
	return q;
        }
        
        int buscarMenor(){
	int dato=0;
	if((inicio!=null) && (fin!=null)){
		if(fin.dato<=inicio.dato){
			dato=fin.dato;
			Nodo aux= fin;
			fin=fin.anterior;
                        //free(aux)
		}else{
			dato=inicio.dato;
			Nodo aux=inicio;
			inicio=inicio.siguiente;
			//free(aux);
		}
	}
	return dato;
        }
}

public class main {
     public static void main(String[] args){
    Lista Lista= new Lista();
    Scanner leer = new Scanner(System.in);
	int n = 0;
        int Ni=0;
        int Total=0;
	do{
                n=leer.nextInt();
	}while (n<3 || n>1000);
	for(int i=0;i<n;i++){
		do{
                    Ni=leer.nextInt();
		}while(Ni<1 | Ni>1000);
		Lista.insertar(Ni);
	}
	for(int i=1;i<=n;i++){
		Total+=(Lista.buscarMenor()*i);
	}
	System.out.println(Total);
     }
}
