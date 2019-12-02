/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huff;

/**
 *
 * @author fabi
 */
public class Lista {
    NodoLista raiz = null;
    
    void insertar(Simbolo nuevoSimb,NodoLista izq, NodoLista der){
        NodoLista nuevo = new NodoLista();
        nuevo.simbolo = nuevoSimb;
        nuevo.arista = -1;
        nuevo.der = der;
        nuevo.izq = izq;
        nuevo.padre = null;
        nuevo.siguiente = null;
        
        if (izq != null){
            izq.arista = 0;
            izq.padre = nuevo;
        }
        if(der != null){
            der.arista = 1;
            der.padre = nuevo;
        }

	NodoLista aux;
        NodoLista aux2;
	if(raiz == null){
            raiz = nuevo;
            nuevo.siguiente = null;
	}else{
            aux = raiz;
            while(aux!= null){
                aux2 = aux.siguiente;
		if(nuevo.simbolo.frecuencia <= aux.simbolo.frecuencia){
                    nuevo.siguiente = raiz;
                    raiz = nuevo;
                    break;
		}else{
                    if ((nuevo.simbolo.frecuencia > aux.simbolo.frecuencia) && (aux2 == null)){
			aux.siguiente = nuevo;
                        nuevo.siguiente = null;		
                        break;
                    }else{
                        if ( (aux.simbolo.frecuencia < nuevo.simbolo.frecuencia) && (aux2.simbolo.frecuencia >= nuevo.simbolo.frecuencia)) {
                            aux.siguiente = nuevo;
                            nuevo.siguiente = aux2;
                            break;
			}else{
       			    aux = aux.siguiente;   					
                            }
                        }
                    }
                }

            }

        }
}
