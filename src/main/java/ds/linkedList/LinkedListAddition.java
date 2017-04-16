package ds.linkedList;

public class LinkedListAddition {

    LinkedListOperations list = new LinkedListOperations();
    static Node firstHead;
    static Node secondHead;

    public static void main(String[] args) {
        LinkedListAddition test = new LinkedListAddition();
        firstHead = test.prepareList(new int[]{2, 3});
        secondHead = test.prepareList(new int[]{6, 7, 8});
        Result result = test.calculateSum(firstHead, secondHead);
        System.out.println(result.sum);
    }

    private Result calculateSum(Node one, Node two) {
        int sizeOne = list.size(one);
        int sizeTwo = list.size(two);

        // Add leading zeros to the smaller list
        if (sizeOne < sizeTwo) {
            one = addLeadingNodes(one, sizeTwo - sizeOne);
        } else if (sizeTwo < sizeOne) {
            two = addLeadingNodes(two, sizeOne - sizeTwo);
        }
        return addDigits(one, two);
    }

    private Node addLeadingNodes(Node head, int numberOfNodes) {
        Node temp = head;
        for (int i = 0; i < numberOfNodes; i++) {
            Node leadNode = new Node(0);
            leadNode.next = temp;
            temp = leadNode;
        }
        return temp;
    }

    private Result addDigits(Node nodeFromFirst, Node nodeFromSecond) {
        if (nodeFromFirst == null && nodeFromSecond == null) {
            return new Result();
        }

        Result result = addDigits(nodeFromFirst.next, nodeFromSecond.next);

        int sum = (nodeFromFirst.data + nodeFromSecond.data + result.carry) % 10;
        int carry = (nodeFromFirst.data + nodeFromSecond.data + result.carry) / 10;
        result.sum = sum + result.sum;
        result.carry = carry;
        return result;
    }

    private Node prepareList(int[] numberArray) {
        Node head = new Node(numberArray[0]);
        Node temp = head;
        for (int i = 1; i < numberArray.length; i++) {
            temp.next = new Node(numberArray[i]);
            temp = temp.next;
        }
        return head;
    }

    private class Result {
        String sum = "";
        int carry;
    }

}
