import java.util.Scanner;
class LL{
    Node head;
    private int size;
    LL(){
        this.size = 0;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add - first, last
    //add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //addlast
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    //print
    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data+" ->");
            currNode = currNode.next;
        }
        System.out.println("null");

    }

    //delete - first , last
    //delete first
    public void deletefirst(){
        if(head == null){
            System.out.println("The lsit is empty");
            return;
        }
        size--;
        head = head.next;
    }

    //delete last
    public void deleteLast(){
        if(head == null){  // corner case - 1
            System.out.println("The lsit is empty");
            return;
        }
        size--;
        if(head.next == null){ //corner case - 2
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next!= null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    //get size function - getter
    public int getSize(){
        return size;
    }
    public void addInMiddle(int data, int index){
        if(index < 0 || index > size){
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);
        if(index == 0 || head == null){
            newNode.next = head;
            head = newNode;
        }

        Node currNode = head;
        for(int i = 1 ; i <size; i++){
            if(i == index){
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = currNode;
                break;
            }
            currNode = currNode.next;
        }
    }
    //reverse a LinkedList - Iterative method
    public void reverseIterate(){

        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }
    //reverse a LinkedList -> Recursive Approach
    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args){
        LL list = new LL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();

        list.head  =list.reverseRecursive(list.head);
        list.printList();
    }
}



                                             
                           
