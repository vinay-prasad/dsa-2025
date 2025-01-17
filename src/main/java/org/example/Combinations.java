package org.example;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combinations(int n, int k){
        List<List <Integer>> solution = new ArrayList<>();

        backtrack(solution, new ArrayList<>(), 1, n, k);

        return  solution;
    }

    private void backtrack(List<List<Integer>> solution, List<Integer> curr, int i, int n, int k) {

        if (curr.size() == k){
            solution.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j <=n; j++){
            curr.add(j);
            backtrack(solution, curr, j+1, n, k);
            curr.removeLast();

        }
    }

    public static void main(String[] args) {

        Combinations testObj = new Combinations();
        List<List<Integer>> combinations = testObj.combinations(4, 2);
        System.out.println(combinations.toString());

    }
}
