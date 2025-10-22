import java.util.*;
public class ClassRoom {
    public static void majorityElement(int nums[]){ //find the majority element of array
        HashMap<Integer,Integer> map = new HashMap<>(); //creation of HashMap
        int n = nums.length; //length of array

        for(int i=0 ; i<n; i++){//storing frequency of each element in an array
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(int key : map.keySet()){ //traversing the map to find the elment with frequency > (n/3)
            if(map.get(key) > n/3){
                System.out.println(key);
            }
        }
        //time complexity -O(n) in all average cases
    }

    public static int union(int arr1[],int arr2[]){//find union of two arrays or sets
        HashSet<Integer> set = new HashSet<>(); //creation of hashset

        for(int i = 0 ; i <arr1.length ; i++){//adding elements of arr1(set1) to set
            set.add(arr1[i]);
        }

        for(int j=0; j<arr2.length;j++){//adding elements of arr2(set2) to set
            set.add(arr2[j]);
        }
        return set.size(); //number of elements in union
        //time complexity - O(n)
    }

    //find intersection of two arrays
    public static int intersection(int arr1[],int arr2[]){
        HashSet<Integer> set = new HashSet<>();//creation of HashSet
        int count = 0;//count of number of common elements in two arrays

        //Two choices -
        //1->add unique elements of arr1
        //2->add unique elements of arr2
        for(int i = 0 ; i <arr1.length; i++){ //adding unique elements of arr1
            set.add(arr1[i]);//adding elements of arr1 in set
        }

        for(int j = 0 ; j <arr2.length ; j++){//comparison of unique elements of arr1 with arr2
            if(set.contains(arr2[j])){//match condition
                count++;
                set.remove(arr2[j]);
            }
        }
        return count; //count of number of common elements
        //Time complexity - O(n)
    }

    //find intenerary /journey path from tickets
    //Step 1: find the start of the journey path
    public static String getStart(HashMap<String,String>tick){
        //creation of reverse HashMap
        HashMap<String,String> revMap = new HashMap<>();

        //storing values in reverse HashMap
        for(String key: tick.keySet()){
            //key of tick -> value of revMap
            //value of tick -> key of revMap
            revMap.put(tick.get(key),key);
        }

        //return start of the itenerary
        for(String key: tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;//start of the journey
            }
        }

        return null;//this case will not occur as our journey will have a start according to the question

    }
    //public static void main
    //string arguements
    //Integer arguements
    //String arguements

    public static void main(String[]args){
        //majoriy element of array:
        int nums[] ={1,3,2,5,1,3,1,5,1};
        int nums2[] ={1,2};

        //union of two arrays
        int arr1[] ={7,3,9};
        int arr2[] ={6,3,9,2,9,4};
        System.out.println(union(arr1,arr2));

        //intersection of two arrays
        System.out.println(intersection(arr1, arr2));

        /*find itenerary from tickets
        Data given for all tickets:
        Chennai -> Bengaluru
        Mumbai -> Delhi
        Goa -> Chennai
        Delhi -> Goa
        */
        //Representing this data in the form of HashMap
        HashMap<String,String> tickets = new HashMap<String,String>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi", "Goa");

        //start of the journey
        String start = getStart(tickets);

        //printing the itnerary
        while(tickets.containsKey(start)){
            System.out.print(start+" ->");
            start = tickets.get(start); //updation of start
        }
        System.out.println(start);

        //Subarray sum equal to k
        int arr[] ={10,2,-2,-20,10};
        HashMap<Integer,Integer> map = new HashMap<>();

        int k = -10;
        map.put(0,1);
        int ans = 0;
        int sum = 0;

        for(int j = 0 ; j<arr.length; j++){
            sum+=arr[j];

            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        System.out.println(ans);


        
       
    }

    
}
