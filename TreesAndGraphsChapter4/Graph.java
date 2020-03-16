import java.util.*;

// Digraph
public class Graph {

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

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if(fromNode == null) {
            throw new IllegalArgumentException();
        }
        Node toNode = nodes.get(to);
        if(toNode == null) {
            throw new IllegalArgumentException();
        }
        // directed graph
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
        System.out.println("The Edge between "+ from + " and "+  to +" is now removed ");
    }

    // Traversal algorithms
    // Breadth First Traversal BFT (implemented using q queue FILO, we start from a node and we visit all its neighbours before going further)
    // Depth First Traversal DFT (implemented using recursion we start from a node and ts neighbour and its neighbour ... )

    // Depth first Traversal Recursive
    public void traverseDepthFirstRec(String root) {
        Node node = nodes.get(root);
        if(node == null) {
            System.out.println("The node "+ root +" does not exists ");
            return;
        }
        traverseDepthFirstRec(nodes.get(root), new HashSet<>());
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);
        for(Node node : adjacencyList.get(root)) {
            if(!visited.contains(node)) {
                traverseDepthFirstRec(node, visited);
            }
        }
    }

    // Depth first traversal Iterative
    public void traverseDepthFirstItera(String root) {
        Node node = nodes.get(root);
        if(node == null) {
            System.out.println("The node "+ root +" does not exists ");
            return;
        }

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            if(visited.contains(current)) {
                continue;
            }
            System.out.println(current);
            visited.add(current);
            for(Node neighbour : adjacencyList.get(current)) {
                if(!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
    }

    // Breadth first traversal algorithm using a queue
    public void traverseBreadthFirst(String root) {
        Node node = nodes.get(root);
        if(node == null) {
            System.out.println("The node "+ root +" does not exists ");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node current = queue.remove();
            if(visited.contains(current)) {
                continue;
            }
            System.out.println(current);
            visited.add(current);

            for(Node neighbour : adjacencyList.get(current)) {
                if(!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }

        }
    }

    // Topological Sorting
    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for(Node node : nodes.values()) {
            topologicalSort(node, visited, stack);
        }
        List<String> sorted = new ArrayList<>();
        while(!stack.empty()) {
            sorted.add(stack.pop().label);
        }
        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if(visited.contains(node)) {
            return;
        }
        visited.add(node);
        for(Node neighbour : adjacencyList.get(node)) {
            topologicalSort(neighbour, visited, stack);
        }
        stack.push(node);
    }


    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all,
                             Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (Node neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;

            if (visiting.contains(neighbour))
                return true;

            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }


    public int SCCs() {
        int sccs = 0;
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                sccs++;
        }
        return sccs;
    }

    // Breadth first traversal algorithm using a queue
    public void Paths(String root) {
        Node mynode = nodes.get(root);
        if (mynode == null) {
            System.out.println("The node " + root + " does not exists ");
            return;
        }
        for(Node node : nodes.values()) {
            System.out.println("There is a path between " + mynode + " and " + node + " : " + ThereisApath(mynode, node));
            if(ThereisApath(mynode, node)) {
                Set<Node> visited = new HashSet<>();
                visited.add(mynode);
                FindPath(mynode, node,"", visited);
            }
        }
    }

    private void FindPath(Node start, Node end, String path, Set<Node> visited) {
        if(start == end) {
            System.out.println("the path to "+start+" is itself");
            return;
        }
        String newPath = path +  " -> " + start;
        visited.add(start);
        for(Node neighbour : adjacencyList.get(start)) {
            if(!visited.contains(neighbour)) {
                if(neighbour != end) {
                    FindPath(neighbour,end,newPath,visited);
                } else {
                    System.out.println(newPath + " -> " + neighbour);
                }
            }
        }
        visited.remove(start);
    }

    private boolean ThereisApath(Node start, Node end) {
        if(start == end) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            if(visited.contains(current)) {
                continue;
            }
            visited.add(current);
            for(Node n : adjacencyList.get(current)) {
                if(!visited.contains(n)) {
                    if(n == end) {
                        return true;
                    } else {
                        stack.push(n);
                    }
                }
            }
        }
        return false;
    }

    // Ranking compute
    public int getTheOutdegree(String n) {
        Node node = nodes.get(n);
        if(node == null) {
            System.out.println("The node "+ n +" does not exists ");
            return -1;
        }
        return adjacencyList.get(node).size();
    }

    public int getTheIndegree(String n) {
        Node node = nodes.get(n);
        int indegree = 0;
        if(node == null) {
            System.out.println("The node "+ n +" does not exists ");
            return -1;
        }
        for(Node i : adjacencyList.keySet()) {
            if(adjacencyList.get(i).contains(node)) {
                indegree++;
            }
        }
        return indegree;
    }


    public int getTheTotaldegree(String n) {
        return getTheIndegree(n) + getTheOutdegree(n);
    }

}
