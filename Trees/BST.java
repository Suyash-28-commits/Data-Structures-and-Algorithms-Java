import java.util.*;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){  //left subtree
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val); // right subtree
        }
        return root;
    }

    //inorder traversal - to check if bst is build or not
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // binary search tree search
    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }

        if(root.data > key){  // left subtree
            return search(root.left, key);
        }else if(root.data == key){ // right subtree
            return true;
        }else{
            return search(root.right, key);
        }  
    }

    // delete a node form binary tree
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right = delete(root.right, val);
        }else{
            // root.data == val
            // Case - 1 : root has no child i.e. rot is a leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //Case 2- root has one child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //Case 3- root has two childs
            Node IS = inorderSuccessor(root.right); // finding inorder successor
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }

        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!= null){
            root = root.left;
        }

        return root;
    }

    //Q- Print numbers in range
    public static void printRange(Node root, int x , int y){
        if(root == null) return;

        if(root.data >=x && root.data<=y){
            printRange(root.left, x, y);
            System.out.print(root.data+" ");
            printRange(root.right, x, y);
        }else if( root.data >= y){
            printRange(root.left, x, y);
        }else{
            printRange(root.right, x, y);
        }
    }

    public static void printPath(ArrayList<Integer>path){
        for(int i = 0; i < path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    //q- print all root to leaf paths
    public static void printRootToLeaf(Node root,ArrayList<Integer> path){
        if(root == null) return;

        path.add(root.data);
        if(root.left == null && root.right ==null){ // leaf node
            printPath(path);
        }else{ // non leaf node
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }

        path.remove(path.size()-1);
    }
    public static void main(String[]args){
        int values[] = {8,5,3,6,10,11,14}; // array of values to be inserted
        Node root = null;

        for(int i = 0; i< values.length ; i++){
            root = insert(root,values[i]);
        }
        System.out.println("Binary search tree inorder sequence: ");
        inOrder(root);
        System.out.println();

        printRootToLeaf(root,new ArrayList<>()); 
        
    }
    
}
