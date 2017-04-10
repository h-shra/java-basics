package ds.linkedList;

public class DoubleLinkedNode {
    public DoubleLinkedNode next;
    public DoubleLinkedNode prev;
    public int value;
    public int key;

    public DoubleLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
