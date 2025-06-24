package org.northstar.dsa;

import java.util.Arrays;

public class HamiltonianCycle {


    private int[][] graph;
    private int[] path;
    private int numVertices;

    public HamiltonianCycle(int[][] graph) {
        this.graph = graph;
        this.numVertices = graph.length;
        this.path = new int[numVertices];
        Arrays.fill(path, -1); // Initialize path with -1
    }


    public boolean findHamiltonianCycle() {
        path[0] = 0; // Start from vertex 0
        return hamiltonianUtil(1);
    }

    private boolean hamiltonianUtil(int vertexIndex) {
        // Base case: all vertices are included in the path
        if (vertexIndex == numVertices) {
            // Check if there is an edge between the last and first vertex
            return graph[path[vertexIndex - 1]][path[0]] == 1;
        }

        for (int nextVertex = 1; nextVertex < numVertices; nextVertex++) {
            if (isSafe(nextVertex, vertexIndex)) {
                path[vertexIndex] = nextVertex;
                if (hamiltonianUtil(vertexIndex + 1)) {
                    return true;
                }
                // Backtrack if no solution
                path[vertexIndex] = -1;
            }
        }

        return false; // No solution
    }

    private boolean isSafe(int vertex, int vertexIndex) {
        // Check if there is an edge between the previous and current vertex
        if (graph[path[vertexIndex - 1]][vertex] == 0) {
            return false;
        }

        // Check if the vertex is already included in the path
        for (int i = 0; i < vertexIndex; i++) {
            if (path[i] == vertex) {
                return false;
            }
        }
        return true;
    }

    public void printSolution() {
        if (findHamiltonianCycle()) {
            System.out.print("Hamiltonian Cycle: ");
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
            System.out.println(path[0]); // Print the starting vertex to complete the cycle
        } else {
            System.out.println("No Hamiltonian Cycle exists in the graph.");
        }
    }

    public static void main(String[] args) {

        int[][] adjacencyMatrixGraph = new int[][]{
                {0, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}};

        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };

        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(graph);
        hamiltonianCycle.printSolution();
    }


}
