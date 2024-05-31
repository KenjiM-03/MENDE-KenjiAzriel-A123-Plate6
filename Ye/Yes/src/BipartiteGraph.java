import java.util.LinkedList;
import java.util.Queue;

class BipartiteGraph extends Graph {

    public BipartiteGraph(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    // Check if the graph is bipartite using BFS
    public boolean isBipartite() {
        int[] colors = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            colors[i] = -1; // Uncolored
        }

        // Check each component of the graph
        for (int i = 0; i < numVertices; i++) {
            if (colors[i] == -1) {
                if (!isBipartiteComponent(i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper method to check if Bipartite for a component using BFS
    private boolean isBipartiteComponent(int src, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        colors[src] = 0; // Start coloring src with 0

        while (!queue.isEmpty()) {
            int u = queue.poll();

            // Check all adjacent vertices
            for (int v = 0; v < numVertices; v++) {
                if (adjMatrix[u][v]) {
                    if (colors[v] == -1) {
                        // Color with the opposite color
                        colors[v] = 1 - colors[u];
                        queue.add(v);
                    } else if (colors[v] == colors[u]) {
                        // If adjacent vertices have the same color, it's not bipartite
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //Test Cases
    public static void main(String[] args) {
        BipartiteGraph bipartiteGraph = new BipartiteGraph(6, false);

        // Adding edges to the bipartite graph
        bipartiteGraph.addEdge(0, 1);
        bipartiteGraph.addEdge(0, 3);
        bipartiteGraph.addEdge(2, 1);
        bipartiteGraph.addEdge(2, 5);
        bipartiteGraph.addEdge(4, 3);
        bipartiteGraph.addEdge(4, 5);

        // Print the adjacency matrix
        System.out.println(bipartiteGraph);

        // Check if the graph is bipartite
        System.out.println("Is the graph bipartite? " + bipartiteGraph.isBipartite());
    }
}
