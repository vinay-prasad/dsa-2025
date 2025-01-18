package org.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {


    /**
     * backtrack(curr){
     * if(base case){
     * increment or add to result
     * return
     * }
     * <p>
     * for (iterate over input){
     * modify curr
     * backtrack(curr)
     * undo modification
     * }
     * }
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        backtrack(nums, solution, new ArrayList<>());
        return solution;

    }

    private void backtrack(int[] nums, List<List<Integer>> solution, List<Integer> curr) {
        if (curr.size() == nums.length) {
            solution.add(new ArrayList<>(curr));
            return;
        }
        for (int i : nums) {
            if (!curr.contains(i)) {
                curr.add(i);
                backtrack(nums, solution, curr);
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Permute testObj = new Permute();
        List<List<Integer>> subsets = testObj.permute(new int[]{1, 2, 3});

        System.out.println(subsets.toString());

    }
}
