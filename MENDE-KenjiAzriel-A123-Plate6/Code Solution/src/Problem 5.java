import java.util.Arrays;
import java.util.LinkedList;

class BipartiteGraph extends Graph {

    public BipartiteGraph(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
    }

    public boolean isBipartite() {
        int[] colorArr = new int[numVertices];
        Arrays.fill(colorArr, -1);

        for (int i = 0; i < numVertices; ++i) {
            if (colorArr[i] == -1) {
                if (!isBipartiteUtil(i, colorArr))
                    return false;
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int src, int[] colorArr) {
        colorArr[src] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (adjMatrix[u][u])
                return false;

            for (int v = 0; v < numVertices; ++v) {
                if (adjMatrix[u][v] && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    queue.add(v);
                } else if (adjMatrix[u][v] && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        return true;
    }


    // Test Cases
    public static void main(String[] args) {

        // Test Case 1: Bipartite Graph
        System.out.println("Test Case 1: Bipartite Graph");
        BipartiteGraph bipartiteGraph1 = new BipartiteGraph(6, false);
        bipartiteGraph1.addEdge(0, 1);
        bipartiteGraph1.addEdge(0, 3);
        bipartiteGraph1.addEdge(2, 1);
        bipartiteGraph1.addEdge(2, 5);
        bipartiteGraph1.addEdge(4, 3);
        bipartiteGraph1.addEdge(4, 5);
        System.out.println(bipartiteGraph1);
        System.out.println("Is the graph bipartite? " + bipartiteGraph1.isBipartite());

        // Test Case 2: Non-Bipartite Graph
        System.out.println("\nTest Case 2: Non-Bipartite Graph");
        BipartiteGraph bipartiteGraph2 = new BipartiteGraph(5, false);
        bipartiteGraph2.addEdge(0, 1);
        bipartiteGraph2.addEdge(0, 4);
        bipartiteGraph2.addEdge(1, 2);
        bipartiteGraph2.addEdge(2, 3);
        bipartiteGraph2.addEdge(3, 0);
        System.out.println(bipartiteGraph2);
        System.out.println("Is the graph bipartite? " + bipartiteGraph2.isBipartite());

        // Test Case 3: Empty Graph
        System.out.println("\nTest Case 3: Empty Graph");
        BipartiteGraph bipartiteGraph3 = new BipartiteGraph(4, false);
        System.out.println(bipartiteGraph3);
        System.out.println("Is the graph bipartite? " + bipartiteGraph3.isBipartite());

        // Test Case 4: Complete Bipartite Graph
        System.out.println("\nTest Case 4: Complete Bipartite Graph");
        BipartiteGraph bipartiteGraph4 = new BipartiteGraph(6, false);
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                bipartiteGraph4.addEdge(i, j);
            }
        }
        System.out.println(bipartiteGraph4);
        System.out.println("Is the graph bipartite? " + bipartiteGraph4.isBipartite());
        // Test Case 5: Directed Bipartite Graph
        System.out.println("\nTest Case 5: Directed Bipartite Graph");
        BipartiteGraph bipartiteGraph5 = new BipartiteGraph(6, true); // Directed
        bipartiteGraph5.addEdge(0, 1); // 0 -> 1
        bipartiteGraph5.addEdge(0, 3); // 0 -> 3
        bipartiteGraph5.addEdge(2, 1); // 2 -> 1
        bipartiteGraph5.addEdge(4, 3); // 4 -> 3
        bipartiteGraph5.addEdge(4, 5); // 4 -> 5
        System.out.println(bipartiteGraph5);
        System.out.println("Is the graph bipartite? " + bipartiteGraph5.isBipartite());

    }
}