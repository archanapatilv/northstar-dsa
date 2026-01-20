package org.northstar.dsa;
import java.util.*;
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> q = new Stack<>();
        q.push(0);
        for(int i = 1; i < temperatures.length; i++) {
            while(!q.isEmpty() && temperatures[i] > temperatures[q.peek()]) {
                result[q.peek()] = i - q.pop();
            }
            q.push(i);
        }
        while(!q.isEmpty()) {
            result[q.pop()] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] res = dailyTemperatures.dailyTemperatures(temperatures);
        System.out.println(res);
    }
}
