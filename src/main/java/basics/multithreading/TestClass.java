package basics.multithreading;

public class TestClass {
    static int x = 10;

    public static synchronized void decrement() {
        x--;
        System.out.println("decrement : " + x);
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        Thread1 one = new Thread1(tc);
        Thread2 two = new Thread2();

        one.start();
        two.start();
    }

    public synchronized void increment() {
        x++;
        System.out.println("increment : " + x);
    }

}
