

public class Graph {
    protected boolean[][] adjMatrix;
    protected int numVertices;
    protected boolean isDirected;

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
        Graph g = new Graph(4, true); // create a directed graph

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        System.out.print(g.toString());
        g.printDegrees();
        }
    }
