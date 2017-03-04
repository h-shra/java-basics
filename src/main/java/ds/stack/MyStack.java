package ds.stack;

public class MyStack {

    private int topIndex = 0;
    private int stackArray[] = null;


    public MyStack() {
        //maxSize = s;
        stackArray = new int[10];
        topIndex = 0;

    }

    public static void main(String[] args) {
        System.out.println("Class MyStack");
        MyStack ms = new MyStack();
        isEmpty(ms);
        push(ms, 5);
        push(ms, 10);
        push(ms, 15);
        push(ms, 20);
        push(ms, 5);
        print(ms);
        pop(ms);
        print(ms);
    }

    public static boolean isEmpty(MyStack s) {
        if (s.topIndex == 0) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }

    }

    public static void push(MyStack s, int i) {
        s.topIndex = s.topIndex + 1;
        s.stackArray[s.topIndex] = i;
        System.out.println("Pushed element : " + i);
    }

    public static void pop(MyStack s) {
        if (isEmpty(s)) {
            System.out.println("Underflow");
        } else {
            s.topIndex = s.topIndex - 1;
            System.out.println("Popped element : " + s.stackArray[s.topIndex + 1]);
        }
    }

    public static void print(MyStack s) {
        if (isEmpty(s)) {
            System.out.println("Empty stack");
        } else {
            for (int i = 0; i < s.stackArray.length; i++) {
                System.out.print(s.stackArray[i] + "\t");
            }
            System.out.println();
        }
    }

}