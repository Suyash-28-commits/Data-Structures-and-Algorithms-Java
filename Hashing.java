import java.util.HashSet;
import java.util.Iterator;
public class Hashing {
    public static void main(String[]args){
        //creattion of HashSet
        HashSet<Integer> set = new HashSet<>();

        //add operation
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        //size of set
        System.out.println("size of set:"+set.size());

        //print all elements
        System.out.println(set);

        //search - contains
        // if(set.contains(1)){
        //     System.out.println("set contains 1");
        // }

        // if(!set.contains(6)){
        //     System.out.println("does not contain 6");
        // }

        //delete - from HashSet - using remove function
        // set.remove(1);
        // if(!set.contains(1)) System.out.println("element 1 delted");

        //iterator in HashSet
        Iterator it = set.iterator();
        //hasNext ; next functions of set
        while(it.hasNext()){
            System.out.println(it.next());
        }





    }
    
}
