import java.util.*;
public class ArraysPractice {

    //Second Largest Element in an array
    public static int secondLargest(int[]arr){
        if(arr.length <2){
            System.out.println("array can't contain duplicate elements");
            return -1;
        }
        int largest = arr[0];
        int slargest = -1; //second largest element

        for(int i=1;i<arr.length;i++){
            if(arr[i] > largest){
                slargest = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > slargest) slargest = arr[i];
        }

        return slargest;
    }

    //Second Smallest element in an array
    // public static int secondSmallest(int[]arr){
    //     if(arr.length <2){
    //         return arr[0];
    //     }

    //     int smallest = arr[0];
    //     int sSmallest = -1;
    //     for(int i=1;i<arr.length;i++){
    //         if(arr[i] < smallest){
    //             sSmallest = smallest;
    //             sSmallest = arr[i];
    //         }else if(arr)
    //     }

    //     return sSmallest;
    // }
    public static void main(String[]args){
        // int[]arr ={1,2,4,7,7,5};
        // int[]arr1 ={1,0,2,4};
        // String str1 = "flower";
        // String str2 ="flow";
        // String str3 = "flight";
        // System.out.println(str1.compareTo(str2));
        // System.out.println(str1.compareTo(str3));
        // System.out.println('o'-'i');
        

        // System.out.println("Second largest element: "+secondLargest(arr));

    }
    
}
