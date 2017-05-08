package questions;

public class CircularQueue {

    /*Start      0
                / \
      End      3   1
                \ /
                 2
      For 4 successive enqueues
    */

    Integer[] queue;
    int start;
    int end;

    public CircularQueue(int size) {
        //allocate +1 if you fully want to utilize requested size
        queue = new Integer[size+1];
        start = 0;
        end = 0;
    }

    public static void main(String[] args) {
        System.out.println(Character.getNumericValue('a'));
        int i = 'A';
        System.out.println(i);
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue(3); // 3 _ _
        circularQueue.enqueue(2); // 3 2 _
        circularQueue.enqueue(1); // 3 2 1
        circularQueue.print();
        circularQueue.enqueue(0); // Error
        circularQueue.dequeue();
        circularQueue.enqueue(0); // 0(end) 2(start) 1
        circularQueue.print();
    }
    private void print() {
        for (Integer i: queue) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Q empty");
            return null;
        } else {
            Integer item = queue[start];
            queue[start] = null;
            start = (start + 1) % queue.length;
            return item;
        }
    }

    private void enqueue(int item) {
        if (isFull()) {
            System.out.println("Circular Q full. Cannot insert " + item);
        } else {
            queue[end] = item;
            end = (end + 1) % queue.length;
        }

    }

    private boolean isEmpty() {
        if (start == end) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if (start == (end + 1) % queue.length) {
            return true;
        }
        return false;
    }


}
