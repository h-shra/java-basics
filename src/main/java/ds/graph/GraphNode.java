package ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    Integer data;
    List<GraphNode> connectedNodes;
    boolean visited;

    public GraphNode(Integer data) {
        this.data = data;
        this.visited = false;
        connectedNodes = new ArrayList<GraphNode>();
    }
}