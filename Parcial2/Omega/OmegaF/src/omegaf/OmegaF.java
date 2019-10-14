/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omegaf;

/**
 *
 * @author fabi
 */
public class OmegaF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    int dfs(int i,int ar,int ac,int br,int bc){
	int d;
	char nc;
        String[][] teclado={
	{"qwertyuiop","asdfghjkl;","zxcvbnm,./","**      **"},
        {"QWERTYUIOP","ASDFGHJKL:","ZXCVBNM<>?","**      **"}
        };
	char[] poema = new char[110];
        char[][][][][] vis =new char[110][4][10][4][10];
	if(poema[i]=='\0'){
            return 1;
        }else{ 
            if(vis[i][ar][ac][br][bc]==1){ 
            return 0;
            }
        }
	vis[i][ar][ac][br][bc]=1;
	int[] dr={2,2,1,-1,-2,-2,1,-1};
        int[] dc={1,-1,2,2,1,-1,-2,-2};
	for(d=0;d<8;d++){
		int ar_=ar+dr[d];
		int ac_=ac+dc[d];
		
		if(ar_>=0&&ar_<4 &&ac_>=0 && ac_ < 10 &&(ar_ != br || ac_ != bc)) {
                if ((nc = teclado[teclado[br][bc] == '*'][ar_][ac_]) == poema[i] ||nc == '*') {
                    if (dfs(i + (nc != '*'), ar_, ac_, br, bc)) {
                        return 1;
                    }
                }
            }
	}
	
	return dfs(i, br, bc, ar, ac);
}
    
}