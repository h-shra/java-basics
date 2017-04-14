package ds.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphCloner {

    public static void main(String[] args) {
        GraphCloner graphCloner = new GraphCloner();
        GraphHelper graphHelper = new GraphHelper();
        GraphNode root = graphHelper.buildGraph();
        GraphNode clonedRoot = graphCloner.clone(root);
        // TODO: Optimize this to reset boolean without having to rebuild the graph
        root = graphHelper.buildGraph();
        System.out.print("");
    }

    private GraphNode clone(GraphNode root) {
        // Use modified BFS/DFS where every visited node, is entered into Map<GraphNode, GraphNode>

        if (root == null) {
            return root;
        }

        LinkedList<GraphNode> queue = new LinkedList<>();
        HashMap<GraphNode, GraphNode> map = new HashMap<>();

        // Add to Q and mark as visited for upcoming for loop
        root.visited = true;
        queue.add(root);

        // Keep only visited nodes in map
        GraphNode clonedRoot = new GraphNode(root.data);
        map.put(root, clonedRoot);

        while (!queue.isEmpty()) {
            final GraphNode prevNode = queue.removeFirst();
            if (prevNode != null) {
                GraphNode prevNodeClone = map.get(prevNode);
                for (GraphNode node : prevNode.connectedNodes) {
                    if (node != null && !node.visited) {
                        node.visited = true;
                        queue.add(node);
                        final GraphNode clonedNode = new GraphNode(node.data);
                        // update the connectedNodes for prev's cloned node
                        prevNodeClone.connectedNodes.add(clonedNode);
                        // add current connected node with its clone in map
                        map.put(node, clonedNode);
                    }
                }
            }
        }
        return clonedRoot;
    }

}
