/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

/**
 *
 * @author fabi
 */
public class Lista {
    NodoLS inicio= null;
     
    void insertarFinal (int d){
        NodoLS nuevo = new NodoLS ();
        nuevo.dato = d;
        nuevo.siguiente = null;
        if(inicio == null){
            inicio = nuevo;
        } else{
            NodoLS aux = inicio;
            while(aux.siguiente!= null){
                aux = aux.siguiente;
            }
        aux.siguiente= nuevo;
        }
    }
    
     void recorrer (){
        NodoLS aux = inicio;
        while (aux!= null) {
            if(aux.siguiente == null)
                System.out.println(aux.dato);
            else
            System.out.print(aux.dato+"->");
            aux = aux.siguiente;
        }
    }
     
     Lista encriptar (ListaCir llave){
        Lista encriptado = new Lista();
        NodoLS aux1 = inicio;
        NodoCir aux2 = llave.inicio;
        while(aux1 != null){
            if((aux1.dato+aux2.dato)<255){
                encriptado.insertarFinal(aux1.dato+aux2.dato);
            }else{
                encriptado.insertarFinal((aux1.dato+aux2.dato)-255);
                
            }
            aux1 = aux1.siguiente;
            aux2 = aux2.siguiente;
        }
        //encriptado.recorrer();
        return encriptado;
     }
     
     Lista desencriptar (ListaCir llave){
        Lista desencriptado = new Lista();
        NodoLS aux1 = inicio;
        NodoCir aux2 = llave.inicio;
        while(aux1 != null){
            if((aux1.dato-aux2.dato)<0){
            desencriptado.insertarFinal(255+(aux1.dato+aux2.dato));
            }else{
                desencriptado.insertarFinal((aux1.dato-aux2.dato));
                
            }
            aux1 = aux1.siguiente;
            aux2 = aux2.siguiente;
        }
       // desencriptado.recorrer();
        return desencriptado;
     }
}
