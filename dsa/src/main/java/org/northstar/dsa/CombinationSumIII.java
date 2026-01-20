package org.northstar.dsa;

import java.util.*;
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> currentList = new LinkedList<>();
        backTrack(k, n, result, currentList, 0, 0);
        return result;
    }

    public void backTrack(int k, int n, List<List<Integer>> result,
                          List<Integer> currentResult,
                          Integer currentSum, Integer currentNumber) {
        if(currentSum == n && k == currentResult.size()) {
            result.add(new LinkedList<>(currentResult));
            return;
        } else if (k == currentResult.size()) {
            return;
        }
        for(int i = currentNumber; i < 9; i++) {
            int temp = currentSum + i + 1;
            if(temp <= n) {
                currentResult.add(i + 1);
                backTrack(k, n, result, currentResult, currentSum + i + 1, i + 1);
                currentResult.remove((Integer) (i + 1));
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3, 7));
    }
}
