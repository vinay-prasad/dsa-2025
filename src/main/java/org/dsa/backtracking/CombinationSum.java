package org.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solution = new ArrayList<>();

        backtrack(candidates, 0, 0, target, solution, new ArrayList<Integer>());

        return solution;
    }

    private void backtrack(int[] candidates, int i, int sum, int target, List<List<Integer>> solution, ArrayList<Integer> curr) {
        if (sum == target){
            solution.add(new ArrayList<>(curr));
            return;
        }

        for (int k = i; k < candidates.length; k++){
            int num = candidates[k];
            if(num + sum <= target ){
                curr.add(candidates[k]);
                backtrack(candidates, k, (num + sum), target, solution, curr);
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 7}, 7);
        System.out.println(lists.toString());
    }

}
