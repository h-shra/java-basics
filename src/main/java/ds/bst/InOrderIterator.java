package ds.bst;

import java.util.Iterator;

public class InOrderIterator implements Iterator<TreeNode> {

    TreeNode currentNode;
    TreeNode root;

    public InOrderIterator(TreeNode node) {
        root = node;
        currentNode = leftMostNode(node);
    }

    private TreeNode leftMostNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean hasNext() {
        if (currentNode != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public TreeNode next() {
        TreeNode toReturn = currentNode;
        currentNode = successorNoParent(currentNode);
        //currentNode = inOderSuccessor(currentNode);
        return toReturn;
    }

    private TreeNode inOderSuccessor(TreeNode currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.right != null) {
            //return left most child in right sub tree
            return leftMostNode(currentNode.right);
        } else {
            //traverse up to the root that's not fully visited
            //ie, upto that node whose left child is currentNode
            //ie, Go up until we're on left instead of right
            TreeNode current = currentNode;
            TreeNode parent = currentNode.parent;
            while (parent!=null && parent.left != current) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private TreeNode successorNoParent(TreeNode currentNode) {
        if (currentNode.right != null) {
            return leftMostNode(currentNode.right);
        }
        TreeNode successor = null;
        while (root!=null) {
            if (currentNode.data < root.data) {
                successor = root;
                root = root.left;
            } else if (currentNode.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return successor;
    }
}
