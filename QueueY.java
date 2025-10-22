import java.util.*;
public class QueueY {
    // static class Node{
    //     int data;
    //     Node next;

    //     Node(int data){
    //         this.data = data;
    //         next = null;
    //     }
    // }
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return s1.pop();
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return s1.peek();

        }



        // static Node head = null;
        // static Node tail = null;

       
        // public static boolean isEmpty(){
        //     return head == null & tail == null;
        // }

        // //enqueue - add operation
        // public static void add(int data){
        //     Node newNode = new Node(data);
        //     if(tail == null){
        //         head = tail = newNode;
        //     }
        //     tail.next = newNode;
        //     tail = newNode;

        // }

        // //dequeue - remove operation 
        // public static int remove(){
        //     if(isEmpty()){
        //         System.out.println("empty queue");
        //         return -1;
        //     }

        //     int front = head.data;
        //     if(head == tail){
        //         tail = null;
        //     }
        //     head = head.next;
        //     return front;

          
        // }

        // //peek
        // public static int peek(){
        //     if(isEmpty()){
        //         System.out.println("empty queue");
        //         return -1;
        //     }
        //     return head.data;
         
        // }

        public static void main(String[]args){
            Queue q = new Queue();
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);

            while(!isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
            
        }


    }

}
