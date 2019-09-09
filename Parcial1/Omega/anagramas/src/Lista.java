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
    
   
    Nodo inicio=new Nodo();
    Nodo fin =new Nodo();
       
    void insertarFinal(String dato){
        Nodo nuevo = new Nodo();
        nuevo.palabra = dato;
        nuevo.siguiente = null;
        nuevo.anterior= null;
        if(inicio==null){
            inicio=nuevo;
            fin=nuevo;
        } else {
            inicio.anterior=nuevo;
            nuevo.siguiente=inicio;
            inicio=nuevo;
        }
      }
    
    void insertarInicio(String dato){
        Nodo nuevo= new Nodo();
        nuevo.palabra=dato;
        nuevo.siguiente=null;
        nuevo.anterior=null;
        if(inicio==null){
            inicio=nuevo;
            fin=nuevo;
        } else {
            fin.siguiente=nuevo;
            nuevo.anterior=fin;
            fin=nuevo;
        }
    }
    
 
    void Anagrama (){
        Nodo temporalInicio=new Nodo();
        Nodo temporalFinal=new Nodo();
        int totalTempI=0, totalTempF=0, aux=1;
        temporalInicio=inicio;
        temporalFinal=temporalInicio.siguiente;
        while(temporalInicio!=null){
            
            while (temporalFinal!=null)
            {
                
               if(temporalInicio.palabra.length()==temporalFinal.palabra.length())
               {
                   if (aux==1)
                   {
                      for (int x=0;x<temporalInicio.palabra.length();x++)
                       {
                         totalTempI=totalTempI+temporalInicio.palabra.codePointAt(x);
                       }
                   }
                   for (int x=0;x<temporalFinal.palabra.length();x++)
                   {
                       totalTempF=totalTempF+temporalFinal.palabra.codePointAt(x);
                   }
                   if (totalTempI==totalTempF && aux==1)
                   {
                       System.out.print(temporalInicio.palabra);
                       System.out.print(" ");
                       System.out.print(temporalFinal.palabra);
                       aux++;
                       System.out.print(" ");
                       Eliminar(temporalFinal.palabra);
                       totalTempF=0;
                   }
                   else if (totalTempI==totalTempF)
                   {
                       System.out.print(temporalFinal.palabra);
                       System.out.print(" ");
                       totalTempF=0;
                       Eliminar(temporalFinal.palabra);
                   }
                   else
                   {
                       totalTempF=0;
                       
                   }
                  
               }
                temporalFinal=temporalFinal.siguiente;
               
               
            }
                
                aux=1;
                temporalInicio=temporalInicio.siguiente;
                inicio=temporalInicio;
                totalTempI=0;
                totalTempF=0;
                 if ( temporalInicio!=null && temporalInicio.siguiente!=null)
                 {
                     System.out.println();
                     temporalFinal=temporalInicio.siguiente;
                 }
                 else
                 {
                     
                     break;
                 }
                 
        }
 
    }
        public void Eliminar(String Dato){
       Nodo actual = new Nodo ();
       actual=inicio;
       Nodo atras= new Nodo ();
       atras=null;
       while (actual!=null)
       {
           if (actual.palabra.equals(Dato))
           {
               if (actual==inicio)
               {
                   inicio=inicio.siguiente;
                   inicio.anterior=null;
                   
               }
             
               else
               {
                   atras.siguiente=actual.siguiente;
                   actual.siguiente.anterior=actual.anterior;
                   
               }
           }
           atras=actual;
           actual=actual.siguiente;
       }
       
    }
      public void recorrer (){
       Nodo temp = inicio;
        if (inicio!=null)
       {
           while (temp!=null)
           {
               System.out.println(temp.palabra);
               temp=temp.siguiente;
           }
       }
       else 
       {
            System.out.println("La lista esta vacia");
       }
    }
  

 }