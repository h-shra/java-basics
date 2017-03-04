package ds.linkedList;

public class MyLinkedList {

	protected static Node head = null;
	protected static int nodeCount = 0;
	
	public static void main(String [] args) {
		int data = 5;
		head = deleteNode( data);
		addAtEnd(data);
		data = 0;
		addAtFirst(data);
		print();
		data = 10;
		addAtEnd(data);
		print();
		head = deleteNode( data);
		print();
		reverse();
		print();
	}
	
	
	//print linked list
	public static void print () {
		if (head == null) {
			System.out.println("LL empty");
		} else {
			Node currNode = head;
			while (currNode != null) {
				System.out.println(currNode.data);
				currNode = currNode.next;
			}
		}
	
	}
		
	//insert at the end    
	public static void addAtEnd (int data) {
		if ( head == null) {
			head = new Node (data);
		} else {
			Node currentNode = head;
			//traverse till end of linked list
			while (currentNode.next  != null ) {
				currentNode = currentNode.next;
			}
			currentNode.next = new Node (data);
		}
		nodeCount ++;
	}
	
	//insert at first position
	public static void addAtFirst (int data) {
		if ( head == null) {
			head = new Node (data);
		} else {
			Node newHead = new Node(data);
			newHead.next = head;
			head = newHead;
		}
		nodeCount++;
	}
	/*
	//insert at given position
	public static void addAtPosition (int n, dataect data) {
		Node node = head;
		//traverse till end of linked list
		while (currentNode.next  != null ) {
			currentNode = currentNode.next;
		}
	} */
	
/*	public Node delete (int dataToDelete) {
		Node temp = head;
		if  (temp == null || temp.data == (dataToDelete) ) {
			head = head.next;
			return head;
		} else {
		Node ntd = new Node(dataToDelete);	
			while (temp != null) {
				System.out.println(temp.data);
				if (temp.next.equals(ntd)){
					temp.next = temp.next.next;
					return head;
				} else {
					temp = temp.next;
				}
			}
			System.out.println("dataect not found in LL.");
			return head;
		}
	} */
	
	public static Node deleteNode(int dataToDelete) {
		
		if(head == null) {
			System.out.println("LL empty. Nothing to delete.");
			return head;
		}
	
		Node temp = head;
		
		if(temp.data == dataToDelete) {
			head = temp.next;
		}
		
		while(temp.next != null) {
			if(temp.next.data == dataToDelete) {
				temp.next = temp.next.next;
				return head;
			}
			temp = temp.next;
		}
		System.out.println("data not found in LL.");
		return head;
	}
	
	public static Node reverse () {
		Node reversedPart = null;
		Node current = head;
		while (current != null) {
		Node next = current.next;
			current.next = reversedPart;
			reversedPart = current;
			current = next;
		}
	head = reversedPart;

	return head;
	}
	
	

}
