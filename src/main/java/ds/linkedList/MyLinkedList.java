package ds.linkedList;

public class MyLinkedList {

    protected static Node head = null;
    protected static int nodeCount = 0;

    public static void main(String[] args) {
        int data = 5;
        head = deleteNode(data);
        addAtEnd(data);
        data = 20;
        addAtFirst(data);
        print();
        data = 10;
        addAtEnd(data);
        print();
        head = deleteNode(data);
        print();
        reverse();
        print();
        addAtEnd(new Integer(1));
        addAtEnd(new Integer(23));
        addAtEnd(new Integer(0));
        addAtEnd(new Integer(22));
        print();
        head = changeHead(0);
        print();
    }


    //print linked list
    public static void print() {
        if (head == null) {
            System.out.println("LL empty");
        } else {
            System.out.println("LL:");
            Node currNode = head;
            while (currNode != null) {
                System.out.println(currNode.data);
                currNode = currNode.next;
            }
        }

    }

    //insert at the end
    public static void addAtEnd(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node currentNode = head;
            //traverse till end of linked list
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(data);
        }
        nodeCount++;
    }

    //insert at first position
    public static void addAtFirst(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }
        nodeCount++;
    }

    public static Node reverse() {
        Node reversedPart = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        head = reversedPart;

        return head;
    }

    //delete a node when only that Node is accessible
    public static void delete(Node ntd) {
        if (ntd == null) {
            System.out.println("No node to delete");
        } else {
            ntd.data = ntd.next.data;
            ntd.next = ntd.next;
        }
    }

    //Delete a node given access to the head
    public static Node deleteNode(Integer obj) {
        Node temp = head;
        if (temp == null) {
            System.out.println("No LL to delete from");
            return null;
        }
        if (temp.data == obj) {
            return head.next;
        }

        while (!(temp.next.equals(null))) {
            if (temp.next.data == obj) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    // 12->3->0->2->6->null
    public static Node changeHead(int value) {
        if (head == null) {
            return new Node(value);
        }
        if (head.data == value) {
            return head;
        }
        //verify value exists in LL
        Node temp = head;
        Node newHead = null;
        while (temp.next != null) {
            if (temp.next.data == value) {
                //if exists, change prev. node's next to null
                //and current node to new head
                newHead = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }

        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }


}
