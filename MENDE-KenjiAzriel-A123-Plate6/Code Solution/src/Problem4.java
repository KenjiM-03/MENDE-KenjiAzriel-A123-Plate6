public class Problem4 extends Graph {
    public Problem4(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    // Method to print the degrees of each vertex
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

    public static void main(String[] args) {
        // Test Case 1: Basic Undirected Graph
        Problem4 graph1 = new Problem4(5, false);

        // Adding edges
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 4);

        // Print degrees of each vertex
        System.out.println("Test Case 1:");
        System.out.println(graph1);
        graph1.printDegrees();

        // Test Case 2: Directed Graph
        Problem4 graph2 = new Problem4(5, true);

        // Adding directed edges (arrows indicate direction)
        graph2.addEdge(0, 1); // 0 -> 1
        graph2.addEdge(0, 2); // 0 -> 2
        graph2.addEdge(1, 3); // 1 -> 3
        graph2.addEdge(2, 4); // 2 -> 4

        // Print degrees of each vertex (considering outgoing edges)
        System.out.println("Test Case 2:");
        System.out.println(graph2);
        graph2.printDegrees();

        // Test Case 3: Empty Graph
        Problem4 graph3 = new Problem4(3, false);

        // No edges added

        // Print degrees of each vertex
        System.out.println("Test Case 3:");
        System.out.println(graph3);
        graph3.printDegrees();

        // Test Case 4: Graph with Self-loop
        Problem4 graph4 = new Problem4(5, false);

        // Adding edges
        graph4.addEdge(0, 1);
        graph4.addEdge(2, 3);
        graph4.addEdge(4, 4); // Self-loop

        // Print degrees of each vertex
        System.out.println("Test Case 4:");
        System.out.println(graph4);
        graph4.printDegrees();

        // Test Case 5: Complete Graph
        Problem4 graph5 = new Problem4(4, true); // Can be directed or undirected for this case

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
        graph5.printDegrees();
    }
}
