import java.util.Scanner;
public class JavaPractice {
    public static void insertElement(int arr[],int el, int pos){
        if(pos>=arr.length-1 || pos<0){
            System.out.println("Insertion at Invalid Position");
            return;
        }else{
            for(int i = arr.length-2;i>=pos;i--){
                arr[i+1] = arr[i];
            }
            arr[pos] = el;
        }
    }

    //Delete an element from array
    public static void deleteElement(int arr[], int pos){
        if(pos<0 || pos>=arr.length){
            System.out.println("Deletion at invalid position");
            return;
        }else{
            for(int i = pos; i<=arr.length-2;i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = 0;
        }
    }

    //Print elements of 1-D array
    public static void printArray(int arr[]){
        for(int i = 0 ; i <arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //print elements of 2-d array
    public static void print2DArray(int arr[][]){
        for(int i = 0 ; i<arr.length; i++){
            System.out.println("For "+i+" index");
            printArray(arr[i]);
        }
    }

    //insert element in 2-D array
    public static void insert2D(int arr[][], int pos1, int pos2 , int el){
        insertElement(arr[pos1], pos2,el);
    }

    //delete an element in 2-D array
    public static void delete2D(int arr[][], int pos1, int pos2){
        deleteElement(arr[pos1], pos2);
    }

    //updation in 1D array
    public static void update(int arr[],int element,int pos){
        if(pos<0 || pos>(arr.length-1)){
            System.out.println("Updation at invalid position");
        }
        arr[pos] = element;
    }

    //updation in 2D array
    public static void update2D(int arr[][], int pos1 , int pos2, int el){
        int size1 = arr.length;
        if(pos1<0 || pos1>(size1-1)){
            System.out.println("Updation at invalid position");
        }

        int size2 = arr[pos1].length;
        if(pos2<0 || pos2>(size2-1)){
            System.out.println("Updation at invalid position");
        }

        arr[pos1][pos2] = el;
    }

   
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        // int arr[] = {5,4,3,1,2};
        // arr[0] = 1;
        // arr[1] = 2;
        // for(int i=0; i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }
        // System.out.println(arr.length);

        //initialization of 2-d array
        int mdArray[][] = new int[3][];
        int customSize = 4;
        for(int i= 0; i<mdArray.length; i++){
            mdArray[i] = new int[customSize];
            for(int j = 0; j<mdArray[i].length;j++){
                System.out.println("Enter "+j+" element");
                int el = sc.nextInt();
                mdArray[i][j] = el;
            }
            customSize--;
            System.out.println();
        }
        print2DArray(mdArray);

    }

}
