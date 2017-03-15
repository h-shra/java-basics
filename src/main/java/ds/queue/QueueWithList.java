package ds.queue;

public class QueueWithList {

    QueueNode first, last;

    public class QueueNode {
        QueueNode next;
        int data;

        public QueueNode(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public void enqueue(int item) {
        if(first == null){
            first = new QueueNode(item);
            last = first;
        } else {
            QueueNode newLast = new QueueNode(item);
            last.next = newLast;
            last = newLast;
        }
    }

    public int dequeue() {
        if (first != null) {
            int item = first.data;
            first = first.next;
            return item;
        } else {
            return -1;
        }
    }

    public void print() {
        if (first == null || last == null) {
            System.out.println("Empty Queue");
        } else {
            QueueNode temp = first;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }

        }
    }
}
