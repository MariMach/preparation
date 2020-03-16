import java.util.*;

public class UndirectedGraph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Node " + label;
        }
    }

    // Map is an interface
    // HashMap is an implementation of that interface
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();
    private List<Integer> NumberOfEdgesInEachComponenet = new ArrayList<>();


    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null) {
            throw new IllegalArgumentException();
        }
        if(toNode == null) {
            throw new IllegalArgumentException();
        }
        // undirected graph
        adjacencyList.get(toNode).add(fromNode);
        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (Node source: adjacencyList.keySet()) {
            List<Node> adjacencyNodes = adjacencyList.get(source);
            if(!adjacencyNodes.isEmpty()) {
                System.out.println( source + " is connected to " + adjacencyNodes);
            } else {
                System.out.println( source );
            }
        }
        System.out.println(nodes);
        System.out.println(nodes.values());
        System.out.println(nodes.keySet());
        System.out.println(adjacencyList);
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if(node == null) {
            System.out.println("The Node "+ label +" does not exists ");
            return;
        }
        for(Node n : adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(label, node);
        System.out.println("The Node "+ label +" is now removed ");
        System.out.println(nodes);
        System.out.println(adjacencyList);

    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null) {
            System.out.println("the edge does not exists ");
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
        adjacencyList.get(toNode).remove(fromNode);
        System.out.println("The Edge between "+ from + " and "+  to +" is now removed ");
    }


    // Ranking compute
    public int getTheDegree(String n) {
        Node node = nodes.get(n);
        if(node == null) {
            System.out.println("The node "+ n +" does not exists ");
            return -1;
        }
        return adjacencyList.get(node).size();
    }


    // Depth first Traversal Recursive
    public void traverseDepthFirstRec(String root) {
        Node node = nodes.get(root);
        if(node == null) {
            System.out.println("The node "+ root +" does not exists ");
            return;
        }
        traverseDepthFirstRec(nodes.get(root), new HashSet<>());
    }

    private int traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);
        for(Node node : adjacencyList.get(root)) {
            if(!visited.contains(node)) {
                return 1 + traverseDepthFirstRec(node, visited);
            }
        }
        return 0;
    }

    // Connected Components
    public int connectedComponents() {
        int connectedComponents = 0;
        // Mark all the vertices as not visited
        Set<Node> visited = new HashSet<>();
        for(Node node : nodes.values()) {
            if(!visited.contains(node)) {
                int a = traverseDepthFirstRec(node, visited);
                NumberOfEdgesInEachComponenet.add(a);
                connectedComponents++;
                System.out.println();
            }
        }
        return connectedComponents;
    }


    // For each connected components i should find the minimum number of edges that make it still connected
    // first intuition is to calculate how much vertices is in the connected component
    // So then the minimum edges that makes a connected component still connected is v-1
    // it is like a minimum spanning tree but it is not for a weighted graph
    public void NumberOfEdgesInEachComponenet()
    {
        System.out.println(NumberOfEdgesInEachComponenet);
    }

}
