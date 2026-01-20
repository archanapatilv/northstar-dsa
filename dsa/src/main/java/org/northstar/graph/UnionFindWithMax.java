package org.northstar.graph;

/**
 *    Union-find with specific canonical element. Add a method find() to the union-find data type so that
 *    find(i) returns the largest element in the connected component containing i. The operations
 *    union(), connected() and find() should all take logarithmic time or better.
 *
 *    For example, if one of the connected components is {1, 2, 6, 9}, then the find() method should return
 *     9 for each of the four elements in the connected components
 *
 *    Time:
 *          All operations run in O(logn) (or O(α(n)) with path compression)
 *    Space:
 *          O(n)
 */
public class UnionFindWithMax {
    private int[] parent;
    private int[] size;
    private int[] max;

    public UnionFindWithMax(int n) {
        parent = new int[n];
        size = new int[n];
        max = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            max[i] = i; // each element in its component is the max
        }
    }

    public boolean union(int p, int q) {
        p = findHead(p);
        q = findHead(q);
        if(p == q) { // already in the same component
            return  false;
        }
        if(size[p] <= size[q]) {
            parent[p] = q;
            size[q] += size[p];
            max[q] = Math.max(max[q], max[p]);
        } else {
            parent[q] = p;
            size[p] += size[q];
            max[p] = Math.max(max[q], max[p]);
        }

        return true;
    }

    private int findHead(int p) {
        while(parent[p] != p) {
            parent[p] = parent[parent[p]]; // path compression
            p = parent[p];
        }
        return p;
    }

    public boolean find(int p, int q) {
        return  findHead(p) == findHead(q);
    }

    public int findMax(int p) {
        p = findHead(p);
        return max[p];
    }

    public static void main(String[] args) {
        UnionFindWithMax uf = new UnionFindWithMax(10);

        uf.union(1, 2);
        uf.union(2, 6);
        uf.union(6, 9);

        System.out.println(uf.findMax(1)); // 9
        System.out.println(uf.findMax(2)); // 9
        System.out.println(uf.findMax(6)); // 9
        System.out.println(uf.findMax(9)); // 9
    }

}
