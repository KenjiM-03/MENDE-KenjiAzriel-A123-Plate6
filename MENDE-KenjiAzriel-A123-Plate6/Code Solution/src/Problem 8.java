//Problem 8
import java.util.Arrays;


class IsomorphicGraph extends Graph {

    public IsomorphicGraph(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    // Check if two graphs are isomorphic
    public static boolean isIsomorphic(Graph g1, Graph g2) {
        if (g1.numVertices != g2.numVertices || g1.isDirected != g2.isDirected) {
            return false;
        }

        // Convert adjacency matrices to string arrays for easier comparison
        String[] g1Rows = new String[g1.numVertices];
        String[] g2Rows = new String[g2.numVertices];

        for (int i = 0; i < g1.numVertices; i++) {
            g1Rows[i] = Arrays.toString(g1.adjMatrix[i]);
            g2Rows[i] = Arrays.toString(g2.adjMatrix[i]);
        }

        // Sort the string arrays
        Arrays.sort(g1Rows);
        Arrays.sort(g2Rows);

        // Compare sorted arrays
        return Arrays.equals(g1Rows, g2Rows);
    }
    public static void main(String[] args) {
        // Create two empty graphs
        IsomorphicGraph graph1 = new IsomorphicGraph(0, false);
        IsomorphicGraph graph2 = new IsomorphicGraph(0, false);

// Check if the graphs are isomorphic
        boolean result = IsomorphicGraph.isIsomorphic(graph1, graph2);
        System.out.println("Graphs are isomorphic: " + result);



    }
}
