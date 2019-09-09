
import java.util.Scanner;


class Nodo{
	int dato;
	String nombre;
	Nodo siguiente;
}

class Lista{
	Nodo inicio=null;
	Nodo fin=null;
        Scanner leer = new Scanner (System.in);
        
        void insertNodo(){
	int suma=1,i,num;
	for(i=0;i<3;i++){
                num = leer.nextInt();
		suma*=num;
	}
	Nodo nuevo=nuevoElemento(suma);
	if(inicio==null){
		inicio=nuevo;
	}else{
		nuevo.siguiente=inicio;
		inicio=nuevo;
            }
        }
        
        Nodo nuevoElemento(int dato){
	String nombre;
	int len;
	Nodo q= new Nodo();
	q.dato=dato;
	q.siguiente=null;
        do{
        q.nombre = leer.nextLine();	
        }while(q.nombre.length()>8);
        return q;
        }
        
        String buscarMayor(){
	Nodo max= new Nodo();
	if(inicio!=null){
		Nodo aux=inicio;
		max=inicio;
			while(aux!=null){
				if(aux.dato>max.dato){
					max=aux;
				}
				aux=aux.siguiente;
			}
	}
	return max.nombre;
        }
        
        String buscarMenor(){
	Nodo min= new Nodo();
	if(inicio!=null){
		Nodo aux=inicio;
		min=inicio;
			while(aux!=null){
				if(aux.dato<min.dato){
					min=aux;
				}
				aux=aux.siguiente;
			}
	}
	return min.nombre;
        }
}



public class Main {
     public static void main (String [] args){
        Scanner leer=new Scanner(System.in); 
        Lista Group1= new Lista();
        Lista Group2= new Lista();
	int n,i,j;
	do{
            n = leer.nextInt();
	}while(n<2 || n>9);
	for(i=0;i<n;i++){
		Group1.insertNodo();
	}
	do{
            n = leer.nextInt();
	}while(n<2 || n>9);
	for(i=0;i<n;i++){
		Group2.insertNodo();
	}
	String nombreMayor1 = Group1.buscarMayor();
        String nombreMenor1 = Group1.buscarMenor();
        String nombreMayor2 = Group2.buscarMayor();
        String nombreMenor2 = Group2.buscarMenor();
        System.out.println(nombreMayor1+" took clay from "+nombreMenor1);
        System.out.println(nombreMayor2+" took clay from "+nombreMenor2);
	
     }
}



