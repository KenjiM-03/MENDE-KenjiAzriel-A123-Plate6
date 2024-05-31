//Base Graph Constructor that Constructs and adjacency matrix
//Problem 6
class Graph {
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
        System.out.println(graph1);
        Graph graph2 = new Graph(5, true);

// Adding directed edges (arrows indicate direction)
        graph2.addEdge(0, 1); // 0 -> 1
        graph2.addEdge(0, 2); // 0 -> 2
        graph2.addEdge(1, 3); // 1 -> 3
        graph2.addEdge(2, 4); // 2 -> 4

// Print degrees of each vertex (considering outgoing edges)
        System.out.println("Test Case 2:");
        System.out.println(graph2);
        Graph graph3 = new Graph(3, false);

// No edges added

// Print degrees of each vertex
        System.out.println("Test Case 3:");
        System.out.println(graph3);
        Graph graph4 = new Graph(5, false);

// Adding edges
        graph4.addEdge(0, 1);
        graph4.addEdge(2, 3);
        graph4.addEdge(4, 4); // Self-loop

// Print degrees of each vertex
        System.out.println("Test Case 4:");
        System.out.println(graph4);
        Graph graph5 = new Graph(4, true); // Can be directed or undirected for this case

// Add edges to create a complete graph (all vertices connected to each other)
        for (int i = 0; i < graph5.numVertices; i++) {
            for (int j = 0; j < graph5.numVertices; j++) {
                if (i != j) { // Avoid self-loops
                    graph5.addEdge(i, j);
                }
            }
        }

// Print degrees of each vertex
        System.out.println("Test Case 5:");
        System.out.println(graph5);




    }
}

