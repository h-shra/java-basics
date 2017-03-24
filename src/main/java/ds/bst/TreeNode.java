package ds.bst;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;
    boolean visited;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.visited = false;
    }
}