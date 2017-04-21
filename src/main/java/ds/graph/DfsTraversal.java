package ds.graph;

import java.util.Stack;

/*
* GraphHelper:
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
public class DfsTraversal {

    public static void main(String[] args) {

        GraphHelper graphHelper = new GraphHelper();
        GraphNode node = graphHelper.buildGraph();
        DfsTraversal dfsTraversal = new DfsTraversal();
        System.out.println(dfsTraversal.dfsIterativeSearch(node, 6));
        System.out.println("------");
        // TODO: Optimize this to reset boolean without having to rebuild the graph
        node = graphHelper.buildGraph(); // to reset visited to false
        dfsTraversal.dfsRecursive(node);
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
            if (current != null) {
                for (GraphNode n : current.connectedNodes) {
                    if (n != null && !n.visited) {
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
            if (node != null && !node.visited) {
                dfsRecursive(node);
            }
        }
    }
}