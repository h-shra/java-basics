package ds.queue;

import ds.linkedList.Node;

class Queue {
    Node first, last;

    public void enqueue(int item) {
        if(first == null){
            first = new Node(item);
            last = first;
        } else {
            Node newLast = new Node(item);
            last.next = newLast;
            last = newLast;
        }
    }

    public Integer dequeue() {
        if (first != null) {
            int item = first.data;
            first = first.next;
            return item;
        } else {
            return null;
        }
    }
}
