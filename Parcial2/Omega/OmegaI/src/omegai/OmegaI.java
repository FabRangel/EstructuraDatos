/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegai;

import static java.lang.Double.max;
import java.util.Scanner;
import static sun.util.calendar.CalendarUtils.mod;


/**
 *
 * @author fabi
 */
public class OmegaI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String A, B;
        int n = 0, m;
        int[] S = new int [1000002];
        int[] T = new int [1000002];
        int[][] sig= new int [1000002][3];
        int[] w=new int [1000002];
        Scanner leer = new Scanner(System.in);
	A = leer.nextLine();
        B = leer.nextLine();
	m = B.length();
	for( int i = 0; i < A.length(); i++ ){
		if( A.charAt(i) == 'U' )
			n = (int) max( n - 1, 0 );
		else 
			S[++n] =  A.charAt(i) == 'L' ? 1 : 0;
	}
	for( int i = 0; i < m; i++ ){
		if( B.charAt(i) == 'U' )
			T[i + 1] = 2;
		else
			T[i + 1] = B.charAt(i) == 'L' ? 1 : 0;
	}
	int [] aux = { 0, 0, 0 };
	for( int i = m; i >= 0; i-- ){
		for( int j = 0; j < 3; j++ )
			sig[i][j] = aux[j];
		aux[ T[i] ] =  i;
 	}
 	for( int i = m;i==i; i-- ){
 		if( T[i] == 2 ) continue;
 		if( sig[i][0] == 0 && sig[i][1] == 0 ){
 			w[i] = 1;
 			continue;
 		}
 		w[i] = ( w[ sig[i][0] ] + w[ sig[i][1] ] + 1 ) % mod;
 	}
 	int ans = 0, idx = 0;
 	ans = ( w[ sig[0][0] ] + w[ sig[0][1] ] + 1 ) % mod;

	for( int i = 0; i < n; i++ ){
		idx = sig[idx][2];
		if( idx == 0 )
			break;
		//cout << idx << " " << sig[idx][0] << " " << sig[idx][1] << "\n";
		ans += S[n - i] == 0 ? w[ sig[idx][1] ] + 1 : w[ sig[idx][0] ] + 1 ;
		ans %= mod;
	}
	       System.out.println(ans);

    }
    
}

