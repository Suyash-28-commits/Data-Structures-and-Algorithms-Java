import java.util.*;
public class Matrix {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = 2;
        int [][] arr = new int[n][n];
        System.out.println("Enter the elements of the matrix");

        // formation of matrix
        for(int i= 0 ; i < n ; i++){
            for(int j = 0; j < n ; j++){
                int element = sc.nextInt();
                arr[i][j] = element;
            }
        }

        //printing of matrix
        System.out.println("Determinant: ");
        for(int i = 0; i <n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        //calculation of detrerminant - given matrix
        int product1 = 0;
        int product2 = 0;
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j){
                    if(i != n-1 && j != n-1){
                        product1 = arr[i][j] * arr[i+1][j+1];
                    }
                }
                if(i == n-1 || j == n-1){
                    product2 = arr[i][j] * arr[j][i];
                    break;
                }               
            }
        }
        int determinant = product1 - product2;
        System.out.println("Determinant: "+determinant);
    
    }
}
