/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosestructuras;

/**
 *
 * @author fabi
 */
public class Listadoble {
        Nodo inicio= null;
	Nodo fin= null;
        
        void insertar(int dato){
	Nodo nuevo=new Nodo();
	nuevo.dato=dato;
	nuevo.siguiente=null;
	if((inicio==null) && (fin==null)){
		inicio=nuevo;
		fin=nuevo;
	}else{
		nuevo.siguiente=inicio;
		inicio=nuevo;
            }
        }
        
        int pila(){
            int dato = 0;
	if((inicio!=null) && (fin!=null)){
		dato=inicio.dato;
	if(inicio.siguiente!=null){
		inicio=inicio.siguiente;
	}else{
		inicio=null;
		fin=null;
            }
          }
        return dato;
        }
        
        int cola(){
            int dato= 0;
	if((inicio!=null) && (fin!=null)){
		dato=fin.dato;
    	if(inicio.siguiente!=null){
		Nodo aux=inicio;
		while(aux.siguiente!=fin){
		aux=aux.siguiente;
    	}
    	fin=aux;
    	fin.siguiente=null;
        }else{
		inicio=null;
		fin=null;
	    }
	    
            }return dato;
        }
        
        void visualizarVista(){
	if(inicio!=null){
		Nodo aux=inicio;
		while(aux!=null){
                        System.out.println(aux.dato);
			aux=aux.siguiente;
		}
            }
        }
}
