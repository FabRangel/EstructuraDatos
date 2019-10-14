/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author fabi
 */
public class Cola {
    Nodo inicio = null;
    Nodo fin = null;
    
    void push(char dato){
        Nodo nuevo = new Nodo();
        nuevo.raiz.letra = dato;
        nuevo.sig = null;
        nuevo.ant = null;
        if (inicio != null){
            inicio.ant = nuevo;
            nuevo.sig = inicio;
            inicio = nuevo;
        }else{
            inicio = nuevo;
            fin = nuevo;
        }
       // System.out.println("***"+nuevo.dato);
    }
    
    int pop(){
        if (fin != null){
            Nodo aux = fin;
         //   System.out.println(aux.dato);
        if(inicio == fin){
                inicio = null;
                fin = null;
            }else{
                fin.sig = null;
                fin = fin.ant;
//                fin.siguiente = null;
       
        }
            aux.sig = null;
            aux.ant = null;
           // System.out.println(aux.dato);
            
        return aux.raiz.letra;
            
        } else
        return 0;
    }
    
     void ordenar(){
	if(inicio!=null){
		Nodo piv=inicio;
		Nodo apiv=null;
		Nodo aux=inicio.sig;
		Nodo max=inicio;
		Nodo ant=inicio;
		while(piv!=null){
			while(aux!=null){
				if(aux.raiz.fr < max.raiz.fr){
					ant.sig=aux.sig;
					if(ant.sig==null)
					fin=ant;
					aux.sig=piv;
					if(piv==inicio){
						inicio=aux;
					}else{
						apiv.sig=aux;
					}
					max=aux;
					piv=aux;
					aux=ant.sig;
				}else{
					aux=aux.sig;
					ant=ant.sig;
				}
			}
			apiv=piv;
			piv=piv.sig;
			max=max.sig;
			if(piv==null){
				aux=null;
			}else{
				aux=piv.sig;
			}
			ant=piv;
		}
	}
    }
     
     Arbol desencolar(){
	Nodo aux= new Nodo();
	aux=inicio;
	inicio=inicio.sig;
		aux.sig=null;
		if(inicio!=null){
			inicio.ant=null;
		}else{
			fin=null;
                }
	Arbol resultado=aux.raiz;
	aux = null;
	return resultado;
    }
     
     void insertarOrden(Arbol dato){
	Nodo nuevo=new Nodo();
        nuevo.raiz=dato;
	Nodo aux=inicio;
        Nodo ant=null;
	while(aux!=null){
		if(aux.raiz.fr==nuevo.raiz.fr){
			if(aux==inicio){
				nuevo.sig=inicio;
				inicio.ant=nuevo;
				inicio=nuevo;
			}else{
		   	    ant.sig=nuevo;
			    nuevo.ant=ant;
			    nuevo.sig=aux;
			    aux.ant=nuevo;
			}
			return;
		}
		ant=aux;
		aux=aux.sig;
	}
	if(inicio==null && fin==null){
		inicio=nuevo;
		fin=nuevo;
	}else{
		fin.sig=nuevo;
                nuevo.ant=fin;
    	fin=nuevo;
	}
    }
     
    void algoritmoHuffman(){
	int n;
        if(inicio==fin){
         return;   
        }
	Arbol nuevo1= desencolar();
	Arbol nuevo2= desencolar();
	n = nuevo1.fr + nuevo2.fr;
	Arbol arbolito = new Arbol();
	arbolito.izq=nuevo1;
	arbolito.der=nuevo2;
	insertarOrden(arbolito);
	algoritmoHuffman();
    }
}
