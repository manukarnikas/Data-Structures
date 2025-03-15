class Node{
    int val;
    Node next;

    Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList(Node head){
        this.head = head;
    }

    void insertAtBeg(int val){
        if(head == null){
          head  = new Node(val,null);
          head.next = head;
        }else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            Node newhead = new Node(val,head);
            temp.next = newhead;
            head = newhead;
        }
    }

    void insertAtPosition(int val, int pos){
        Node temp = head;
        int count = 0;
        while(count<pos && temp.next!=head){
            temp = temp.next;
            count = count+1;
        }
        Node newnode = new Node(val,temp.next);
        temp.next = newnode;
    }

    void insertAtEnd(int val){
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        Node newnode = new Node(val,temp.next);
        temp.next = newnode;
    }

    void deleteAtBeg(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        if(this.getLength() <=1 ){
            head=null;
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    void deleteAtPosition(int pos){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        if(pos>this.getLength()){
            System.out.println("Invalid position");
            return;
        }
        if(this.getLength()<=1){
            head=null;
            return;
        }
        Node temp = head;
        int count = 0;
        while(count<pos && temp.next.next!=head){
            temp = temp.next;
            count = count+1;
        }
        temp.next= temp.next.next;
    }

    void deleteAtEnd(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        if(this.getLength() <=1 ){
            head=null;
            return;
        }
        Node temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }
        temp.next = head;
    }

    int getLength(){
        if(head==null){
            return 0;
        }
        Node temp = head;
        int count =1;
        while(temp.next != head){
            temp = temp.next;
            count = count+1;
        }
        return count;
    }


    void display(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        System.out.println("Display:");
       do{
            System.out.print(temp.val+" ");
            temp = temp.next;
        } while(temp != head);
    }
}

class CircularlyLinkedList {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList(null);
        linkedList.insertAtBeg(5);
        linkedList.insertAtBeg(10);
        linkedList.insertAtPosition(15,2);
        linkedList.insertAtEnd(25);
        linkedList.display();
        linkedList.deleteAtEnd();
        linkedList.display();
    }
}


