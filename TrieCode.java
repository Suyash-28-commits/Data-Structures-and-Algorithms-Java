public class TrieCode {
    static class Node{
        Node[]children; //children array
        boolean eow; //EndOfWord of a string or a word

        public Node(){
            children = new Node[26];
            for(int i = 0 ; i<26; i++){
                children[i] = null; //initialization of each array elements with null
            }
            eow = false; //first of all when a  node is created , it's eow will be false
        }
    }

    static Node root = new Node(); //root node of Trie
        //root Node doesn't contain a valeue itself
        //it stortes values of it's children at the particular indexes of children array

    //insert operation in Trie
    //Time complexity - O(L) , L = max length of inputted string
    public static void insert(String word){
        Node curr = root;
        for(int i = 0 ; i <word.length();i++){
            int idx = word.charAt(i) -'a';
            //index of element to be stored in children array

            if(curr.children[idx] == null){//add new node
                curr.children[idx] = new Node();
            }
            if(i == word.length()-1){//end of word condition
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    //search in a Trie (Time Complexity -O(L) ,L=max length of inputted string)
    public static boolean search(String key){
        Node curr = root;
        for(int i = 0 ; i <key.length();i++){
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];

            if(node == null){
            //one of the key elements dorsn't exist in Trie
            //ket eleent doesn't exist in children array
                return false;
            }

            if(i == key.length()-1 && node.eow == false){
                return false;
            }
            curr = curr .children[idx];
        }

        return true;
    }

    //Word Break problem
    //-check if a string exists in a Trie from an array of strings
    public static boolean wordBreak(String key){
        if(key.length() == 0){//checks condition for empty string
            //condition valid for root node of Trie also
            //since root node is an empty node
            return true;
        }

        for(int i = 1; i<=key.length();i++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);

            if(search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }

        return false;
    }

    //StartsWith function
    //checks if a string/word in a dictionary starts with a given prefix
    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i = 0 ; i<prefix.length();i++){
            int idx = prefix.charAt(i) -'a';

            if(curr.children[idx] == null && curr.children[idx].eow == false){
                return false;
            }

            curr = curr.children[idx];
        }
        return true;
    }

    //count number of unique substrings of a string
    //count of no. of nodes of Trie = no.of unique substrings of a string
    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i= 0; i<26; i++){
            count+=countNode(root.children[i]);
        }
        return count+1;
    }
    
    //Longest Word with all prefixes
    //to find a word whose all prefixes are stored in a given dictionary of words
    public static String ans ="";//longest word with all prefixes

    //function to calculate the Longest word with all prefixes
    public static void longestWord(Node root,StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i=0; i<26;i++){
            if(root.children[i]!= null && root.children[i].eow == true){
                temp.append((char)(i+'a'));
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                //deleting the characters when backtacking from last
                temp.deleteCharAt(temp.length()-1);
            }
        }

    }
    public static void main(String[]args){
        // String[]words={"i","like","sam","samsung","mobile"};
        // String key ="ilikesamsung";
        // for(int i = 0 ; i < words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(search("their"));
        // System.out.println(search("thor"));
        // System.out.println(search("an"));

        // System.out.println(wordBreak(key));
        // String[]words = {"apple","app","mango","man","woman"};
        // String prefix ="man";
        // for(int i = 0; i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix));

        //count of unique substrings
        //finding suffixes of given string
        // String str = "ababa";
        // for(int i = 0 ; i<str.length();i++){
        //     String suffix = str.substring(i);
        //     insert(suffix);//inserting each suffix in trie
        // }
        // System.out.println(countNode(root));
        String words[]= {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0; i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
    
}
