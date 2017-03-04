package ds.bst;

public class TreeNode {

	private TreeNode left;
	private TreeNode right;
	private int value;
	
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public int getValue() {
		return value;
	}

	public void setLeft(TreeNode treeNode) {
		this.left = treeNode;
	}
	
	public void setRight(TreeNode treeNode) {
		this.right = treeNode;
	}

}