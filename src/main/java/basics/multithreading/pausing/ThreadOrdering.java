package basics.multithreading.pausing;

public class ThreadOrdering {
    public static void main(String[] args) {
        ThreadOrdering ordering = new ThreadOrdering();
        ordering.printThreadNumbers();
    }

    private void printThreadNumbers() {
        Thread1 thread1 = new Thread1();
        thread1.setName("One");

        Thread2 thread2 = new Thread2();
        thread2.setName("Two");

        thread1.start();
        try {
            /*synchronized (this) {
                this.wait();//gonna hang forever until main thread is notified or interrupted.
            }*/
            thread1.join();//pauses only until thread1 terminates.
            System.out.println("This only prints after thread1 terminates");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }
}
