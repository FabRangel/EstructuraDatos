
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        listadoble Lista1 = new listadoble();
        listadoble Lista2 = new listadoble();
	Lista1.inicio=Lista2.inicio=null;
	Lista1.fin=Lista2.fin=null;
	int N,x;
	char A= '\0';
	do{
            Scanner leer=new Scanner(System.in); 
            N = leer.nextInt();
	}while((N<1) || (N>100000));
		while(N!=0){
                    Scanner escaneo = new Scanner(System.in);
                    A = escaneo.next().charAt(0);
                }
		switch(A){
			case 'I':
				do{
					Scanner leer=new Scanner(System.in); 
                                         x = leer.nextInt();
				}while((x<-pow(10,12)) || (x>pow(10,12)));
				Lista1.insertarPaget(x);
				Lista2.insertarAJ(x);
				N--;
				break;
			case 'Q':
				if((Lista1.inicio==null) || (Lista2.inicio==null)){
					System.out.println("MARIOLA NO!\n");
				}else{
                                    int nom = abs(Lista1.primerPaget()-Lista2.mayorAJ());
				System.out.println("\n"+nom);
				}
				N--;
				break;
		}
	}
}