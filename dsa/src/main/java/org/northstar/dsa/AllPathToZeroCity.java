package org.northstar.dsa;

import java.util.*;

public class AllPathToZeroCity {

    static int count = 0;
    public static int minReorder(int n, int[][] connections) {
        // get neighbors information
        Map<Integer, Map<Integer, Boolean>> neighbors = new HashMap<>();
        for(int i = 0; i < connections.length; i++) {
            int fromNode = connections[i][0];
            int toNode = connections[i][1];
            Map<Integer, Boolean> s = neighbors.getOrDefault(fromNode, new HashMap<>());
            s.put(toNode, true);
            neighbors.put(fromNode, s);
            s = neighbors.getOrDefault(toNode, new HashMap<>());
            s.put(fromNode, false);
            neighbors.put(toNode, s);
        }

        dfs(0, -1, neighbors);

        return count;
    }

    private static void dfs(int node, int parent, Map<Integer, Map<Integer, Boolean>> neighbors) {
        //no neighbors found
        if(!neighbors.containsKey(node)) {
            return;
        }
        Map<Integer, Boolean> neighborList = neighbors.get(node);
        for(Integer neighbor: neighborList.keySet()) {
            // check if edge exist
            if(neighbor != parent) {
                if(null == neighbors.get(neighbor) || !neighbors.get(neighbor).containsKey(node)
                || !neighbors.get(neighbor).get(node))
                    count++;
                dfs(neighbor, node, neighbors);
            }
        }
    }

    public static void main(String[] args) {
        int[][] sample = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(minReorder(5, sample));

    }
}
