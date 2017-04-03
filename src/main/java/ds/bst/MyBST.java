package ds.bst;

public class MyBST {

    public static TreeNode myRoot;

    public static void main(String[] args) {

        System.out.println("My Binary Search Tree");
        // myRoot = buildBst();
        myRoot = buildBstUsingRec();
        /*System.out.println("Preorder");
        preorderTraversal(myRoot);
        System.out.println("Inorder");
        inorderTraversal(myRoot);
        System.out.println("Postorder");
        postorderTraversal(myRoot);*/
        System.out.println("Size of the BST : " + size(myRoot));

        //System.out.println("Size of the BST : " + size(myRoot, 2));

        System.out.println("Max depth of the BST : " + maxDepth(myRoot));
        /*System.out.println("Minimum node in BST : " + min(myRoot).data);
        System.out.println("Maximum node in BST : " + max(myRoot).data);
        System.out.println("Least common ancestor of 110 and 175 : " + leastCommonAncestor(myRoot, 110, 175).data);
        System.out.println("Preorder");
        preorderTraversal(myRoot);
        System.out.println("Is BSTrecursive? : " + isBstRecurse(myRoot));*/
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
            current = new TreeNode(val);
            root = current;
        } else {
            TreeNode temp = null;
            while (current != null) {
                temp = current;
                if (current.data > val) {
                    current = current.left;
                } else if (current.data < val) {
                    current = current.right;
                } else {
                    System.out.println("Node " + val + " already present");
                    return root;
                }
            }
            if (temp.data > val) {
                temp.left = new TreeNode(val);
            } else {
                temp.right = new TreeNode(val);
            }
        }
        return root;
    }

    // recursive insert. Average O(log(n)). Worst O(n)
    public static TreeNode recInsert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.data > val) {
            root.left = recInsert(root.left, val);
        } else if (root.data < val) {
            root.right = recInsert(root.right, val);
        } else {
            System.out.println("Node" + val + "already present");
        }
        return root;
    }

    // Non-recursive lookup - O(log(n))
    public static TreeNode lookup(TreeNode root, int val) {
        while (root != null) {
            if (root.data == val) {
                return root;
            }
            if (root.data > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    // recursive lookup
    public static TreeNode recLookUp(TreeNode root, int val) {
        if (root == null) {
            return root;
        } else {
            if (root.data == val) {
                return root;
            }
            if (root.data > val) {
                return recLookUp(root.left, val);
            } else {
                return recLookUp(root.right, val);
            }
        }
    }

    // helper method
    private static void printTreeNode(TreeNode node) {
        System.out.println(node.data);
    }

    // pre-order traversal O(n)
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        printTreeNode(root);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // in-order traversal O(n)
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        printTreeNode(root);
        inorderTraversal(root.right);
    }

    // post-order traversal O(n)
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        printTreeNode(root);
    }

    // TODO : non-recursive traversals

    // size (no. of nodes) of BST
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return size(root.left) + 1 + +size(root.right);
        }
    }

    public static int size(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        TreeNode tempLeft = root;
        TreeNode tempRight = root;

        int currentLevel = 1;
        while (currentLevel <= level) {
            if (tempLeft != null) {
                tempLeft = tempLeft.left;
            }
            if (tempRight != null) {
                tempRight = tempRight.right;
                currentLevel++;
            }
        }

        int leftSize = size(tempLeft);
        int rightSize = size(tempRight);

        return leftSize + rightSize + 1;
    }

    // max depth - the number of nodes along
    // the longest path from the root to the leaf node
    // O(n)
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

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
            root = current.left;
        }
        return current;
    }

    // minimum node
    public static TreeNode max(TreeNode root) {
        TreeNode current = null;
        while (root != null) {
            current = root;
            root = current.right;
        }
        return current;
    }

    // Least common ancestor
    public static TreeNode leastCommonAncestor(TreeNode root, int val1, int val2) {
        TreeNode current = root;
        while (current != null) {
            int value = current.data;
            if (value > val1 && value > val2) {
                current = current.left;
            }
            if (value < val1 && value < val2) {
                current = current.right;
            } else {
                return current;
            }
        }
        return current;
    }

    // check if given binary tree is BST - for a given node, LEFT = {MIN, CURRENT], RIGHT = [CURRENT, MAX}
    public static boolean isBstRecurse(TreeNode root) {
        return isBstRecurse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBstRecurse(TreeNode node, int minValue, int maxValue) {
        if (node == null) {
            return true; // has to be true
        }
        if ((minValue != Integer.MIN_VALUE && node.data < minValue)
                || (maxValue != Integer.MAX_VALUE && node.data > maxValue)) {
            return false;
        }
        if (!isBstRecurse(node.left, minValue, node.data) ||
                !isBstRecurse(node.right, node.data, maxValue)) {
            return false;
        }
        return true;
    }

    /* This method does not work as it only checks < and > for current node.
    // Returns true for trees like
    //      20
    //     /  \
    //    10  30
    //      \
    /       25
    */
    /*public static boolean isBst(TreeNode root) {
        return (isLeftBst(root) && isRightBst(root));

    }

    private static boolean isRightBst(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode current = root;
        while (current.right != null) {
            if (current.data < current.right.data) {
                current = root.right;
            } else {
                return false;
            }
        }
        return false;
    }

    private static boolean isLeftBst(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode current = root;
        while (current.left != null) {
            if (current.data > current.left.data) {
                current = root.left;
            } else {
                return false;
            }
        }
        return false;
    }*/
}