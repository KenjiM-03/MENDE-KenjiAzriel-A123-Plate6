import java.util.List;

public class GraphCycle extends Graph {

    public GraphCycle(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i]) // If node is already in recursion stack, cycle detected
            return true;

        if (visited[i]) // If node is already visited, no cycle detected
            return false;

        visited[i] = true; // Mark node as visited
        recStack[i] = true; // Add node to recursion stack

        for (int j = 0; j < numVertices; j++) {
            if (adjMatrix[i][j]) {
                if (isCyclicUtil(j, visited, recStack)) // Recursively check adjacent vertices
                    return true;
            }
        }

        recStack[i] = false; // Remove node from recursion stack after exploration

        return false;
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[numVertices]; // Mark all vertices as not visited
        boolean[] recStack = new boolean[numVertices]; // Initialize recursion stack

        for (int i = 0; i < numVertices; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }


    public static void main(String[] args) {
        GraphCycle g = new GraphCycle(4, false);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.print(g);

        if (g.isCyclic()) {
            System.out.println("Graph has a cycle");
        } else {
            System.out.println("Graph does not have a cycle");
        }
    }
}

