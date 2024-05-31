//Problem 7
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
        System.out.println("Test case 1");
        System.out.println("Incidence Matrix:");
        IncidenceMatrixGraph incGraph1 = new IncidenceMatrixGraph(g);
        incGraph1.printIncidenceMatrix();
        // Test Case 2: Directed Graph with Self Loop
        Graph g2 = new Graph(3, true);
        g2.addEdge(0, 1); // 0 -> 1
        g2.addEdge(1, 2); // 1 -> 2
        g2.addEdge(2, 2); // Self loop on vertex 2

        System.out.println("Test Case 2: Directed Graph with Self Loop");
        IncidenceMatrixGraph incGraph2 = new IncidenceMatrixGraph(g2);
        incGraph2.printIncidenceMatrix();

        // Test Case 3: Empty Graph
        Graph g3 = new Graph(5, false); // Undirected

        System.out.println("\nTest Case 3: Empty Graph");
        IncidenceMatrixGraph incGraph3 = new IncidenceMatrixGraph(g3);
        incGraph3.printIncidenceMatrix();

        // Test Case 4: Complete Graph (Directed or Undirected)
        Graph g4 = new Graph(4, true); // Can be directed or undirected for this case

        for (int i = 0; i < g4.numVertices; i++) {
            for (int j = 0; j < g4.numVertices; j++) {
                if (i != j) { // Avoid self-loops
                    g4.addEdge(i, j);
                }
            }
        }

        System.out.println("\nTest Case 4: Complete Graph (Directed or Undirected)");
        IncidenceMatrixGraph incGraph4 = new IncidenceMatrixGraph(g4);
        incGraph4.printIncidenceMatrix();

        // Test Case 5: Disconnected Graph
        Graph g5 = new Graph(6, false); // Undirected
        g5.addEdge(0, 1);
        g5.addEdge(2, 3);
        g5.addEdge(4, 5); // Two separate connected components

        System.out.println("\nTest Case 5: Disconnected Graph");
        IncidenceMatrixGraph incGraph5 = new IncidenceMatrixGraph(g5);
        incGraph5.printIncidenceMatrix();
    }
}
