import java.util.Scanner;
class First{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int rollNo[] = new int[5];

        rollNo[0] = 54;
        // System.out.println(rollNo[0]);
        // for(int i=0; i<rollNo.length;i++){
        //     System.out.print(rollNo[i]+" ");
        // }

        for(int i=0; i<rollNo.length;i++){
            System.out.println("Enter elementa at "+i+" position");
            int el = sc.nextInt();
            rollNo[i] = el;
        }

        //printing elements of array
        printArray(rollNo);
        insert(rollNo, 0, 2);
        printArray(rollNo);
        delete(rollNo, 0);
        printArray(rollNo);
        
    }

    //print array
    public static void printArray(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1) System.out.print(",");
        }
        System.out.println();
    }

    //insertion of element at ith position
    public static void insert(int arr[],int pos, int element){

        int size = arr.length;
        if(pos>=size || pos<0){
            System.out.println("Invalid position");
            return;
        }

        for(int i=size-2;i>=pos;i--){
            arr[i+1] = arr[i];
        }
        arr[pos] = element;
    }

    //deletion of element at ith position
    public static void delete(int arr[],int pos){

        if(pos>=arr.length || pos<0){
            System.out.println("Inavlid position");
            return;
        }
        
        for(int i=pos ;i<=arr.length-2;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;
    }
}