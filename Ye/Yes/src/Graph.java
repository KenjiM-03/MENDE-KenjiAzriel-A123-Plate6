//Base Graph Constructor that Constructs and adjacency matrix
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


    }
}

