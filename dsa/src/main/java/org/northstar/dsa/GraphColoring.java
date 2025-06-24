package org.northstar.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 🧠 Time Complexity
 * Let: n: Number of vertices, m: Number of edges,  k=3: Number of colors (constant)
 * 🔢 Worst-Case Time Complexity:
 * O(kⁿ) = O(3ⁿ)
 * Why?
 * At each of the
 * n nodes, we try up to 3 color choices.
 * We check each color for conflicts with existing assignments, which takes O(degree(node)) time.
 * So the total worst-case work is roughly:
 * 𝑂(3𝑛⋅𝑑)
 * where
 * d is the maximum degree (worst-case:𝑂(𝑛) O(n)).Thus, more precisely:
 * 𝑂(3𝑛⋅𝑛)

 Metric	Complexity
 Time (worst case)	O(3ⁿ × n)
 Space (without storing solutions)	O(n)
 Space (with storing all solutions)	O(s × n)
 */
public class GraphColoring {
    static final String[] COLORS = {"R", "G", "B"};
    List<List<String>> allCombinations = new ArrayList<>();


    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        int numberOfVertex = 4;
        //Draw a square graph with a diagonal
        for (int i =0; i< numberOfVertex; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(3);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(0);
        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(0);
        graph.get(3).add(2);

        GraphColoring graphColoring = new GraphColoring();
        String[] colorAssignment = new String[numberOfVertex];
        int nodeIndex = 0;
        graphColoring.colorGraph(graph, colorAssignment, nodeIndex);

       graphColoring.printSolutions();


    }

    private void printSolutions() {
        // Print all solutions
        if (allCombinations.isEmpty()) {
            System.out.println("No valid colorings with 3 colors.");
        } else {
            System.out.println("All valid 3-coloring solutions:");
            int count = 1;
            for (List<String> combination : allCombinations) {
                System.out.println("Solution " + (count++) + ": " + combination);
            }
        }
    }

    private void colorGraph(List<List<Integer>> graph, String[] colorAssignment, int nodeIndex) {
        if (nodeIndex >= graph.size()) {
            allCombinations.add(new ArrayList<>(Arrays.asList(colorAssignment.clone())));
            return;
        }
        for(String color: COLORS) {
            if (isSafe(nodeIndex, colorAssignment, color, graph)) {
                colorAssignment[nodeIndex] = color;
                colorGraph(graph, colorAssignment, nodeIndex+1);
                colorAssignment[nodeIndex] = null;
            }
        }
    }

    private boolean isSafe(int nodeIndex, String[] colorAssignment, String color, List<List<Integer>> graph) {
        for (Integer neighbor : graph.get(nodeIndex)) {
            if(colorAssignment[neighbor] != null && colorAssignment[neighbor].equals(color)) {
                return false;
            }
        }
        return true;
    }
}
