package org.northstar.graph;

/**
 *    Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following form:
 *         1. Remove x from S
 *         2. Find the successor of x: the smallest y in S such that y >= x
 *    Design a data type so that all operations (except construction)  take logarithmic time or better in the worst case.
 *
 *    Solution: The trick is to use Union–Find to skip over deleted elements.
 *
 *    Data structure
 *          We use Union–Find with path compression, but with a special meaning:
 *              parent[i] points to the next candidate successor
 *              If x is removed, we union x with x+1
 *              We add a sentinel element n meaning “no successor”
 *
 *   This version matches the classical algorithmic solution and
 *   runs in amortized near-constant time, which is better than logarithmic.
 *
 *    Time Complexity
 *          remove(x): O(α(n)) (≤ logarithmic)
 *          successor(x): O(α(n))
 *
 *    Space: O(n)
 */
public class SuccessorWithDelete {

    private int[] parent;
    private int n;

    // Create set {0, 1, ..., n-1}
    public SuccessorWithDelete(int n) {
        this.n = n;
        parent = new int[n + 1]; // extra slot for sentinel

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    // Remove x from the set
    //amortized O(α(n)) - effectively constant time
    public void remove(int x) {
        if (x < 0 || x >= n) {
            throw new IllegalArgumentException("x out of range");
        }
        union(x, x + 1);
    }

    // Return the smallest y >= x that is still in the set
    // Returns -1 if no successor exists
    //amortized O(α(n)) - effectively constant time
    public int successor(int x) {
        if (x < 0 || x >= n) {
            throw new IllegalArgumentException("x out of range");
        }
        int res = find(x);
        return (res == n) ? -1 : res;
    }

    // Simple test
    public static void main(String[] args) {
        SuccessorWithDelete swd = new SuccessorWithDelete(10);

        swd.remove(2);
        swd.remove(3);
        swd.remove(5);

        System.out.println(swd.successor(2)); // 4
        System.out.println(swd.successor(3)); // 4
        System.out.println(swd.successor(5)); // 6
        System.out.println(swd.successor(9)); // 9

        swd.remove(9);
        System.out.println(swd.successor(9)); // -1
    }

}
