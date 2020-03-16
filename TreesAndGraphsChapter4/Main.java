public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("E");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "E");
        graph.addEdge("B", "E");
        graph.addEdge("B", "A");
        graph.addEdge("E", "A");
        graph.print();
        System.out.println("///////////");
        graph.removeEdge("B", "A");
        graph.print();
        System.out.println("/////////////");
        // graph.removeNode("A");
        graph.print();
        System.out.println("/////////// Traverse the graph using Depth First Recursive");
        graph.traverseDepthFirstRec("C");
        graph.traverseDepthFirstRec("T");
        graph.traverseDepthFirstRec("A");
        graph.traverseDepthFirstRec("E");
        graph.traverseDepthFirstRec("B");
        System.out.println("/////////// Traverse the graph using Depth First Iterative");
        graph.traverseDepthFirstItera("C");
        graph.traverseDepthFirstRec("T");
        graph.traverseDepthFirstItera("A");
        graph.traverseDepthFirstItera("E");
        graph.traverseDepthFirstItera("B");

        System.out.println("/////////// Traverse the graph using Breadth First");
        graph.traverseBreadthFirst("C");
        graph.traverseDepthFirstRec("T");
        graph.traverseBreadthFirst("A");
        graph.traverseBreadthFirst("E");

        System.out.println("/////////// Topological Sort ");
        System.out.println(graph.topologicalSort());
        System.out.println(graph.hasCycle());

        System.out.println(graph.SCCs());


        Graph graph2 = new Graph();
        graph2.addNode("0");
        graph2.addNode("1");
        graph2.addNode("2");
        graph2.addNode("3");
        graph2.addNode("4");
        graph2.addNode("5");
        graph2.addEdge("0", "1");
        graph2.addEdge("2", "0");
        graph2.addEdge("1", "3");
        graph2.addEdge("1", "2");
        graph2.addEdge("2", "3");
        graph2.addEdge("3", "4");
        graph2.addEdge("4", "3");
        graph2.addEdge("5", "4");
        graph2.addEdge("1", "5");

        graph2.print();

        System.out.println("Node 0  has out degree: " + graph2.getTheOutdegree("0"));
        System.out.println("Node 1  has out degree: " + graph2.getTheOutdegree("1"));
        System.out.println("Node 2  has out degree: " + graph2.getTheOutdegree("2"));
        System.out.println("Node 3  has out degree: " + graph2.getTheOutdegree("3"));
        System.out.println("Node 4  has out degree: " + graph2.getTheOutdegree("4"));
        System.out.println("Node 5  has out degree: " + graph2.getTheOutdegree("5"));


        System.out.println("Node 0  has in degree: " + graph2.getTheIndegree("0"));
        System.out.println("Node 1  has in degree: " + graph2.getTheIndegree("1"));
        System.out.println("Node 2  has in degree: " + graph2.getTheIndegree("2"));
        System.out.println("Node 3  has in degree: " + graph2.getTheIndegree("3"));
        System.out.println("Node 4  has in degree: " + graph2.getTheIndegree("4"));
        System.out.println("Node 5  has in degree: " + graph2.getTheIndegree("5"));

        System.out.println("Node 0  has total degree: " + graph2.getTheTotaldegree("0"));
        System.out.println("Node 1  has total degree: " + graph2.getTheTotaldegree("1"));
        System.out.println("Node 2  has total degree: " + graph2.getTheTotaldegree("2"));
        System.out.println("Node 3  has total degree: " + graph2.getTheTotaldegree("3"));
        System.out.println("Node 4  has total degree: " + graph2.getTheTotaldegree("4"));
        System.out.println("Node 5  has total degree: " + graph2.getTheTotaldegree("5"));

        System.out.println(graph2.SCCs());

        graph2.Paths("3");
        graph2.Paths("1");
        graph2.Paths("0");



        System.out.println("Weighted Graph tests /////////////////////////////////");
        System.out.println("");

        WeightedGraph wgraph = new WeightedGraph();
        wgraph.addNode("A");
        wgraph.addNode("B");
        wgraph.addNode("C");
        wgraph.addEdge("A", "B", 5);
        wgraph.addEdge("A", "C", 6);
        wgraph.print();

        System.out.println(" Undirected Graph ");
        System.out.println("  ");

        UndirectedGraph undirectedGraph = new UndirectedGraph();
        undirectedGraph.addNode("1");
        undirectedGraph.addNode("2");
        undirectedGraph.addNode("3");
        undirectedGraph.addNode("4");
        undirectedGraph.addNode("5");


        undirectedGraph.addEdge("1", "2");
        undirectedGraph.addEdge("2", "3");
        undirectedGraph.addEdge("1", "4");

        int connectedComponenets = undirectedGraph.connectedComponents();
        System.out.println(connectedComponenets);
        undirectedGraph.NumberOfEdgesInEachComponenet();

      //  undirectedGraph.print();

        GraphAdjacencyMatrix graphAdjacencyMatrix = new GraphAdjacencyMatrix(5, 4);
        graphAdjacencyMatrix.print();
        graphAdjacencyMatrix.addEdge(2, 3);
        System.out.println(" /// ");
        graphAdjacencyMatrix.print();

    }



}
