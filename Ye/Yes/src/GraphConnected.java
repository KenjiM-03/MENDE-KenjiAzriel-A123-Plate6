public class GraphConnected extends Graph {

    // Constructor to initialize the graph
    public GraphConnected(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    // Checks if the graph is connected
    public boolean isConnected() {
        boolean[] visited = new boolean[numVertices];

        // Start DFS from the first vertex
        dfs(0, visited);

        // Check if all vertices have been visited
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    // Counts the number of connected components
    public int countComponents() {
        boolean[] visited = new boolean[numVertices];
        int count = 0;

        // Check for components in each unvisited vertex
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited);
            }
        }

        return count;
    }

    protected void dfs(int u, boolean[] visited) {
        visited[u] = true;

        for (int v = 0; v < numVertices; v++) {
            if (adjMatrix[u][v]) {
                if (!visited[v]) {
                    dfs(v, visited);
                }
            }
        }
    }


    public static void main(String[] args) {
        // Create an undirected graph
        GraphConnected g = new GraphConnected(4, false);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println("Adjacency Matrix: ");
        System.out.print(g);

        if (g.isConnected()) {
            System.out.println("Graph is connected");
        } else {
            System.out.println("Graph is not connected");
            System.out.println("Number of connected components: " + g.countComponents());
        }
    }
}
