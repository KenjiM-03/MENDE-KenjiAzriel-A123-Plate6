public class Graph {
    protected boolean[][] adjMatrix;
    protected int numVertices;
    protected boolean isDirected;
    protected int numEdges;

    // Initialize the matrix
    public Graph(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        this.adjMatrix = new boolean[numVertices][numVertices];
        this.numEdges = 0;
    }

    // Add edges
    public void addEdge(int i, int j) {
        if (!adjMatrix[i][j]) {
            adjMatrix[i][j] = true;
            if (!isDirected) {
                adjMatrix[j][i] = true;
            }
            numEdges++;
        }
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        if (adjMatrix[i][j]) {
            adjMatrix[i][j] = false;
            if (!isDirected) {
                adjMatrix[j][i] = false;
            }
            numEdges--;
        }
    }

    // Calculate the degree of each vertex
    public void printDegrees() {
        for (int i = 0; i < numVertices; i++) {
            int degree = 0;
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j]) {
                    degree++;
                }
            }
            System.out.println("Vertex " + i + " has degree: " + degree);
        }
    }

    // Print the adjacency matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                s.append((adjMatrix[i][j] ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Basic Undirected Graph
        Graph graph1 = new Graph(5, false);

        // Adding edges
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 4);

        // Print degrees of each vertex
        System.out.println("Test Case 1:");
        graph1.printDegrees();

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        System.out.println(graph1);

        // Create an IncidenceMatrixGraph and print the incidence matrix
        IncidenceMatrixGraph incGraph1 = new IncidenceMatrixGraph(graph1);
        System.out.println("Incidence Matrix:");
        incGraph1.printIncidenceMatrix();

        // Test Case 2: Directed Graph
        Graph graph2 = new Graph(4, true);

        // Adding edges
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 0);

        // Print degrees of each vertex
        System.out.println("Test Case 2:");
        graph2.printDegrees();

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        System.out.println(graph2);

        // Create an IncidenceMatrixGraph and print the incidence matrix
        IncidenceMatrixGraph incGraph2 = new IncidenceMatrixGraph(graph2);
        System.out.println("Incidence Matrix:");
        incGraph2.printIncidenceMatrix();

        // Test Case 3: Undirected Graph with Self-loop
        Graph graph3 = new Graph(3, false);

        // Adding edges
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 2);

        // Print degrees of each vertex
        System.out.println("Test Case 3:");
        graph3.printDegrees();

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        System.out.println(graph3);

        // Create an IncidenceMatrixGraph and print the incidence matrix
        IncidenceMatrixGraph incGraph3 = new IncidenceMatrixGraph(graph3);
        System.out.println("Incidence Matrix:");
        incGraph3.printIncidenceMatrix();
    }
}

