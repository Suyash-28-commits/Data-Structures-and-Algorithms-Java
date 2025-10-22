import java.util.*;
public class PC{
    public static void calGCD(int m , int n){
        if(n == 0){
            System.out.println("GCD: "+m);
            return;
        }
        if( n > m){
            n = m;
            m = n;
        }
        int c =  m % n;
        calGCD(n, c); 
    }
    public static void main(String[]args){
        // Scanner sc = new Scanner(System.in);
        // //calculate greatest common divisor of two numbers
        // System.out.println("Enter two numbers: ");
        // int m = sc.nextInt();
        // int n = sc.nextInt();
        // calGCD(m, n);    
        System.out.println("Trishaa is a good girl");

    }
}
