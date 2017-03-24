package ds.graph;

import java.util.Stack;

/*
* Graph:
*
*       6
*       |
*       |
*       4
*       |
*       |
*       7
*     / | \
*    /  |  \
*   2---1---5
*   |  / \  |
*   | /   \ |
*   |/     \|
*   3       8
*  DFS : 7 1 3 2 5 8 4 6
*  BFS : 7 1 2 4 5 3 8 6
*
* */
public class DfsTraversal extends Traversal {

    public static void main(String[] args) {
        DfsTraversal traversal = new DfsTraversal();
        GraphNode node = traversal.buildGraph();
        System.out.println(traversal.dfsIterativeSearch(node, 6));
        System.out.println("------");
        // TODO: Optimize this to reset boolean without having to rebuild teh graph
        node = traversal.buildGraph(); // to reset visited to false
        traversal.dfsRecursive(node);
    }

    private boolean dfsIterativeSearch(GraphNode startNode, int value) {
        if (startNode == null) {
            return false;
        }

        if (startNode.data == value) {
            System.out.println(startNode.data);
            return true;
        }

        System.out.println(startNode.data);
        startNode.visited = true;
        Stack<GraphNode> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            GraphNode current = stack.pop();
            if (current!=null) {
                for (GraphNode n : current.connectedNodes) {
                    if (n!=null && !n.visited) {
                        System.out.println(n.data);
                        if (n.data == value) {
                            return true;
                        } else {
                            n.visited = true;
                            stack.push(n);
                        }
                    }
                }
            }
        }
        return false;

    }

    public void dfsRecursive(GraphNode startNode) {
        if (startNode == null) {
            return;
        }
        System.out.println(startNode.data);
        startNode.visited = true;
        for (GraphNode node : startNode.connectedNodes) {
            if (!node.visited) {
                dfsRecursive(node);
            }
        }
    }
}