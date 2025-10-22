import java.util.*;
public class Hashing2 {
    public static void main(String[]args){
        //Implentation of HashMap
        //HashMap creation
        //HashMap - country(key) -> population (value) in Crore
        HashMap<String , Integer> map = new HashMap<>();

        //insertion -> put method
        map.put("India",120);
        map.put("US",50);
        map.put("China",150);

        System.out.println(map);
        map.put("China",180);
        System.out.println(map);

        //search operation
        // -> containsKey() method
        // if(map.containsKey("Indonesia")){
        //     System.out.println("key present in map");
        // }else{
        //     System.out.println("key is not present in map");
        // }
        
        //->get method
        // System.out.println(map.get("China"));
        // System.out.println(map.get("Indonesia"));

        //for loop nortmal construct
        // int arr[] ={1,2,3};
        // for(int i = 0; i <3 ; i++){
        //     System.out.println(arr[i]);
        // }
        // System.out.println();

        //same for loop construct - using array as an collecition of elements
        // for(int val : arr){
        //     System.out.println(val);
        // }

        //Iteration in HashMap
        //Using entrySet
        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        //Using keySet of Sets
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key+" "+map.get(key));
        }
       
    }
    
}
