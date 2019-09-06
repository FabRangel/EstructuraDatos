/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
public class Lista {
    Nodo inicio = null;

    
     void insertar (int d){
        Nodo nuevo = new Nodo();
        nuevo.dato = d;
        nuevo.sig = null;
        if (inicio == null){
            inicio = nuevo;
        }else{
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux != null){
                ant = aux;
                aux = aux.sig;
            }
            ant.sig = nuevo;
        }
    }
    
     
     int digitoMax(){
         int maximo =0;
         Nodo aux = inicio;
         while (aux != null){
             int actual = digitos (aux.dato);
             maximo = actual > maximo ? actual: maximo;
             aux = aux.sig;
         }
         return maximo;
     }
     
     Nodo eliminarInicio(){
         Nodo aux = inicio;
         if(aux != null){
             inicio = inicio.sig;
             aux.sig = null;
         }
         return aux;
     }
     
     void insertarFinal(Nodo nuevo){
         Nodo aux = inicio;
         Nodo ant = null;
         while(aux != null){
             ant = aux;
             aux = aux.sig;
         }
         if(ant == null){
             inicio = nuevo;
         }else{
             ant.sig = nuevo;
         }
     }
     
     void ordenarRadix(){
         Lista arreglo [] = new Lista [10];
         for(int i = 0; i<10; i++){
             arreglo [i] = new Lista();
         }
         Nodo actual = null;
         int con=1;
         int vuelta = digitoMax();
         while(con<=vuelta){
             while ((actual = eliminarInicio() )!= null){
             int digito = digito (actual.dato,vuelta);
             arreglo[digito].insertarFinal(actual);
             for(int i = 0;i<arreglo.length;i++){
                 arreglo[i].recorrer();
             }
             recorrer();
             }
              for(int i = 0;i<arreglo.length;i++){
                 unirListas(arreglo[i]);
             }
             recorrer();
             con++;
         }
    }
     
     int digitos (int numero){
         return String.valueOf(numero).length();
     }
     
     int digito(int dato, int vue){
        int d=0;
        for(int i = 0; i<vue;i++){
            d=dato%10;
            dato=dato/10;
        }
        return d;
     }
     
     void unirListas (Lista lis){
        Nodo ant = null;
        Nodo aux = inicio;
        while (aux != null){
            ant = aux;
            aux = aux.sig;
        }
        if (ant == null){
            inicio = lis.inicio;
         
        }else{
            ant.sig = lis.inicio;
        }
        lis.inicio = null;
    }
     
        void recorrer (){
        Nodo aux = inicio;
        while (aux!= null) {
            System.out.print(aux.dato+" ");
            aux = aux.sig;
        }
    }

}
