package org.example;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets (int [] nums){

        List<List<Integer>> solution = new ArrayList<>();
        backtrack(nums, solution, new ArrayList<>(), 0);

        return solution;

    }

    private void backtrack(int[] nums, List<List<Integer>> solution, List<Integer> curr, int i) {

        if (i > nums.length){
            return;
        }
        solution.add(new ArrayList<>(curr));

        for (int k = i; k < nums.length; k++){
            curr.add(k);
            backtrack(nums, solution, curr, k+1);
            curr.removeLast();
        }

    }

    public static void main(String[] args) {

        Subsets testObj = new Subsets();
        List<List<Integer>> subsets = testObj.subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());

    }
}
