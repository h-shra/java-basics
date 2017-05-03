package ds.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListOperations {

    public static void main(String[] args) {
        LinkedListOperations listOperations = new LinkedListOperations();
        Node head = null;
        int data = 5;
        head = listOperations.deleteNode(head, data);
        head = listOperations.removeDups(head);
        head = listOperations.addAtEnd(head, data);
        data = 20;
        head = listOperations.addAtFirst(head, data);
        listOperations.print(head);
        data = 10;
        head = listOperations.addAtEnd(head, data);
        listOperations.print(head);
        head = listOperations.deleteNode(head, data);
        listOperations.print(head);
        head = listOperations.reverse(head);
        listOperations.print(head);
        head = listOperations.addAtEnd(head, new Integer(1));
        head = listOperations.addAtEnd(head, new Integer(23));
        head = listOperations.addAtEnd(head, new Integer(0));
        head = listOperations.addAtEnd(head, new Integer(22));
        listOperations.print(head);
        head = listOperations.changeHead(head, 0);
        listOperations.print(head);
        head = listOperations.addAtFirst(head, 0);
        head = listOperations.addAtEnd(head, new Integer(22));
        head = listOperations.addAtEnd(head, new Integer(22));
        listOperations.print(head);
        head = listOperations.removeNonDups(head);
        listOperations.print(head);
        head = listOperations.removeDups(head);
        listOperations.print(head);
        head = listOperations.addAtEnd(head, new Integer(9));
        head = listOperations.addAtEnd(head, new Integer(9));
        listOperations.print(head);
        //System.out.println(listOperations.returnNthFromLast(head, 3).data);
        listOperations.print(listOperations.removeKth(head, 3));

    }


    //print linked list
    public void print(Node head) {
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
    public Node addAtEnd(Node head, int data) {
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
        return head;
    }

    //insert at first position
    public Node addAtFirst(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    public Node reverse(Node head) {
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
    public void delete(Node ntd) {
        if (ntd == null) {
            System.out.println("No node to delete");
        } else {
            ntd.data = ntd.next.data;
            ntd.next = ntd.next.next;
        }
    }

    //Delete a node given access to the head
    public Node deleteNode(Node head, Integer obj) {
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
    public Node changeHead(Node head, int value) {
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

    //Write code to delete the numbers that only appear once
    //2->2->3->4->3->1->null returns 2->3-null
    public Node removeNonDups(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        while (head != null) {
            if (countMap.containsKey(head.data)) {
                Integer currentCount = countMap.get(head.data);
                countMap.put(head.data, ++currentCount);
            } else {
                countMap.put(head.data, 1);
            }
            head = head.next;
        }
        Node newHead = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                Node node = new Node(entry.getKey());
                if (newHead == null) {
                    newHead = node;
                } else {
                    newHead.next = node;
                }
            }
        }
        return newHead;
    }

    //Write code to remove duplicates from an unsorted linked list.
    public Node removeDups(Node head) {
        if (head != null) {
            Node current = head;
            Map<Integer, Integer> map = new HashMap<>(); //Set<Integer> more suitable
            map.put(current.data, current.data);

            while (current.next != null) {
                if (map.containsKey(current.next.data)) {
                    //found the dup, leave it out
                    current.next = current.next.next;
                } else {
                    map.put(current.data, current.data);
                    current = current.next;
                }
            }
        }
        return head;
    }

    /*
    * Return 3rd from last element
    *
    * 0-> 22-> 5->20-> 1->23-> 9-> 9-> NULL
    * 0                   3   2   Last>NULL
    *
    * F,S
    * F   S
    * F       S
    * F           S                     //after for ends, F=0, S=2
    *     F           S
    *         F           S
    *             F           S
    *                 F           S
    *                     F           S//after while ends, F=3rd last, S=null
    * */

    public Node returnNthFromLast(Node head, int n) {
        if (head == null) {
            System.out.println("LL length less than " + n);
            return null;
        }

        Node first = head;
        Node second = head;

        //difference between first and second's position should be equal to n
        for (int i = 0; i < n; i++) {
            if (second != null) {
                second = second.next;
            } else {
                System.out.println("LL length less than " + n);
                return null;
            }
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }

        return first;
    }

    //1->2->3->4->null
    public Node findTailNode(Node node) {
        Node tail = null;
        while (node.next != null) {
            node = node.next;
            tail = node;
        }
        return tail;
    }

    public int size(Node head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    //Insert node at given position
    public Node addNodeAt(Node head, Node nta, int pos) {
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            if (temp.next == null) {
                System.out.println("List shorter than the position");
                return head;
            }
            temp = temp.next;
        }
        temp.next = nta;
        return head;
    }

    //Retrieve node at given position
    public Node getNodeAt(Node head, int pos) {
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            if (temp.next == null) {
                System.out.println("List shorter than the position");
                return head;
            }
            temp = temp.next;
        }
        return temp;
    }

    //Reverse a linked list
    public Node reverseMe(Node head) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public Node removeKth(Node head, int k) {
        if (k < 0) {
            return head;
        }
        if (head == null) {
            return head;
        }
        int counter = 0;
        Node fast = head;
        while (counter <= k) {
            if (fast != null) {
                fast = fast.next;
            }
            counter++;
        }
        Node temp = head;
        while (fast != null) {
            fast = fast.next;
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
}
