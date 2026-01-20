package org.northstar.tree;

public class SegmentTree {

    //Space : O(n)
    //Time : O(logn)
    // create first time: nLogn

    public int[] createSegmentArray(int[] input) {
        int len = input.length;
        int[] segments = new int[2*len + 1];
        _createSegmentArray(input, segments, 0, len-1, 0);
        return segments;
    }

    private void _createSegmentArray(int[] input, int[] segments, int low, int high, int index) {
        if(low == high) {
            segments[index] = input[index];
            return;
        }
        int mid = (low+high)/2;
        _createSegmentArray(input, segments, low, mid, 2*index+1);// for left
        _createSegmentArray(input, segments, mid+1, high, 2*index+2); // for right
        segments[index] = Math.min(input[2*index+1], input[2*index+2]);
    }

    public int getMinQueryForAGivenRange(int[] input, int[] segments, int low, int high, int pos, int start, int end) {
    // complete overlap
        if(start >= low && end <= high) {
            return segments[pos];
        }
    //No overlap
        if(start > high || end < low) {
            return Integer.MAX_VALUE;
        }
    //partial overlap - go both directions
        int mid = (low + high)/2;
        return Math.min(getMinQueryForAGivenRange(input, segments, low, mid,
                2*pos+1, start, end), getMinQueryForAGivenRange(input, segments, mid+1, high,
                2*pos+2, start, end));
    }
}
