package main.java.ds.bst;

public class MyBST {

	public static TreeNode myRoot;

	public static void main(String[] args) {
		System.out.println("My Binary Search Tree");
		myRoot = buildBst();
		System.out.println("Preorder");
		preorderTraversal(myRoot);
		System.out.println("Inorder");
		inorderTraversal(myRoot);
		System.out.println("Postorder");		
		postorderTraversal(myRoot);
	}

	private static TreeNode buildBst() {
		TreeNode root = null;
		root = insert(root, 100);
		insert(root, 50);
		insert(root, 50);
		insert(root, 150);
		insert(root, 25);
		insert(root, 75);
		insert(root, 125);
		insert(root, 175);
		insert(root, 110);
		return root;
	}

	// Non-recursive insert O(log(n))
	public static TreeNode insert(TreeNode root, int val) {
		TreeNode current = root;
		if (current == null) {
			current = new TreeNode(val, null, null);
			root = current;
		} else {
			TreeNode temp = null;
			while (current != null) {
				temp = current;
				if (current.getValue() > val) {
					current = current.getLeft();
				} else if (current.getValue() < val) {
					current = current.getRight();
				} else {
					System.out.println("Node "+val +" already present");
					return root;
				}
			}
			if (temp.getValue() > val) {
				temp.setLeft(new TreeNode(val, null, null));
			} else {
				temp.setRight(new TreeNode(val, null, null));
			}
		}
		return root;
	}

	// Non-recursive lookup - O(log(n))
	public static TreeNode lookup(TreeNode root, int val) {
		while (root != null) {
			if (root.getValue() == val) {
				return root;
			}
			if (root.getValue() > val) {
				root = root.getLeft();
			} else {
				root = root.getRight();
			}
		}
		return root;
	}

	// recursive lookup
	public static TreeNode recLookUp(TreeNode root, int val) {
		if (root == null) {
			return root;
		} else {
			if (root.getValue() == val) {
				return root;
			}
			if (root.getValue() > val) {
				return recLookUp(root.getLeft(), val);
			} else {
				return recLookUp(root.getRight(), val);
			}
		}
	}

	// helper method
	private static void printTreeNode(TreeNode node) {
		System.out.println(node.getValue());
	}

	// pre-order traversal O(n)
	public static void preorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		printTreeNode(root);
		preorderTraversal(root.getLeft());
		preorderTraversal(root.getRight());
	}

	// in-order traversal O(n)
	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.getLeft());
		printTreeNode(root);
		inorderTraversal(root.getRight());
	}

	// post-order traversal O(n)
	public static void postorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.getLeft());
		postorderTraversal(root.getRight());
		printTreeNode(root);
	}

	// TODO : non-recursive traversals

}