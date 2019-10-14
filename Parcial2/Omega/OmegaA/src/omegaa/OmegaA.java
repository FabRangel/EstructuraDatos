/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegaa;

import java.util.Scanner;

/**
 *
 * @author fabi
 */
public class OmegaA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        int [][] vis = new int[102][102]; 
        int color=0;
        int n, m;
        int xf, yf;
        String [][] mapa = new String[102][102]; 
        Scanner leer = new Scanner(System.in);
        n = leer.nextInt();
        m = leer.nextInt();
        xf = leer.nextInt();
        yf = leer.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                mapa[i][j]= leer.nextLine();
        }    
    }
        for(int i=0; i<=n; i++){
            color++;
            busqueda(n, 1, i,color,n,m,vis,mapa);
            if(vis[xf][yf]==color){
                System.out.println(i);
        }    
    }
}



    
       public static void busqueda(int x, int y, int l,int color,int n,int m,int [][]vis, String[][] mapa){
        if(x<=0 || y<=0 || x>n || y>m)
            return;
        if(vis[x][y]==color)
            return;
        if(mapa[x][y]==".")
            return;
        vis[x][y]=color;
        busqueda(x, y+1, l,color,n,m,vis,mapa);
        busqueda(x, y-1, l,color,n,m,vis,mapa);
        for(int i=1; i<=l; i++){
            busqueda(x+i, y, l,color,n,m,vis,mapa);
            busqueda(x-i, y, l,color,n,m,vis,mapa);    
    }    
}
    
}
