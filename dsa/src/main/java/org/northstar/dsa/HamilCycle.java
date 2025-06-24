package org.northstar.dsa;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Time complexity is n! => O(n to the power of n)
 The algorithm uses backtracking to try all possible permutations of vertices to find a valid Hamiltonian cycle.
 For each of the N vertices, we try visiting every other unvisited vertex:
 First node: N choices (we fix starting node as 0, so actually N−1)
 Second: N−1 choices
 ...
 Last: 1 choice

 So in the worst case, we have to explore all possible permutations of the vertices:
 👉 (N−1)! ≈ O(N!)
 */
public class HamilCycle {

    private static void allCycle(int[][] graph, Set<Integer> visited, int u) {
        if(visited.size() == graph.length) {
            if(graph[u][0] == 1) {
                System.out.println(visited);
            }
        }
        for(int v = 1; v < graph.length; v++) {
            if(visited.contains(v)) continue;
            if(graph[u][v] == 0) continue;
            visited.add(v);
            allCycle(graph, visited, v);
            visited.remove(v);
        }
    }

    public static void main(String[] args) {

        int[][] adjacencyMatrixGraph = new int[][]{
                {0, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}};
        Set<Integer> visited = new LinkedHashSet<>();
        visited.add(0);
        allCycle(adjacencyMatrixGraph, visited, 0);
    }
}
