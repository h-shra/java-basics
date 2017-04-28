package basics.multithreading;

public class Thread2 extends Thread {
    public void run() {
        TestClass.decrement();
    }

}
