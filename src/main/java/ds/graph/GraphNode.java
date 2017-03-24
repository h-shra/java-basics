package ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    List<GraphNode> connectedNodes;
    final Integer data;
    boolean visited;

    public GraphNode(Integer data) {
        this.data = data;
        this.visited = false;
        connectedNodes = new ArrayList<GraphNode>();
    }
}