class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int val) {
        data = val;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList {
    private DNode head;

    DoublyLinkedList() {
        head = null;
    }

    // Insert at the beginning
    public void insertAtBeginning(int val) {
        DNode newNode = new DNode(val);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int val) {
        DNode newNode = new DNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete at the beginning
    public void deleteAtBeginning() {
        if (head == null) return;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Delete at the end
    public void deleteAtEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    // Display the list
    public void display() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class doublyList {
    public static void main(String[] args) {
        System.out.println("\nDoubly Linked List:");
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(10);
        dll.insertAtEnd(20);
        dll.insertAtBeginning(5);
        dll.display();
        dll.deleteAtBeginning();
        dll.display();
        dll.deleteAtEnd();
        dll.display();
    }
}
