/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios.polinomios2;

/**
 *
 * @author Maryt
 */
public class Lista {
    Nodo inicio = null;
    Nodo fin = null;
    
    void ordenar(){
	if(inicio!=null){
		Nodo aux = inicio;
		Nodo ant = null;
		Nodo aux2= inicio.siguiente;
		Nodo max = inicio;
		Nodo ant2 = inicio;
		while(aux!=null){
			while(aux2!=null){
				if(aux.exponente >max.exponente){
					ant2.siguiente=aux.siguiente;
					aux.siguiente=aux;
					if(aux == inicio){
						inicio=aux2;
					}else{
						ant.siguiente=aux2;
					}
					max=aux2;
					aux=aux2;
					aux2=ant2.siguiente;
				}else{
					aux2=aux2.siguiente;
					ant2=ant2.siguiente;
				}
			}
			ant=aux;
			aux=aux.siguiente;
			max=max.siguiente;
			if(aux == null){
				aux2=null;
			}else{
				aux2=aux.siguiente;
			}
			ant2=aux;
		}
	}
	recorrer();
}
    void simplificar(){
	
		Nodo aux = inicio;
		Nodo aux2 =inicio.siguiente;
		Nodo ant = inicio;
		if(aux2!=null){
			while(aux!=null){
			while(aux2!=null){
				if(aux2.exponente==aux.exponente){
					aux.coeficiente=aux.coeficiente+aux2.coeficiente;
					if(aux.coeficiente<0){
						aux.signo=45;
					}else{
						aux.signo=43;
					}
					if(aux2==fin){
						fin=ant;
					}else{
						ant.siguiente=aux2.siguiente;
					}
					aux2=ant.siguiente;
				}else{
					aux2=aux2.siguiente;
                                        ant=ant.siguiente;
				}
			}
			aux=aux.siguiente;
			if(aux==null){
			aux2=ant=null;	
			}else{
			aux2=aux.siguiente;
		    	ant=aux;
			}
		}
		}
	
    }
    
    void unir(Lista lista2){
	Nodo aux;
	if(lista2.inicio!=null){
		aux=lista2.inicio;
		while(lista2.inicio!=null){
			lista2.inicio=lista2.inicio.siguiente;
			aux.siguiente=inicio;
			inicio=aux;
		    aux=lista2.inicio;
	    }
	}
    }

    void insertarMonomio(int coe, int exp){
	Nodo nuevo= nuevoElemento(/*insertar el coeficiente y exponente*/coe,exp);
	if((inicio==null)&&(fin == null)){
		inicio=nuevo;
		fin=nuevo;
	}else{
		nuevo.siguiente=inicio;
		inicio=nuevo;
	} 
    }
    
    Nodo nuevoElemento(int coe,int exp){
	Nodo q= new Nodo();
        q.coeficiente=coe;
	if(q.coeficiente<0){
		q.coeficiente=q.coeficiente;
		q.signo=45;
	}else{
		q.signo=43;
	}
	q.exponente =exp;
	q.siguiente=null;
	return q;
    }
    
    void recorrer (){
	if(inicio != null){
		Nodo aux = inicio;
		while(aux != null){
			if(aux.coeficiente!=0){
					if(aux!=inicio){
				System.out.print(aux.signo);
			}else if(aux.signo==45){
			    System.out.print(aux.signo);
			}
			if((aux.coeficiente!=1) && (aux.coeficiente!=-1)){
				if(aux.coeficiente<0){
					System.out.print(aux.coeficiente*-1);
				}else{
					System.out.print(aux.coeficiente);
				}
			}else if(aux.exponente==0){
				if(aux.coeficiente<0){
					System.out.print(aux.coeficiente*-1);
				}else{
					System.out.print(aux.coeficiente);
				}
			}
			if(aux.exponente!=1){
				if(aux.exponente!=0){
					System.out.print("x^");
		    	System.out.print(aux.exponente);
		    }
		    
			}else{
				System.out.print("x");
			}
			}
			aux=aux.siguiente;
		}
        }
    }
    
    void cambiarSigno(){
		Nodo aux=inicio;
		while(aux!=null){
			aux.coeficiente=aux.coeficiente*-1;
			if(aux.coeficiente<0){
				aux.signo=45;
			}else{
				aux.signo=43;
			}
			aux=aux.siguiente;
		}
	
    }
    
    Lista multiplicar(Lista lista2){
	Nodo aux2=lista2.buscarFinal();
	Lista multiplo = new Lista();
        Lista resultado = new Lista();
	multiplo.inicio=resultado.inicio=null;
	multiplo.fin=resultado.fin=null;
	while(aux2!=null){
		Nodo aux1=buscarFinal();
		while(aux1!=null){
		Nodo nuevo=nuevoNodo(aux1,aux2);
		if(multiplo.inicio==null){
			multiplo.inicio=nuevo;
			multiplo.fin=nuevo;
		}else{
			nuevo.siguiente=multiplo.inicio;
			multiplo.inicio=nuevo;
		}
		aux1=buscarAuxiliar(aux1);
	    }
	    
	    eliminarYagregar(multiplo,resultado);
	    aux2=lista2.buscarAuxiliar(aux2);
	}
	resultado.simplificar();
	//resultado.ordenar();
        resultado.ordenarbien();
        return resultado;
    }
    
    Nodo nuevoNodo(Nodo aux1,Nodo aux2){
	Nodo nuevo = new Nodo();
        nuevo.coeficiente=aux1.coeficiente*aux2.coeficiente;
	nuevo.exponente=aux1.exponente+aux2.exponente;
	if(nuevo.coeficiente>0){
		nuevo.signo=43;
	}else{
		nuevo.signo=45;
	}
	nuevo.siguiente=null;
	return nuevo;
    }
    
    Nodo buscarAuxiliar(Nodo aux){
	 Nodo prev= new Nodo();
	if(inicio!=null){
		if(aux!=inicio){
		  prev=inicio;
		  while(prev.siguiente!=aux){
		  prev=prev.siguiente;
		  }
		}else{
			prev=null;
		}
	}
	return prev;
    }
    
    Nodo buscarFinal(){
	Nodo aux = new Nodo();
	if(inicio!=null){
		aux=inicio;
		while(aux.siguiente!=null){
			aux=aux.siguiente;
		}
	}
	return aux;
    }
    
       
    void eliminarYagregar(Lista lista1,Lista lista2){
	Nodo aux=lista1.inicio;
	while(aux!=null){
		lista1.inicio=lista1.inicio.siguiente;
		aux.siguiente=null;
		if(lista2==null){
			lista2.inicio=aux;
			lista2.fin=aux;
		}else{
			aux.siguiente=lista2.inicio;
			lista2.inicio=aux;
		}
		aux=lista1.inicio;
	}

    }
    
    void suma (Lista Lista2){
     unir(Lista2);
     simplificar();
     //ordenar();
     ordenarbien();
    
    }
     
    void division (Lista Lista2,int CR){
        System.out.println("Entra1");
        ordenarbien();
        Lista2.ordenarbien();
        
        Nodo aux1=inicio;
        Nodo aux2=Lista2.inicio;
        Lista cociente=new Lista();
        Lista jokeC=new Lista();
        Lista resto=new Lista();
        //while(aux2.exponente>=aux1.exponente){
      for(int i=1 ; i<=3;i++){
            Lista2.ordenarbien();
            aux2=Lista2.inicio;
            if(aux2.coeficiente==0){
                Lista2.ordenarbien();
                System.out.println(aux2.coeficiente);
            Lista2.cambiarSigno();
            aux2=Lista2.inicio;
            aux2=aux2.siguiente;
            cociente.insertarFinal((aux2.coeficiente/aux1.coeficiente)*-1,(aux2.exponente-aux1.exponente));
            Lista2.cambiarSigno();
            }else{
            cociente.insertarFinal((aux2.coeficiente/aux1.coeficiente),(aux2.exponente-aux1.exponente));}
            jokeC.insertarFinal((aux2.coeficiente/aux1.coeficiente),(aux2.exponente-aux1.exponente));
            resto=multiplicar(jokeC);
            jokeC.inicio=null;
            resto.cambiarSigno();
            Lista2.suma(resto);   
       }
            if(CR==1){
            cociente.recorrer();
            }else{
            Lista2.recorrer();
            }    
    }
       
    
   void insertarFinal (int coe,int exp){
   Nodo nuevo= nuevoElemento(coe,exp);
   if(inicio==null){
     inicio=nuevo;
    } else{
   Nodo aux= inicio;
   while(aux.siguiente!=null){
   aux=aux.siguiente;
   }
   aux.siguiente=nuevo;
   }
   }
   
   void ordenarbien(){
   Nodo aux=inicio;
   Nodo aux2=inicio.siguiente;
   while(aux2!=null){
   aux2=aux.siguiente;
   while ((aux2!=null)&&(aux.exponente>aux2.exponente)){
   aux=aux2;
   aux2=aux2.siguiente;
   }
   if(aux2!=null){
   aux.siguiente=aux2.siguiente;
   aux2.siguiente=null;
   Nodo aux4=inicio; 
   Nodo aux3=null;
   while((aux4!=null)&&(aux4.exponente>aux2.exponente)){ 
   aux3=aux4;
   aux4=aux4.siguiente;
   }
   if(aux3==null){
   aux2.siguiente=aux4;
   inicio=aux2;
   }else{
   aux2.siguiente=aux4;
   aux3.siguiente=aux2;
   }}}
   }
}
