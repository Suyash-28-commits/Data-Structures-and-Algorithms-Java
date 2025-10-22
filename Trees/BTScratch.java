import java.util.*;


public class BTScratch {
    static class BinaryTree{
        static class Node{
            int data;
            Node left , right;
            Node(int data){
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }
        //build tree - using array of values
        static int idx = -1;
        public static Node insert(int[]nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = insert(nodes);
            newNode.right = insert(nodes);

            return newNode;
        }
        //PreOrder Travresal - Recursive approach
        public static void preOrder(Node root){
            if(root == null) return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        //PreOrder Traversal - Iterative approach
        public static ArrayList<Integer> preorder(Node root){
            ArrayList<Integer> res = new ArrayList<Integer>();
            if(root == null) return res;

            Stack<Node> s = new Stack<>();
            s.push(root);
            while(!s.isEmpty()){
                Node temp = s.pop();
                res.add(temp.data);

                if(temp.right != null){
                    s.push(temp.right);
                }
                if(temp.left!= null){
                    s.push(temp.left);
                }
            }

            return res;
        }

        //Inorder traversal - Recursive approach
        public static void inOrder(Node root){
            if(root == null) return;
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        //Inorder traversal - Iterative Approach
        public static ArrayList<Integer> inorder(Node root){
            ArrayList<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Stack<Node> s = new Stack<>();
            Node currNode = root;
            boolean done = false;

            while(done!= true){
                if(currNode != null){
                    s.push(currNode);
                    currNode = currNode.left;
                }else{
                    if(s.isEmpty()){
                        done = true;
                    }else{
                        currNode = s.pop();
                        res.add(currNode.data);
                        currNode = currNode.right;
                    }
                }
            }
            return res;
        }

        //PostOrder Traversal - Recursive Approach
        public static void postOrder(Node root){
            if(root == null) return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public ArrayList<ArrayList<Integer>> levelOrder(Node root){
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if(root == null) return res;
            
            Queue<Node> q = new LinkedList<Node>();
            q.offer(root);
            q.offer(null);
            ArrayList<Integer> curr = new ArrayList<>();
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp != null){
                    curr.add(temp.data);
                }
                if(temp.left!= null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }else{
                    ArrayList<Integer> c_curr = new ArrayList<>(curr);
                    res.add(c_curr);
                    curr.clear();

                    //completion of a level
                    if(!q.isEmpty()){
                        q.offer(null);
                    }
                }
            }
            return res;


        }
    
        public static void main(String[]args){
            int values[] ={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
            BinaryTree tree = new BinaryTree();
            Node root = insert(values);
            System.out.println(tree.levelOrder(root));
        }
    }
}








































































































































































































































































































        


