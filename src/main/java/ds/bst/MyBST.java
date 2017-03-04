package ds.bst;

public class MyBST {

	public static TreeNode myRoot;

	public static void main(String[] args) {
		System.out.println("My Binary Search Tree");
		// myRoot = buildBst();
		myRoot = buildBstUsingRec();
		System.out.println("Preorder");
		preorderTraversal(myRoot);
		System.out.println("Inorder");
		inorderTraversal(myRoot);
		System.out.println("Postorder");
		postorderTraversal(myRoot);
		System.out.println("Size of the BST : " + size(myRoot));
		System.out.println("Max depth of the BST : " + maxDepth(myRoot));
		System.out.println("Minimum node in BST : " + min(myRoot).getValue());
		System.out.println("Maximum node in BST : " + max(myRoot).getValue());
		System.out
				.println("Least common ancestor of 110 and 175 : " + leastCommonAncestor(myRoot, 110, 175).getValue());
		System.out.println("Preorder");
		preorderTraversal(myRoot);
		System.out.println("Is BST? : " +isBST(myRoot));

	}

	private static TreeNode buildBstUsingRec() {
		TreeNode root = null;
		root = recInsert(root, 100);
		recInsert(root, 50);
		recInsert(root, 50);
		recInsert(root, 150);
		recInsert(root, 25);
		recInsert(root, 75);
		recInsert(root, 125);
		recInsert(root, 175);
		recInsert(root, 110);
		return root;
	}

	@SuppressWarnings("unused")
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
					System.out.println("Node " + val + " already present");
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

	// recursive insert. Average O(log(n)). Worst O(n)
	public static TreeNode recInsert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val, null, null);
		}
		if (root.getValue() > val) {
			root.setLeft(recInsert(root.getLeft(), val));
		} else if (root.getValue() < val) {
			root.setRight(recInsert(root.getRight(), val));
		} else {
			System.out.println("Node" + val + "already present");
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

	// size (no. of nodes) of BST
	public static int size(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return size(root.getLeft()) + 1 + +size(root.getRight());
		}
	}

	// max depth - the number of nodes along
	// the longest path from the root to the leaf node
	// O(n)
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lDepth = maxDepth(root.getLeft());
			int rDepth = maxDepth(root.getRight());

			if (lDepth > rDepth) {
				return lDepth + 1;
			} else {
				return rDepth + 1;
			}
		}
	}

	// minimum node
	public static TreeNode min(TreeNode root) {
		TreeNode current = null;
		while (root != null) {
			current = root;
			root = current.getLeft();
		}
		return current;
	}

	// minimum node
	public static TreeNode max(TreeNode root) {
		TreeNode current = null;
		while (root != null) {
			current = root;
			root = current.getRight();
		}
		return current;
	}

	// Least common ancestor
	public static TreeNode leastCommonAncestor(TreeNode root, int val1, int val2) {
		TreeNode current = root;
		while (current != null) {
			int value = current.getValue();
			if (value > val1 && value > val2) {
				current = current.getLeft();
			}
			if (value < val1 && value < val2) {
				current = current.getRight();
			} else {
				return current;
			}
		}
		return current;
	}

	// check if given binary tree is BST
	public static boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true; //has to be true
		} else {
			boolean leftBST = isBST(root.getLeft(), minValue, root.getValue());
			if(!leftBST) return false;
			boolean rightBST = isBST(root.getRight(), root.getValue(), maxValue);
			if(!rightBST) return false;
		}
		return true;
	}

	// BFS

	// DFS
}