package ds.linkedList;

public class TwoLinkedListOperations {

    LinkedListOperations list = new LinkedListOperations();
    static Node first;
    static Node second;

    public static void main(String[] args) {
        LinkedListOperations listOperations = new LinkedListOperations();
        TwoLinkedListOperations twoLinkedListOperations = new TwoLinkedListOperations();
        first = twoLinkedListOperations.prepareList(new int[]{2, 9});
        second = twoLinkedListOperations.prepareList(new int[]{6, 7, 8});
        Result result = twoLinkedListOperations.calculateSum(first, second);
        System.out.println(result.sum);
        Node mergedHead = twoLinkedListOperations.mergeSortedLists(first, second);
        listOperations.print(mergedHead);
        first = twoLinkedListOperations.prepareList(new int[]{4, 2, 3, 7, 9, 40});
        second = twoLinkedListOperations.prepareList(new int[]{1, 10});
        Node common = listOperations.getNodeAt(first, 3); // Node 7
        second = listOperations.addNodeAt(second, common, listOperations.size(second) - 1);
        System.out.println("Two lists");
        listOperations.print(first);
        System.out.println("--");
        listOperations.print(second);
        System.out.println(twoLinkedListOperations.findIfIntersect(first, second));
        System.out.println(twoLinkedListOperations.findIntersectingNode(first, second).data);
    }

    //Check if given lists intersect
    public boolean findIfIntersect(Node firstList, Node secondList) {
        //Two lists intersect if they have same tail (Object)
        Node firstTail = list.findTailNode(firstList);
        Node secondTail = list.findTailNode(secondList);
        if (firstTail == secondTail) {
            return true;
        }
        return false;
    }

    //Return meeting node for 2 intersecting lists
    public Node findIntersectingNode(Node firstList, Node secondList) {
        Node meetingPoint = null;
        int firstLength = list.size(firstList);
        int secondLength = list.size(secondList);
        int lengthDiff = 0;
        Node biggerList = null;
        Node smallerList = null;
        if (firstLength > secondLength) {
            lengthDiff = firstLength - secondLength;
            biggerList = firstList;
            smallerList = secondList;
        } else {
            lengthDiff = secondLength - firstLength;
            biggerList = secondList;
            smallerList = firstList;
        }
        for (int i = 0; i < lengthDiff; i++) {
            biggerList = biggerList.next;
        }

        while (biggerList != smallerList) {
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }

        meetingPoint = biggerList;

        return meetingPoint;
    }

    public Node mergeSortedLists(Node firstHead, Node secondHead) {
        if (firstHead == null) {
            return secondHead;
        }
        if (secondHead == null) {
            return firstHead;
        }
        Node mergedHead;
        if (firstHead.data < secondHead.data) {
            mergedHead = firstHead;
            firstHead = firstHead.next;
        } else {
            mergedHead = secondHead;
            secondHead = secondHead.next;
        }
        Node temp = mergedHead;
        while (firstHead != null && secondHead != null) {
            if (firstHead.data < secondHead.data) {
                temp.next = firstHead;
                firstHead = firstHead.next;
            } else if (firstHead.data > secondHead.data) {
                temp.next = secondHead;
                secondHead = secondHead.next;
            } else {
                temp.next = secondHead;
                secondHead = secondHead.next;
                firstHead = firstHead.next;
            }
            temp = temp.next;
        }

        if (firstHead == null) {
            temp.next = secondHead;
        } else if (secondHead == null) {
            temp.next = firstHead;
        }

        return mergedHead;
    }

    //Add numbers 789 and 23 represented by LL
    //7-> 8-> 9-> null and 2-> 3-> null;
    public Result calculateSum(Node one, Node two) {
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
