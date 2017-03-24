package questions;

public class FixedSizeQ {

    int[] queue = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    int start = 0;
    int end = 0;

    // S
    // E
    // {0, 0, 0}
    // enqueue 9
    // S E
    // {9, 0, 0}
    // enqueue 5
    // S E
    // {9, 5, 0}
    // enqueue 1
    // S E
    // {9, 5, 1}
    public static void main(String[] args) {
        FixedSizeQ fixedQueue = new FixedSizeQ();
        fixedQueue.enqueue(5);//5 MAX MAX
        fixedQueue.enqueue(2);//5 2 MAX
        fixedQueue.enqueue(6);//5 2 6
        fixedQueue.enqueue(2);//error
        fixedQueue.print();
        fixedQueue.dequeue();//MAX 2 6
        fixedQueue.print();
        fixedQueue.enqueue(2);// 2 6 2
        fixedQueue.print();//
        fixedQueue.enqueue(55);//error
        fixedQueue.dequeue();
        fixedQueue.dequeue();
        fixedQueue.dequeue();
        fixedQueue.enqueue(55);
        fixedQueue.dequeue();
        fixedQueue.enqueue(2);
        fixedQueue.enqueue(6);
        fixedQueue.enqueue(2);
        fixedQueue.print();
    }

    public void enqueue(int value) {
        if (end != queue.length && queue[end]==Integer.MAX_VALUE) {
            queue[end] = value;
            end++;
        } else if (end == queue.length) {
            end = 0;
            while (queue[end] != Integer.MAX_VALUE) {
                end++;
                if (end == queue.length) {
                    System.out.println("Q full");
                    return;
                }
            }
            queue[end] = value;
            end++;
        } else {
            System.out.println("Q full");
        }
    }

    public int dequeue() {
        if (start == queue.length) {
            start = 0;
            while (queue[start] != Integer.MAX_VALUE) {
                int item = queue[start];
                queue[start] = Integer.MAX_VALUE;
                start++;
                return item;
            }

        }
        int item = queue[start];
        queue[start] = Integer.MAX_VALUE;
        start++;
        return item;
    }

    public void print() {
        System.out.println("Start:" + start + " End:" +(end-1));
        for (int value : queue) {
            System.out.println(value);
        }
    }

}
