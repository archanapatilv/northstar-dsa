package org.northstar.graph;

/**
 *    Social network connectivity.
 *    Given a social network containing n members and a log file containing
 *    m timestamps at which times pairs of members formed friendships, design an algorithm to determine the
 *    earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).
 *    Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 *    The running time of your algorithm should be mlogn or better and use extra space proportional to n
 */
public class SocialNetworkConnectivity {

    // Union-Find (Disjoint Set Union) implementation
    private static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int components;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // Path compression
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return false; // already connected
            }

            // Union by size
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }

            components--;
            return true;
        }

        public int getComponents() {
            return components;
        }
    }

    /**
     * @param n number of members
     * @param log array of log entries, each entry is {timestamp, p, q}
     *            log is assumed to be sorted by timestamp
     * @return earliest timestamp when all members are connected,
     *         or -1 if never fully connected
     */
    public static int earliestTimeAllConnected(int n, int[][] log) {
        UnionFind uf = new UnionFind(n);

        for (int[] entry : log) {
            int time = entry[0];
            int p = entry[1];
            int q = entry[2];

            if (uf.union(p, q)) {
                if (uf.getComponents() == 1) {
                    return time;
                }
            }
        }

        return -1; // never fully connected
    }

    // Example usage
    public static void main(String[] args) {
        int n = 6;
        int[][] log = {
                {20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5}, // invalid example if n=5, just for illustration
                {20190224, 1, 2}
        };

        System.out.println(earliestTimeAllConnected(n, log));
    }
}
