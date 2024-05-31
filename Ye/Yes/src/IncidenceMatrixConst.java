class IncidenceMatrixGraph extends Graph {

    public IncidenceMatrixGraph(Graph graph) {
        super(graph.numVertices, graph.isDirected);
        this.adjMatrix = graph.adjMatrix;
        this.numEdges = calculateNumEdges();
    }

    // Calculate the number of edges in the graph
    private int calculateNumEdges() {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = (isDirected ? 0 : i); j < numVertices; j++) {
                if (adjMatrix[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Convert to and print the incidence matrix
    public void printIncidenceMatrix() {
        boolean[][] incMatrix = new boolean[numVertices][numEdges];
        int edgeIndex = 0;

        for (int i = 0; i < numVertices; i++) {
            for (int j = (isDirected ? 0 : i); j < numVertices; j++) {
                if (adjMatrix[i][j]) {
                    incMatrix[i][edgeIndex] = true;
                    if (!isDirected && i != j) {
                        incMatrix[j][edgeIndex] = true;
                    }
                    edgeIndex++;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < edgeIndex; j++) {
                s.append((incMatrix[i][j] ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        System.out.println(s.toString());
    }
    public static void main(String[] args) {
        // Test Case 1: Undirected Graph
        Graph g = new Graph(4, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Incidence Matrix:");
        IncidenceMatrixGraph incGraph1 = new IncidenceMatrixGraph(g);
        incGraph1.printIncidenceMatrix();
    }
}
