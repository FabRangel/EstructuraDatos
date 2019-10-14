/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesavl;

/**
 *
 * @author fabi
 */
public class Arbol {
    Nodo raiz = null;
    
    Nodo obtenerRaiz(){
        return raiz;
    }
    
    
    Nodo buscar(int d, Nodo raiz){
        if(raiz==null){
            return null;
        }else if(raiz.dato==d){
            return raiz;
        }else if(raiz.dato<d){
            return buscar(d,raiz.hijoDer);
        }else {
            return buscar(d,raiz.hijoIzq);
        }
    }
    
    int factorEquilibrio(Nodo nodo){
        if(nodo==null){
            return -1;
        }else{
            return nodo.factor;
        }
    }
    
    //Rotación simple izquierda
    Nodo rotIzquierda(Nodo nodo){
        Nodo aux = nodo.hijoIzq;
        nodo.hijoIzq = aux.hijoDer;
        aux.hijoDer = nodo;
        nodo.factor = Math.max(factorEquilibrio(nodo.hijoIzq),factorEquilibrio(nodo.hijoDer))+1;
        aux.factor = Math.max(factorEquilibrio(aux.hijoIzq),factorEquilibrio(aux.hijoDer))+1;
        return aux;
    }
    
    //Rotación simple derecha
    Nodo rotDerecha(Nodo nodo){
        Nodo aux = nodo.hijoDer;
        nodo.hijoDer = aux.hijoIzq;
        aux.hijoIzq = nodo;
        nodo.factor = Math.max(factorEquilibrio(nodo.hijoIzq),factorEquilibrio(nodo.hijoDer))+1;
        aux.factor = Math.max(factorEquilibrio(aux.hijoIzq),factorEquilibrio(aux.hijoDer))+1;
        return aux;
    }
    
    //Rotación doble a la izquierda
    Nodo rotDobleIzquierda(Nodo nodo){
        Nodo aux = new Nodo();
        nodo.hijoIzq = rotDerecha(nodo.hijoIzq);
        aux = rotIzquierda(nodo);
        return aux;
    }
    
    //Rotación doble a la derecha
    Nodo rotDobleDerecha(Nodo nodo){
        Nodo aux = new Nodo();
        nodo.hijoDer = rotIzquierda(nodo.hijoDer);
        aux = rotDerecha(nodo);
        return aux;        
    }
    
    Nodo insertarAVL(Nodo nuevo, Nodo subarbol){
        Nodo nuevoPadre = subarbol;
        if(nuevo.dato < subarbol.dato){
            if(subarbol.hijoIzq== null){
                subarbol.hijoIzq = nuevo;
            }else{
                subarbol.hijoIzq = insertarAVL(nuevo,subarbol.hijoIzq);
                if((factorEquilibrio(subarbol.hijoIzq)-factorEquilibrio(subarbol.hijoDer)==2)){
                    if(nuevo.dato < subarbol.hijoIzq.dato){
                        nuevoPadre = rotIzquierda(subarbol);
                    }else{
                        nuevoPadre = rotDobleIzquierda(subarbol);
                    }
                }
            }
        }else if(nuevo.dato > subarbol.dato){
            if(subarbol.hijoDer == null){
                subarbol.hijoDer = nuevo;
            }else{
                subarbol.hijoDer = insertarAVL(nuevo,subarbol.hijoDer);
                if((factorEquilibrio(subarbol.hijoDer)-factorEquilibrio(subarbol.hijoIzq))==2){
                    if(nuevo.dato > subarbol.hijoDer.dato){
                        nuevoPadre = rotDerecha(subarbol);
                    }else{
                        nuevoPadre = rotDobleDerecha(subarbol);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        //Actualizar el FE
        if((subarbol.hijoIzq==null)&&(subarbol.hijoDer != null)){
            subarbol.factor=subarbol.hijoDer.factor+1;
        }else if((subarbol.hijoDer==null)&&(subarbol.hijoIzq)!=null){
            subarbol.factor = subarbol.hijoIzq.factor +1;
        }else{
            subarbol.factor = Math.max(factorEquilibrio(subarbol.hijoIzq), factorEquilibrio(subarbol.hijoDer)+1);
        }
        return nuevoPadre;
    }
    
    void insertar(int d){
        Nodo nuevo = new Nodo();
        nuevo.dato = d;
        nuevo.hijoDer = null;
        nuevo.hijoIzq = null;
        if(raiz == null){
            raiz = nuevo;
        }else{
            raiz = insertarAVL(nuevo,raiz);
        }
    }
    
    
    void recorrerPreorden(Nodo aux){
        if(aux == null){
            System.out.print("");
        }
        if(aux != null){
            System.out.print(aux.dato+" ");
            recorrerPreorden(aux.hijoIzq);
            recorrerPreorden(aux.hijoDer);
        }
    }

    void recorrerPosorden(Nodo aux){
        if(aux == null){
            System.out.print("");
        }
        if(aux != null){
            recorrerPosorden(aux.hijoIzq);
            recorrerPosorden(aux.hijoDer);
            System.out.print(aux.dato+" ");
        }
    }    
       
    void eliminarNodo (int d,Nodo nodo){
        Nodo aux = nodo;
        Nodo aux2 = aux.hijoDer;
        Nodo destino = aux2;
        int elemento = d;
        while(aux.dato != d){
            elemento = aux.dato;
            if(aux.dato > d){
                aux = aux.hijoIzq;
            }else{
                aux = aux.hijoDer;
            }
        }
        if((aux.hijoIzq != null)&&(aux.hijoDer != null)){
            elemento = aux.dato;
            while(aux.hijoIzq != null){
                elemento = aux2.dato;
                aux2=aux.hijoIzq;
            }
            aux.dato=aux2.dato;
            aux = aux2;
        }
        if((aux.hijoIzq==null)&&(aux.hijoDer==null)){
            aux2 = null;
        }else if(aux.hijoIzq==null){
            destino = aux2;
            aux2 = aux.hijoDer;
            destino = null;
        }else{
            destino = aux2;
            aux2 = aux.hijoIzq;
            destino = null;
        }
        balancear(d,nodo);
    }
    
    void balancear (int d,Nodo nodo){
        if(nodo != null){
            if(d > nodo.dato){
                balancear(d,nodo.hijoDer);
            }else if(d < nodo.dato){
                balancear(d,nodo.hijoIzq);
            }
            if((factorEquilibrio(nodo.hijoIzq))-(factorEquilibrio(nodo.hijoDer))==2){
                if((factorEquilibrio(nodo.hijoIzq.hijoIzq))>(factorEquilibrio(nodo.hijoIzq.hijoDer))){
                   nodo = rotDerecha(nodo); 
                }else{
                   nodo = rotDobleIzquierda(nodo);
                }
                if((factorEquilibrio(nodo.hijoDer.hijoDer)>factorEquilibrio(nodo.hijoDer.hijoIzq))){
                nodo = rotIzquierda(nodo);
                }else{
                nodo = rotDobleDerecha(nodo);
                }
            }else if((factorEquilibrio(nodo.hijoIzq))-(factorEquilibrio(nodo.hijoDer))==-2){
                if((factorEquilibrio(nodo.hijoDer.hijoDer))>(factorEquilibrio(nodo.hijoDer.hijoIzq))){
                   nodo = rotIzquierda(nodo); 
                }else{
                    nodo = rotDobleDerecha(nodo);
                }
            }else{
                nodo.factor = Math.max(factorEquilibrio(nodo.hijoIzq), factorEquilibrio(nodo.hijoDer)+1);
            }
            
        }
    } 
    
}
