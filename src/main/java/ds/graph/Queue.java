package ds.graph;

public class Queue<Node> {
    QueueNode first, last;

    public void enqueue(Node item) {
        if (first == null) {
            first = new QueueNode(item);
            last = first;
        } else {
            QueueNode newLast = new QueueNode(item);
            last.next = newLast;
            last = newLast;
        }
    }

    public Node dequeue() {
        if (first != null) {
            Node item = first.data;
            first = first.next;
            return item;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (first == null || last == null) {
            return true;
        }
        return false;
    }

    public class QueueNode {
        QueueNode next;
        Node data;

        public QueueNode(Node data) {
            this.data = data;
            this.next = null;
        }
    }
}
