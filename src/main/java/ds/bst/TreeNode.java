package ds.bst;

import java.util.ArrayList;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int data;
    //for BFS/DFS
    boolean visited;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.visited = false;
    }

    public TreeNode(int data, TreeNode left, TreeNode right, TreeNode parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.data = data;
        this.visited = false;
    }

    public ArrayList<TreeNode> getChildNodes() {
        ArrayList<TreeNode> children = null;
        if (this != null) {
            children = new ArrayList<>();
            children.add(this.left);
            children.add(this.right);
        }
        return children;
    }
}