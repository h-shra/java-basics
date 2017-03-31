package ds.bst;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    int data;
    //for BFS/DFS
    boolean visited;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.visited = false;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.visited = false;
    }
}