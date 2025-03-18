class Node {
    int val;
    Node next;

    Node(int val,Node next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList(Node head){
        this.head = head;
    }

    void push(int val){
        if(head==null){
            head = new Node(val,null);
        }else{
           Node newnode = new Node(val,head);
           head = newnode;
        }
    }

    void pop(){
        if(head==null){
            System.out.println("Stack is empty!");
        }else{
            head = head.next;
        }
    }

    void display(){
        if(head == null){
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("\n");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp = temp.next;
        }
    }
}

class Stack {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList(null);
        linkedList.push(1);
        linkedList.push(2);
        linkedList.display();
        linkedList.pop();
        linkedList.display();
    }    
}
