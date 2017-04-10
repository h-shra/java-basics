package ds.linkedList;

public class DoubleLinkedList {
    public DoubleLinkedNode head = null;
    public DoubleLinkedNode tail = null;

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.test();
    }

    private void test() {
        head = addAtHead(new DoubleLinkedNode(20000,20000));
        head = addAtHead(new DoubleLinkedNode(2000, 2000));
        head = addAtHead(new DoubleLinkedNode(200, 200));
        head = addAtHead(new DoubleLinkedNode(20, 20));
        head = addAtHead(new DoubleLinkedNode(2, 2));
        print(head);
        head = addAtHead(new DoubleLinkedNode(0, 0));
        print(head);
        deleteFromTail();
        print(head);
    }

    private void print(DoubleLinkedNode head) {
        if (head == null) {
            System.out.println("Empty Double LL");
        } else {
            System.out.println("Double LL");
            while (head != null) {
                System.out.println(head.value);
                head = head.next;
            }
        }
    }

    public DoubleLinkedNode addAtHead (DoubleLinkedNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public DoubleLinkedNode deleteFromTail() {
        if (tail == null) {
            System.out.println("Empty Double LL");
            return null;
        }
        System.out.println("Deleting from tail from Double LL");
        DoubleLinkedNode deleted = tail;
        tail = tail.prev;
        tail.next = null;
        return deleted;
    }

    //        head              tail
    // null <- 2 <-> 3 <-> 4 <-> 5 ->null
    public void delete (DoubleLinkedNode ntd) {
        if (ntd == null) {
            return;
        }
        if (ntd.prev != null) {
            ntd.prev.next = ntd.next;
        }
        if (ntd.next != null) {
            ntd.next.prev = ntd.prev;
        }
        if (ntd == tail) {
            tail = ntd.prev;
        }
        if (ntd == head) {
            head = ntd.next;
        }
    }
}
