package ds.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    private static TreeNode root;

    public static void main(String[] args) {
        List<Integer> treeList =
                Arrays.asList(1, 5, 2, 7, 0);
                //Arrays.asList(8, 5, 4, 9, 7, 11, 1, 12, 3, 2);

        BinarySearchTree bst = new BinarySearchTree();
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
        System.out.println("BFS Traversal");
        bst.bfsTraversal(root);
        resetState(root);
        System.out.println("DFS Traversal");
        bst.dfsTraversal(root);
    }

    private static void resetState(TreeNode root) {
        if (root != null) {
            resetState(root.left);
            root.visited = false;
            resetState(root.right);
        }
    }

    /*****************************************************
     *
     *            INSERT
     *
     ******************************************************/

    private TreeNode insert(TreeNode n, int toInsert) {
        if (n == null) {
            return new TreeNode(toInsert);
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
     *            SEARCH using BST Property
     *
     ******************************************************/
    public boolean search(TreeNode n, int toSearch) {
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
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public void bfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        root.visited = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.removeFirst(); //has to be removeFirst
            if (current != null) {
                System.out.println(current.data);
                for (TreeNode node : getChildNodes(current)) {
                    if (node!= null && !node.visited) {
                            node.visited = true;
                            queue.add(node);
                    }
                }
            }
        }

    }

    public void dfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        root.visited = true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode current = stack.pop();
            if (current != null) {
                System.out.println(current.data);
                for (TreeNode node : getChildNodes(current)) {
                    if (node != null && !node.visited) {
                        node.visited = true;
                        stack.push(node);
                    }
                }
            }
        }
    }

    private ArrayList<TreeNode> getChildNodes(TreeNode node) {
        ArrayList<TreeNode> children = new ArrayList<>();
        children.add(node.left);
        children.add(node.right);
        return children;
    }

    /*****************************************************
     *
     *            Size
     *
     ******************************************************/
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }
}
