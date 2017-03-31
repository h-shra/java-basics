package ds.graph;

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
public class BfsTraversal extends Traversal {

    public static void main(String[] args) {
        BfsTraversal graph = new BfsTraversal();
        GraphNode node = graph.buildGraph();
        System.out.println(graph.bfsIterativeSearch(node, 0));
        System.out.println("------");
        // TODO: Optimize this to reset boolean without having to rebuild teh graph
        node = graph.buildGraph(); // to reset visited to false
        graph.bfsRecursive(node);
    }

    private void bfsRecursive(GraphNode node) {

    }

    public void bfsIterative(GraphNode startNode) {
        Queue queue = new Queue();
        startNode.visited = true;
        queue.enqueue(startNode);
        while (!queue.isEmpty()) {
            GraphNode current = (GraphNode) queue.dequeue();
            if (current != null) {
                System.out.println(current.data);
                for (GraphNode node : current.connectedNodes) {
                    if (!node.visited) {
                        queue.enqueue(node);
                        node.visited = true;
                    }
                }
            }

        }

    }

    public boolean bfsIterativeSearch(GraphNode startNode, int val) {
        if (startNode == null) {
            return false;
        }
        Queue queue = new Queue();
        startNode.visited = true;
        queue.enqueue(startNode);
        while (!queue.isEmpty()) {
            GraphNode current = (GraphNode) queue.dequeue();
            if (current != null) {
                System.out.println(current.data);
                for (GraphNode node : current.connectedNodes) {
                    if (!node.visited) {
                        if (node.data == val) {
                            System.out.println(val);
                            return true;
                        }
                        queue.enqueue(node);
                        node.visited = true;
                    }
                }
            }

        }
        return false;
    }
}