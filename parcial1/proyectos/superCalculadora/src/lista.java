/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabi
 */
public class lista {
    Nodo inicio = null;
    Nodo fin = null;
    
    void insertar (int d){
        Nodo nuevo = new Nodo();
        nuevo.dato = d;
        nuevo.sig = null;
        nuevo.ant = null;
        if((inicio == null)&&(fin==null)){
            inicio= nuevo;
            fin = nuevo;
        }else{
            nuevo.sig = inicio;
            inicio.ant = nuevo;
            inicio=nuevo;
        }
        
    }
        
    void recorrer (){
        Nodo aux = inicio;
        while (aux!= null) {
            System.out.print(aux.dato);
            aux = aux.sig;
        }
        System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    }
 
    void suma(lista num1,lista num2){
	Nodo aux1 = num1.fin;
	Nodo aux2 = num2.fin;
	lista resultado = new lista();
        resultado.inicio = null;
	int acarreo = 0;
	int digito = 0;
        int suma = 0;
	while((aux1 != null) && (aux2 != null)){
		suma = aux1.dato + aux2.dato + acarreo;
		acarreo = suma/10;
		digito = suma%10;
                resultado.insertar(digito);
		aux1 = aux1.ant;
                aux2 = aux2.ant;
	}
        Nodo nodin=aux1==null ? aux2:aux1;
        while(nodin != null){
            digito = nodin.dato + acarreo;
            acarreo = suma/10;
            digito = suma%10;
            resultado.insertar(digito);
            nodin = nodin.ant;
        }
	if(acarreo>0){
		resultado.insertar(acarreo);	
	}
        System.out.println(">>Resultado");
        resultado.recorrer ();
    }
    
    void resta (lista num1,lista num2){
        Nodo aux1 = num1.fin;
	Nodo aux2 = num2.fin;
	Nodo acarreo = num1.fin;
	lista resultado = new lista();
        resultado.inicio = null;
	resultado.fin = null;
	while((aux1 != null) && (aux2 != null)){
		if (aux2.dato > aux1.dato){
			while(aux1.dato <aux2.dato){
			acarreo = acarreo.ant;
			if(acarreo.dato == 0){
				acarreo.dato = 9;
			}else{
				acarreo.dato--;
				aux1.dato = aux1.dato+10;
			}
			}
		}
		int resta = aux1.dato - aux2.dato;
		resultado.insertar(resta);
		aux1 = aux1.ant;
		aux2 = aux2.ant;
		acarreo = aux1;
	}
	Nodo nodito=aux1==null ? aux2:aux1;
	while(nodito != null){
		int resta=nodito.dato;
		resultado.insertar(resta);
		nodito = nodito.ant;
	}
	System.out.println(">>Resultado");
        resultado.recorrer();
    }
    
    void sumas(lista resul1,Nodo aux){
	Nodo aux1 = aux;
	Nodo aux2 = resul1.fin;
	int acarreo = 0;
	int digito = 0;
	while((aux1 != null) && (aux2 != null)){
		int suma = (aux1.dato + aux2.dato )+ acarreo;
		acarreo = suma/10;
		digito = suma%10;
		aux1.dato = digito;
		aux1 = aux1.ant;
		aux2 = aux2.ant;
	}
        Nodo nodito=aux1==null ? aux2:aux1;
	while(nodito != null){
		int suma = nodito.dato +acarreo;
		acarreo = suma/10;
		digito = suma%10;
		insertar(digito);
		nodito = nodito.ant;
	}
	if(acarreo>0){
		insertar(acarreo);		
	}
    }
    
    void multiplicacion(lista num1,lista num2){
	   Nodo aux3 = new Nodo();
	   Nodo aux2= num2.fin;
	   lista resultado = new lista ();
           lista resultado1 = new lista ();
	   resultado1.inicio = null;
	   resultado1.fin = null;
	    while(aux2 != null){
	    	Nodo aux1 = num1.fin;
                resultado.inicio = null;
	        resultado.fin = null;
	        int acarreo=0;
	        int digito=0;
	        while(aux1 != null){
		        int suma = (aux1.dato*aux2.dato)+acarreo;
		        acarreo=suma/10;
		        digito=suma%10;
		        resultado.insertar(digito);
		        aux1 = aux1.ant;
	    }
	    resultado.insertar(acarreo);
	    if((resultado.inicio == null) && (resultado.fin == null)){
		Nodo aux = resultado.fin;
		while(aux != null){
			resultado1.insertar(aux.dato);
			aux = aux.ant;
		}
		aux3 = resultado1.fin.ant;
                resultado.recorrer();
	    }else{
                resultado.sumas(resultado1,aux3);
                aux3 = aux3.ant;
            }
	    aux2 = aux2.ant;
	    }
	    System.out.println(">>Resultado");
            resultado.recorrer();
    }
    
    void division(lista num1,lista num2){
        Nodo aux1 = num1.fin;
        Nodo aux2 = num2.fin;
        int cont1 = 0;
        int cociente = 0;
        int residuo = 0;
        while(aux1 != null){
            cont1++;
            aux1 = aux1.ant;
	} aux1 = num1.inicio;
        int pianito = cont1;
        int ndivisor = 0;
        while (aux1 != null){
            ndivisor = ((int) Math.pow(aux2.dato, (cont1 -1)))+ndivisor; 
            cont1--;
            aux1 = aux1.sig;
        }
        int vueltas = 0;
        int ndividendo = 0;
        while(vueltas < pianito){
            ndividendo = ((int) Math.pow(aux2.dato, (cont1 -1)))+ndividendo; 
            vueltas ++;
            aux2 = aux2.sig;
        }
	while (ndivisor <= ndividendo){
            cociente = ndividendo / ndivisor;
            residuo = ndividendo % ndivisor;
            while(aux2.sig != null){
                ndividendo = (residuo * 10)+ aux2.dato;
                aux2 = aux2.sig;
            }
        }
        System.out.println(pianito );
        System.out.println("Cociente: "+cociente+"\n"+"Residuo; "+ residuo );
    }
    
    void borrarLista(){
       Nodo aux = inicio;
       while (aux != null){
           inicio = inicio.sig;
           aux = aux.sig;
           aux.sig = null;
       }
    }


}
    


    
    
    

    



