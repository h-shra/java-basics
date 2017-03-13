package ds.bst;

import java.util.Arrays;
import java.util.List;

public class BST {

    private static Node root;

    public static void main(String[] args) {
        List<Integer> treeList =
                Arrays.asList(1, 5, 2, 7, 4);
        //Arrays.asList(8, 5, 4, 9, 7, 11, 1, 12, 3, 2);

        BST bst = new BST();
        for (int i : treeList) {
            root = bst.insert(root, i);
        }
        System.out.println("Root : " + root.data);
        System.out.println("preOrder");
        bst.preOrder(root);
        System.out.println("inOrder");
        bst.inOrder(root);
        System.out.println("postOrder");
        bst.postOrder(root);
    }

    /*****************************************************
     *
     *            INSERT
     *
     ******************************************************/

    private Node insert(Node n, int toInsert) {
        if (n == null) {
            return new Node(toInsert);
        }
        if (toInsert < n.data) {
            n.left = insert(n.left, toInsert);
        } else if (toInsert > n.data) {
            n.right = insert(n.right, toInsert);
        }
        return n;
    }

    /*****************************************************
     *
     *            SEARCH
     *
     ******************************************************/
    public boolean search(Node n, int toSearch) {
        if (n == null) {
            return false;
        } else if (n.data == toSearch) {
            return true;
        } else if (toSearch < n.data) {
            return search(n.left, toSearch);
        } else {
            return search(n.right, toSearch);
        }
    }

    /*****************************************************
     *
     *            TRAVERSAL
     *
     ******************************************************/
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            this.left = this.right = null;
        }
    }

}
