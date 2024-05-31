//Problem 3
class GraphCycle extends Graph {

    public GraphCycle(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, int parent) {
        if (recStack[i]) // If node is already in recursion stack, cycle detected
            return true;

        if (visited[i]) // If node is already visited and not the parent, cycle detected for undirected graphs
            return i != parent;

        visited[i] = true; // Mark node as visited
        recStack[i] = true; // Add node to recursion stack

        for (int j = 0; j < numVertices; j++) {
            if (adjMatrix[i][j]) {
                if (isCyclicUtil(j, visited, recStack, i)) // Recursively check adjacent vertices
                    return true;
            }
        }

        recStack[i] = false; // Remove node from recursion stack after exploration

        return false;
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[numVertices]; // Mark all vertices as not visited
        boolean[] recStack = new boolean[numVertices]; // Initialize recursion stack

        // Start recursion for all unvisited vertices
        for (int i = 0; i < numVertices; i++)
            if (!visited[i])
                if (isCyclicUtil(i, visited, recStack, -1)) // Pass -1 for parent of the first node
                    return true;

        return false;
    }



    public static void main(String[] args) {
        GraphCycle g = new GraphCycle(5, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.print(g);

        if (g.isCyclic()) {
            System.out.println("Graph has a cycle");
        } else {
            System.out.println("Graph does not have a cycle");
        }
    }
}

