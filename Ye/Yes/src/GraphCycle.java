public class GraphCycle extends Graph {

    public GraphCycle(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];
        boolean[] recursionStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
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

        for (int v = 0; v < numVertices; v++) {
            if (adjMatrix[u][v]) {
                if (!visited[v] && hasCycleUtil(v, visited, recursionStack)) {
                    return true;
                } else if (recursionStack[v]) {
                    return true;
                }
            }
        }

        recursionStack[u] = false;
        return false;
    }

    public static void main(String[] args) {
        GraphCycle g = new GraphCycle(4, false);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        System.out.print(g);

        if (g.hasCycle()) {
            System.out.println("Graph has a cycle");
        } else {
            System.out.println("Graph does not have a cycle");
        }
    }
}
