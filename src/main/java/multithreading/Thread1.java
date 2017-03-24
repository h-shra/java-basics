package multithreading;

public class Thread1 extends Thread {
    TestClass test;

    public Thread1(TestClass testC) {
        this.test = testC;
    }

    @Override
    public void run() {
        test.increment();
    }

}
