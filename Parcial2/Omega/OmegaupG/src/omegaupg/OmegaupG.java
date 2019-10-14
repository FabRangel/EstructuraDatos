/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegaupg;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaupG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i,N,M;
        vint N, M;
        edge tree[MAXN];
        int start[MAXN], nextNode = 1;
        int xor[MAXN];
        Scanner leer = new Scanner(System.in);
        N = leer.nextInt();
        M = leer.nextInt();
	for (i = 1; i < N; i++){
		int a, b, c;
                a = leer.nextInt();
                b = leer.nextInt();
                c = leer.nextInt();
		addEdge(a, b, c);
		addEdge(b, a, c);
	}

	f(1, 0);

	while (M==M){
		int a, b;
                a = leer.nextInt();
                b = leer.nextInt();
	}
    }
    
    public static int f(int n, int p){
	int i;
	for (i = start[n]; i; i = tree[i].next){
		if (tree[i].node == p) continue;
		xor[tree[i].node] = xor[n] ^ tree[i].cost;
		f(tree[i].node, n);
	}
        
    public static void addEdge(int a, int b, int c){
	tree[nextNode].node = b;
	tree[nextNode].cost = c;
	tree[nextNode].next = start[a];
	start[a] = nextNode++;
        }
}
    
}







