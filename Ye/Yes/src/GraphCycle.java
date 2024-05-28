import java.util.ArrayList;
import java.util.List;
// Program that checks if the graph is a cycle
public class GraphCycle {
    //V is the #of vertices
    private int V;
    private List<List<Integer>> adj;

    public GraphCycle(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        // Check for cycle in each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, recursionStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycleUtil(int u, boolean[] visited, boolean[] recursionStack) {
        visited[u] = true;
        recursionStack[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v] && hasCycleUtil(v, visited, recursionStack)) {
                return true;
            } else if (recursionStack[v]) {
                return true;
            }
        }

        recursionStack[u] = false;

        return false;
    }

    public static void main(String[] args) {
        GraphCycle g = new GraphCycle(3);
        //Uses Depth first search algorithm to make edges u is the starting point v is the end point
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 2);
       

        if (g.hasCycle()) {
            System.out.println("Graph has a cycle");
        } else {
            System.out.println("Graph does not have a cycle");
        }
    }
}
