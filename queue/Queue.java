class Node{
    int val;
    Node next;

    Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    Node front = null, rear = null;

    LinkedList(Node front,Node rear){
        this.front = front;
        this.rear = rear;
    }

    void enqueue(int val){
        if(rear == null){
           Node newnode = new Node(val,null);
           front = newnode;
           rear = newnode;
        }else{
            rear.next = new Node(val,null);
            rear = rear.next;
        }
    }

    void dequeue(){
        if(front == null){
            System.out.println("Queue is empty!");
        }else{
            front = front.next;
        }
    }

    void display(){
        if(front == null){
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("\n");
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp = temp.next;
        }
    }
}

class Queue {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList(null,null);
        linkedList.enqueue(1);
        linkedList.enqueue(2);
        linkedList.enqueue(3);
        linkedList.display();
        linkedList.dequeue();
        linkedList.display();
    }
}
