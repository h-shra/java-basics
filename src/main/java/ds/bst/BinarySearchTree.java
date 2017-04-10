package ds.bst;

import java.util.*;

public class BinarySearchTree {

    private static TreeNode root;

    public static void main(String[] args) {
        List<Integer> treeList =
                Arrays.asList(1,5,2,7,4);
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
        System.out.println("Minimal Height BST");
        root = bst.constructMinimalBstFromSortedArray(new int[]{0, 2, 3, 60, 100, 2200});
        System.out.println("Level lists");
        ArrayList<ArrayList<TreeNode>> arrayLists = bst.generateLevelLists(root);
        for (ArrayList<TreeNode> list : arrayLists) {
            System.out.print("Level : ");
            for (TreeNode node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
        System.out.println("Node count : " + bst.size(root, 2));
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

    public TreeNode insert(TreeNode n, int toInsert) {
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
     *            CONSTRUCT Minimal Height BST
     *
     ******************************************************/

    public TreeNode constructMinimalBstFromSortedArray(int[] array) {
        root = constructMinimalBst(array, 0, array.length - 1);
        return root;
    }

    private TreeNode constructMinimalBst(int[] array, int low, int high) {
        if (high < low) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = constructMinimalBst(array, low, mid - 1);
        node.right = constructMinimalBst(array, mid + 1, high);
        return node;
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

    /*****************************************************
     *
     *            BFS TRAVERSAL
     *
     ******************************************************/
    public void bfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        root.visited = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.removeFirst(); //has to be removeFirst
            if (current != null) {
                System.out.println(current.data);
                for (TreeNode node : current.getChildNodes()) {
                    if (node != null && !node.visited) {
                        node.visited = true;
                        queue.add(node);
                    }
                }
            }
        }
    }

    /*****************************************************
     *
     *            DFS TRAVERSAL
     *
     ******************************************************/
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
                for (TreeNode node : current.getChildNodes()) {
                    if (node != null && !node.visited) {
                        node.visited = true;
                        stack.push(node);
                    }
                }
            }
        }
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

    /*****************************************************
     *
     *      Number of Nodes from given level onwards
     *
     ******************************************************/
    public int size(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }

        if (level == 1) {
            return 1;
        }

        ArrayList<TreeNode> currentLevelNodes = new ArrayList<>();
        currentLevelNodes.add(root);
        return size(currentLevelNodes, level, 1, 0);
    }

    private int size(ArrayList<TreeNode> currentLevelNodes, int level, int currentLevel, int nodeCount) {

        while (currentLevelNodes.size() > 0) {
            currentLevel = currentLevel + 1;
            if (currentLevel < level) {
                nodeCount = 0;
            }
            ArrayList<TreeNode> tempList = currentLevelNodes;
            currentLevelNodes = new ArrayList<>();
            for (TreeNode node : tempList) {
                if (node.left != null) {
                    currentLevelNodes.add(node.left);
                    nodeCount++;
                }
                if (node.right != null) {
                    currentLevelNodes.add(node.right);
                    nodeCount++;
                }
            }
        }
        return nodeCount;
    }


    /*****************************************************
     *
     *            List of Nodes at each level
     *
     ******************************************************/
    public ArrayList<ArrayList<TreeNode>> generateLevelLists(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> allLevelLists = new ArrayList<>();
        ArrayList<TreeNode> currentLevelList = new ArrayList<>();
        if (root != null) {
            currentLevelList.add(root);
        }

        while (currentLevelList.size() > 0) {
            allLevelLists.add(currentLevelList); //Add prev level list to result
            ArrayList<TreeNode> tempList = currentLevelList;
            currentLevelList = new ArrayList<>(); //Create next level list
            for (TreeNode node : tempList) {
                if (node.left != null) {
                    currentLevelList.add(node.left);
                }
                if (node.right != null) {
                    currentLevelList.add(node.right);
                }
            }
        }

        return allLevelLists;
    }


}
