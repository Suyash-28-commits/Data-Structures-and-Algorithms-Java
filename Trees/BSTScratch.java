public class BSTScratch {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    //build Binary Search Tree
    public static Node buildTree(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = buildTree(root.left, val);
        }else{
            root.right = buildTree(root.right, val);
        }
        return root;
    }

    //inorder traveral of a binary search tree
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //searching nose in a binary search tree
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data > key){
            return search(root.left, key);
        }else if( root.data == key){
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
            //Case 1 
            //node has no child - node is a leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //Case 2- node has one child
            if(root.left == null){
                return root.right;  // left child
            }else if(root.right == null){
                return root.left;   // right child
            }

            //Case 3- node has two child
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root){
        while(root.left!= null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[]args){
        int[] values = { 1, 4,3,7,8,9, 12, 0 , 14};
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = buildTree(root,values[i]);
        }

        inOrder(root);
        System.out.println();

        delete(root,0);
        inOrder(root);
    }
}
