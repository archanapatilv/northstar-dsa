package org.northstar.dsa;

import java.util.Stack;

public class LargestRectangleInHistogram {

    // brute force way O(n2)
    public static int largestArea(int[] areas) {
        int maxArea = -1;
        int minArea = -1;
        int area = -1;
        for (int i = 0; i < areas.length; i++) {
            minArea = areas[i];
            int j;
            for (j = i; j < areas.length; j++) {
                if (areas[j] < minArea) {
                    minArea = areas[j];
                }
                area = minArea * (j-i+1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return  maxArea;
    }

    public static int largestHistogram(int[] areas) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = -1;
        int topIndex;
        for(int i = 0; i < areas.length; i++) {
            while(!stack.isEmpty() && areas[stack.peek()] >= areas[i]) {
                topIndex = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, areas[topIndex] * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            topIndex = stack.pop();
            int area = areas[topIndex] * (stack.isEmpty() ? areas.length : areas.length - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] areas = {2, 1, 5, 6, 2, 3};
        System.out.println ("Max Area: " + largestArea(areas));
        System.out.println ("Max Area: " + largestHistogram(areas));
        int[] arr = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(largestHistogram(arr));
    }
}
