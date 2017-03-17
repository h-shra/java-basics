package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Traversal {

    public static void main(String[] args) {
        Traversal graph = new Traversal();
        Node root = graph.buildGraph();
        graph.dfs(root);
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        root.visited = true;
        //root.connectedNodes.stream().filter(n -> !n.visited).forEach(this::dfs);
        for (Node node : root.connectedNodes) {
            if (!node.visited) {
                dfs(node);
            }
        }
    }

    private Node buildGraph() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        List<Node> connected = new ArrayList<Node>((Arrays.asList(three, five, seven)));
        one.connectedNodes = connected;

        connected = new ArrayList<Node>((Arrays.asList(three, seven)));
        two.connectedNodes = connected;

        connected = new ArrayList<Node>((Arrays.asList(one, two)));
        three.connectedNodes = connected;

        connected = new ArrayList<Node>((Arrays.asList(six, seven)));
        four.connectedNodes = connected;

        connected = new ArrayList<Node>((Arrays.asList(one, seven)));
        five.connectedNodes = connected;

        connected = new ArrayList<Node>((Collections.singletonList(four)));
        six.connectedNodes = connected;

        connected = new ArrayList<Node>((Arrays.asList(one, two, four, five)));
        seven.connectedNodes = connected;

        return seven;
    }

    public class Node {
        List<Node> connectedNodes;
        final Integer data;
        boolean visited;

        public Node(Integer data) {
            this.data = data;
            visited = false;
            connectedNodes = new ArrayList<Node>();
        }
    }
}