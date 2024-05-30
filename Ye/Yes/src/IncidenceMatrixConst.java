class IncidenceMatrixGraph extends Graph {

    public IncidenceMatrixGraph(Graph graph) {
        super(graph.numVertices, graph.isDirected);
        this.adjMatrix = graph.adjMatrix;
        this.numEdges = graph.numEdges;
    }

    // Convert to and print the incidence matrix
    public void printIncidenceMatrix() {
        boolean[][] incMatrix = new boolean[numVertices][numEdges];
        int edgeIndex = 0;

        for (int i = 0; i < numVertices; i++) {
            for (int j = (isDirected ? 0 : i); j < numVertices; j++) {
                if (adjMatrix[i][j]) {
                    incMatrix[i][edgeIndex] = true;
                    if (!isDirected && i != j) {
                        incMatrix[j][edgeIndex] = true;
                    }
                    edgeIndex++;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < edgeIndex; j++) {  // Changed to edgeIndex for accurate printing
                s.append((incMatrix[i][j] ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        System.out.println(s.toString());
    }
}