//Base Graph Constructor


public class Graph {
    protected boolean[][] adjMatrix;
    protected int numVertices;
    protected boolean isDirected;
    protected int numEdges;

    // Initialize the matrix

    public Graph(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        if (!isDirected) {
            adjMatrix[j][i] = true;
        }
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        if (!isDirected) {
            adjMatrix[j][i] = false;
        }
    }
    // Calculate the degree of each vertex
// Method to compute and print the degree of each vertex
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
    // Print the matrix
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
        Graph graph = new Graph(5, false);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        // Print degrees of each vertex
        graph.printDegrees();
        System.out.println(graph);
        }
    }
