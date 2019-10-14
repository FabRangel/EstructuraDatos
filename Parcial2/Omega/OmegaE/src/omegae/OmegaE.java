/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegae;

/**
 *
 * @author fabi
 */
public class OmegaE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static int comparar
}

#define MAX 2000000

int comparar(char P[],char T[],int dato);
void visualizar(char p[],int len);

int main(){
	int cont;
	char P[MAX],T[MAX];
	scanf("%s",&P);
	do{
		scanf("%s",&T);
		
	}while(strlen(T)>MAX || strlen(T)<strlen(P));
	printf("%i",comparar(P,T,0));
}

int comparar(char P[MAX],char T[MAX],int dato){
	int i,len,cont=0,record=dato;
	len=strlen(P);
	for(i=0;i<len;i++){
		if(P[i]==T[dato]){
		  	cont++;
		}
		dato++;
	}
	if(dato==strlen(T)){
		return cont;
	}else{
		return cont+comparar(P,T,record+1);
	}
}