import java.util.HashSet;
public class LinearSearch {
    
    public static void main(String[]args){
        int arr[] ={2,2,3,4,1,7,2,9};
        // linearSearch(arr, 2);//partial searching
        // findLastOccurence(arr, 2, true); //finding last occurence
        // MultipleOccurence(arr,2); //find mutiple ocuurences of a target
        // findMax(arr);
        // findMin(arr);

        int arr2d[][] ={
            {2,4,1,5,1},
            {6,7,3,4,2},
            {8,1,2,2,3},
            {5,5,5,8,4}
        };

        // linearSearch2d(arr2d, 4, true);
        // linearSearc2dmultiple(arr2d, 5);
        int nums[] ={8,8,7,6,5};
        int nums1[] ={1,2,3,4,5};
        int nums2[] = {1,2,7};

        findMaxSumSubArray(arr2d);
        System.out.println(secondLargestElement(nums));
        int union[]=unionArray(nums1, nums2);
        for(int i: union){
            System.out.println(i);

        }


    }
    public static void linearSearch(int arr[],int target){
        int ans = -1;
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i] ==  target){
                ans = i;
                break;
            }
        }
        if(ans!=-1){
            System.out.println("target found at "+ans);
        }else{
            System.out.println("Target not found in an array");
        }
    }
    public static void findLastOccurence(int arr[],int target, boolean last){
        int ans = -1;
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i] ==  target){
                ans = i;
                if(!last) break;
            }
        }
        if(ans!=-1){
            System.out.println("target found at "+ans);
        }else{
            System.out.println("Target not found in an array");
        }
    }

    public static void MultipleOccurence(int arr[],int target){
        int ans[] = new int[arr.length];
        int k = 0;
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i] ==  target){
                ans[k] = i;
                k++;
            }
        }
        if(k!= 0){
            for(int i =0;i<k;i++){
                System.out.println("target found at "+ans[i]);
            }        
        }else{
            System.out.println("Target not found in an array");
        }
    }

    //Applications of Linear Search
    //Finding element with the maximum value in an array
    public static void findMax(int arr[]){
        //Approach - 1, initilaizing max with first element of array
        //fails in case of array containing negative numbers
        // int max = arr[0];

        //Approach-2 : handles cases of negative numbers also
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            if(max < arr[i]){
                max= arr[i];
            }
        }
        System.out.println("Maximum element: "+max);
    }

    public static void findMin(int[] arr){
        int min = arr[0];
        for(int i=0 ;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("Minimum element: "+min);

    }
    //Linear Search in 2D array
    public static void linearSearch2d(int arr[][],int target , boolean findLast){
        int outerIndex = -1;
        int innerIndex = -1;
        for(int i=0; i<arr.length;i++){
            boolean found = false;
            for(int j=0; j<arr[i].length;j++){
                if(target == arr[i][j]){
                    outerIndex = i;
                    innerIndex = j;

                    if(!findLast){
                        found = true;
                        break;
                    }
                }
            }
            if(found) break;
        }
        System.out.println("Target found at position "+outerIndex+","+innerIndex);
    }

    //Finding multiple occurences of a target in 2D Array
    public static void linearSearc2dmultiple(int arr[][],int target){
        //finding size of 2-D array
        // int size = arr.length * arr[0].length; //this case fails in case of jagged arrays
        int size = 0;
        for(int i=0 ; i<arr.length;i++){
            size+=arr[i].length;
        }

        int ans[][] = new int[size][2];
        int k = 0;

        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr[i].length;j++){
                if(target == arr[i][j]){
                    ans[k][0] = i;
                    ans[k][1] = j;
                    k++;
                }
            }
        }

        if(k == 0){
            System.out.println("target not found in 2d array");
        }else{
            for(int m =0;m<k;m++){
                System.out.println("Target found at pos: "+ans[m][0]+","+ans[m][1]);
            }
        }
    }

    //Find maximum sum subarray
    public static void findMaxSumSubArray(int arr[][]){
        int max = Integer.MIN_VALUE;
        int resIndex = -1;
        for(int i=0; i<arr.length;i++){
            int sum = 0;
            for(int j =0 ; j<arr[i].length;j++){
                sum+=arr[i][j];
            }
            if(sum>max){
                max = sum;
                resIndex = i;
            } 
        }
        System.out.println("Maximum sum subarray: "+max+",for index "+resIndex);
    }
    public static int secondLargestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxSubArray = Integer.MIN_VALUE;
        
        for(int i =0; i<nums.length;i++){
            if(nums[i]> max){
                max = nums[i];
            }
            if(nums[i]<min){
                min = nums[i];
            }
        }

        if(min == max){
            return -1;
        }else{
            int arr[] = new int[nums.length];
            int k =0;
            for(int j=0; j<nums.length;j++){
                if(nums[j]>min && nums[j]<max){
                    arr[k] = nums[j];
                    k++;
                }
            }
            for(int m=0;m<k;m++){
                if(arr[k]>maxSubArray){
                    maxSubArray = arr[k];
                }
            }
        }

        return maxSubArray;
    
    }

    public static int[] unionArray(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums1.length;i++){
            set.add(nums1[i]);
        }
        
        for(int j =0; j<nums2.length;j++){
            set.add(nums2[j]);
        }

        int union[] = new int[set.size()];
        int k =0;
        for(int e: set){
            union[k] = e;
            k++;
        }

        for(int i=0; i<union.length-1;i++){
            for(int j=0;j<union.length-i-1;j++){
                if(union[j]>union[j+1]){
                    int temp = union[j];
                    union[j] = union[j+1];
                    union[j+1] = temp;
                }
            }
        }

        return union;

    }

    
}
