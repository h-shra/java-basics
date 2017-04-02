package ds.stack;

public class StackWithMinMax extends StackWithList {
    
    private StackWithList minStack;
    private StackWithList maxStack;
    
    public StackWithMinMax () {
        minStack = new StackWithList();
        maxStack = new StackWithList();
    }
    
    public void push(int value){
        if (value <= min()) { // Note the '=' sign here
            minStack.push(value);
        }
        
        if (value >= max()) {
            maxStack.push(value);
        }
        
        super.push(value);
    }
    
    public int pop() {
        int value = super.pop();
        
        if (value == min()) {
            minStack.pop();
        }
        
        if (value == max()) {
            maxStack.pop();
        }
        
        return value;
    }
    
    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
    
    public int max() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return maxStack.peek();
        }
    }

    public static void main(String[] args) {
        StackWithList s = new StackWithList();
        s.push(5);
        s.push(4);
        s.push(1);
        s.pop();
        s.print();
        s.push(3);
        s.push(8);
        s.push(10);
        s.print();

        StackWithMinMax smm = new StackWithMinMax();
        System.out.println(smm.min());
        smm.push(10);
        smm.push(15);
        smm.push(1);
        System.out.println(smm.min());
        System.out.println(smm.max());
    }
}