import java.util.ArrayList;
import java.util.List;

public class GraphConnected {
    private int V;
    
    private List<List<Integer>> adj;
    // Initializes an empty graph with V vertices
    public GraphConnected(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }
    // adds an undirected edge beteen vertices
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
   //Checks if the graph is connected
    public boolean isConnected() {
        boolean[] visited = new boolean[V];

        // Start DFS from the first vertex
        dfs(0, visited);

        // Check if all vertices have been visited
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public int countComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;

        // Check for components in each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited);
            }
        }

        return count;
    }

    private void dfs(int u, boolean[] visited) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        // This is used to modify the graph
        GraphConnected g = new GraphConnected(6);
        g.addEdge(1, 5);
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        if (g.isConnected()) {
            System.out.println("Graph is connected");
        } else {
            System.out.println("Graph is not connected");
            System.out.println("Number of connected components: " + g.countComponents());
        }
        
    }
}
