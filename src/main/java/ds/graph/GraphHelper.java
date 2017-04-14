package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GraphHelper {
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

    GraphNode buildGraph() {
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        GraphNode five = new GraphNode(5);
        GraphNode six = new GraphNode(6);
        GraphNode seven = new GraphNode(7);
        GraphNode eight = new GraphNode(8);

        //TODO - Create a a better constructor to reduce this code block
        List<GraphNode> connected = new ArrayList<GraphNode>((Arrays.asList(three, five, seven, eight)));
        one.connectedNodes = connected;

        connected = new ArrayList<GraphNode>((Arrays.asList(three, seven)));
        two.connectedNodes = connected;

        connected = new ArrayList<GraphNode>((Arrays.asList(one, two)));
        three.connectedNodes = connected;

        connected = new ArrayList<GraphNode>((Arrays.asList(six, seven)));
        four.connectedNodes = connected;

        connected = new ArrayList<GraphNode>((Arrays.asList(one, seven, eight)));
        five.connectedNodes = connected;

        connected = new ArrayList<GraphNode>((Collections.singletonList(four)));
        six.connectedNodes = connected;

        connected = new ArrayList<GraphNode>((Arrays.asList(one, two, four, five)));
        seven.connectedNodes = connected;

        connected = new ArrayList<GraphNode>((Arrays.asList(one, five)));
        eight.connectedNodes = connected;

        return seven;
    }
}
