public class adjMatrix {
    static class Graph {
        //Initialize Vertex
        int v;
        int[][] adjMatrix;

        Graph(int v, int[][] adjMatrix) {
            this.v = v;
            this.adjMatrix = adjMatrix;
        }
    }

    static Graph createGraph(int[][] adjMatrix) {
        int v = adjMatrix.length;
        return new Graph(v, adjMatrix);
    }

    // Counts the edges of the adjacency matrix
    static void countEdges(Graph G) {
        int[] frequency = new int[G.v * G.v];
        int k = 0;
        // loops through the pairs of vertices
        for (int i = 0; i < G.v; i++) {
            for (int j = 0; j < G.v; j++) {
                // prints the weight if there is an edge between the vertices
                if (G.adjMatrix[i][j] != 0) {
                    System.out.println("(" + i + ", " + j + "): " + G.adjMatrix[i][j]);
                    frequency[k++] = G.adjMatrix[i][j];
                }
            }
        }
        // Loop through the frequency array and count the number of occurrences of each edge weight
        for (int i = 0; i < k; i++) {
            if (frequency[i] == -1) continue;
            int count = 1;
            for (int j = i + 1; j < k; j++) {
                // If the element has the same value as the current element, increment the counter and mark it as counted
                if (frequency[j] == frequency[i]) {
                    count++;
                    frequency[j] = -1;
                }
            }
            if (frequency[i] != -1) {
                System.out.println("Frequency of edge with weight " + frequency[i] + ": " + count);
            }
        }
    }

    // Main method to test the adjacency matrix
    public static void main(String[] args) {
        // input array
        //Test cases
        int[][] adjMatrix = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        // Creates the graph with the given adjacency matrix
        Graph G = createGraph(adjMatrix);
        countEdges(G);
    }
}
