import java.util.*;
public class HashMapCode {
    static class HashMap<K,V>{ //generics
        private class Node{ //linked list nodes
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //no. of nodes in Linked List
        private int N; //no. of buckets
        private LinkedList<Node> buckets[]; //array of linked list
        //N = buckets.length

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0  ; i <4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        //hashfunction
        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N; //to return 0 - (N-1) value
        }

        //search for a given key in LinkedList
        private int searchInLL(K key , int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i = 0 ; i <ll.size();i++){
                if(ll.get(i).key == key){
                    return i; //di - data index of linked list
                }
            }

            return -1; //-1 represnts data doesn't exist in LinkedList
        }

        //rehashing function
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i = 0 ; i<N*2; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0 ; i <oldBuckets.length; i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j = 0 ; j <ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        //put function 
        public void put(K key, V value){
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi);//data index

            if(di == -1){ //key doesn't exist
                buckets[bi].add(new Node(key,value));
                n++;
            }else{
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lambda =(double) n/N;
            if(lambda < 2.0){ // k (threshold value) = 2.0
                //Rehashing
                rehash();
            }
        }

        //get function
        public V get(K key){
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi);//data index

            if(di == -1){ //key doesn't exist
                return null;
            }else{ //key exist
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        //containsKey() function
        public boolean containsKey(K key){
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi);//data index

            if(di == -1){ //key doesn't exist
                return false;
            }else{ //key exist
                return true;
            }    
        }

        //remove function
        public V remove(K key){
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi);//data index

            if(di == -1){ //key doesn't exist
                return null;
            }else{ //key exist
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }        
        }

        //isEmpty function
        public boolean isEmpty(){
            return n == 0;
        }

        //keySet function
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0 ; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j = 0 ; j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        //valueSet function
        public ArrayList<V> valueSet(){
            ArrayList<V> values = new ArrayList<>();
            for(int i = 0 ; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j = 0 ; j<ll.size();j++){
                    Node node = ll.get(j);
                    values.add(node.value);
                }
            }
            return values;
        }
    }
    public static void main(String[]args){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",190);
        map.put("China",200);
        map.put("US",30);

        ArrayList<String> keys = map.keySet();
        for(int i = 0 ;i< keys.size();i++){
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));

        }

        map.remove("India");
        System.out.println(map.get("India"));
        int[]arr = new int[2];
        Integer[]arr1 = new Integer[4];
        ArrayList<Integer>list = new ArrayList<>();
        

    }
}
