class Node {
    int value;
    Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class LinkedList {

    private Node head;

    LinkedList(Node head) {
        this.head = head;
    }
    
    public int size(){
        Node temp = this.head;
        int sizeCount=0;
        while(temp != null){
            temp=temp.next;
            sizeCount+=1;
        }
        return sizeCount;
    }

    public void insert(int value) {
        if (this.head == null) {
            this.head = new Node(value, null);
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value, null);
        }
    }

    public void insertAtPosition(int value, int pos) {
        if(this.head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = this.head;
        if (pos < 1 || pos>size()+1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            this.head = new Node(value, temp);
            return;
        }
        int posCounter = 1;
        while (temp.next != null && posCounter < pos - 1) {
            temp = temp.next;
            posCounter += 1;
        }
        Node nodeAtPosition = temp.next;
        temp.next = new Node(value, nodeAtPosition);
    }

    public void delete(int value) {
        if(this.head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = this.head;
        if (temp.value == value) {
            this.head = temp.next;
            return;
        }
        while (temp.next != null) {
            if (temp.next.value == value) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Delete value not found!");
    }

    public void deleteAtPosition(int pos) {
        if(this.head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = this.head;
        if (pos < 1 || pos>size()+1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            this.head = temp.next;
            return;
        }
        int posCounter = 1;
        while (temp.next != null && posCounter < pos - 1) {
            temp = temp.next;
            posCounter += 1;
        }
        Node nodeAtPosition = temp.next.next;
        temp.next = nodeAtPosition;
    }

    public void display() {
        if(this.head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = this.head;
        System.out.print("\nDisplay result: ");
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
    }
}

class SinglyLinkedlist {
    public static void main(String args[]) {
        LinkedList list = new LinkedList(null);
        list.insert(5);
        list.insert(10);
        list.insert(20);
        list.insertAtPosition(15, 3);
        list.display();
        list.delete(5);
        list.display();
        list.deleteAtPosition(3);
        list.display();
    }
}