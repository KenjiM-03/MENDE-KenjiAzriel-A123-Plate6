import java.util.ArrayList;
import java.util.List;

public class Graph {
    protected List<List<Integer>> adjList;
    protected int numVertices;
    protected boolean isDirected;

    // Initialize the adjacency list
    public Graph(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edges
    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        if (!isDirected) {
            adjList.get(j).add(i);
        }
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjList.get(i).remove((Integer) j);
        if (!isDirected) {
            adjList.get(j).remove((Integer) i);
        }
    }

    // Print the adjacency list
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : adjList.get(i)) {
                s.append(j + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4, true); // create a directed graph

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());
    }
}
