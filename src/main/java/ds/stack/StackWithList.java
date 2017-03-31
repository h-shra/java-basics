package ds.stack;

public class StackWithList {

    StackNode top = null;

    public static void main(String[] args) {
        StackWithList stack = new StackWithList();
        System.out.println(stack.isEmpty());
        stack.push(6);
        stack.push(3);
        stack.push(5);
        stack.push(100);
        stack.print();
        System.out.println(stack.peek());
        System.out.println("-----");
        stack.print();
        System.out.println(stack.pop());
        System.out.println("-----");
        stack.print();
    }

    public void push(int i) {
        if (top == null) {
            StackNode firstOne = new StackNode(i);
            top = firstOne;
        } else {
            StackNode newTop = new StackNode(i);
            newTop.next = top;
            top = newTop;
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Cannot pop from empty stack");
            return -1; //error
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Empty stack");
            return -1; //error
        }
        return top.data;
    }

    public void print() {
        if (top == null) {
            System.out.println("Empty stack");
        } else {
            StackNode temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    private class StackNode {
        StackNode next;
        int data;

        public StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
