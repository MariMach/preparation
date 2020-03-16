public class GraphAdjacencyMatrix {

    // number of vertices
    private int v = 0;

    //  number of edges
    private int e = 0;

    // Adjacency matrix
    private int[][] adj;

    public GraphAdjacencyMatrix(int v, int e) {
        this.v = v;
        this.e = e;
        this.adj = new int[v][v];
    }


    // Directed graph
    public void addEdge(int from, int to) {
           this.adj[from][to] = 1;
    }

    public void print() {
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}
