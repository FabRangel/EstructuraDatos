/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
public class listadoble {
	Nodo inicio;
	Nodo fin;
void insertarPaget(int dato){
	Nodo p= new Nodo();
	p.anterior=null;
	p.siguiente=null;
	p.dato=dato;
	if((inicio == null) && (fin == null)){
		inicio=p;
		fin=p;
	}else{
		p.anterior=fin;
		fin.siguiente=p;
		fin=p;
	}
}

void insertarAJ(int dato){
	Nodo p= new Nodo();
	p.anterior=null;
	p.siguiente=null;
	p.dato=dato;
	if((inicio==null) && (fin==null)){
		inicio=p;
		fin=p;
	}else{
		p.siguiente=inicio;
		inicio.anterior=p;
		inicio=p;
	}
}
int primerPaget(){
	int aux=inicio.dato;
	inicio=inicio.siguiente;
	inicio.anterior=null;
	return aux;
}
int mayorAJ(){
	int dato;
	Nodo aux=inicio;
	Nodo max=inicio;
	while(aux!=null){
		if((aux.dato)>(max.dato)){
			max=aux;
		}
		aux=aux.siguiente;
	}
	dato=max.dato;
	if(max==inicio){
		inicio=inicio.siguiente;
		inicio.anterior=null;
	}else if(max==fin){
		fin=fin.anterior;
		fin.siguiente=null;	
	}else{
		Nodo aux1=max.anterior;
    Nodo aux2=max.siguiente;
		aux1.siguiente=aux2;
		aux2.anterior=aux1;
		
	}
	return dato;
}
}

