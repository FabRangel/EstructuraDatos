import java.util.Scanner;
public class Main 
{ 
    void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* copia elementos al array l */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* copia elementos al array r */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 

    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
  
    /* Aimprimir arreglo tamaño n*/
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // main
    public static void main(String args[]) 
    { 
      Scanner leer = new Scanner(System.in);
      int tamanio = leer.nextInt();
      int arr[];
      int n=0;
      arr= new int[tamanio];
       for (int i = 0;i<tamanio;i++){
           n = leer.nextInt();
           arr[i]=n;
       }
 
  
       Main ob = new Main(); 
        ob.sort(arr, 0, arr.length-1); 
 
        printArray(arr); 
    } 
}

