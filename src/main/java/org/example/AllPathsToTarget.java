package org.example;

import java.util.ArrayList;
import java.util.List;

public class AllPathsToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> solution = new ArrayList<>();

        backtrack(solution, graph, 0, new ArrayList<>(List.of(0)));

        return solution;

    }

    private void backtrack(List<List<Integer>> solution, int[][] graph, int node, List<Integer> curr) {
        if(node == (graph.length - 1)){
            solution.add(new ArrayList<>(curr));
            return;
        }

        for (int nextNode : graph[node]){
            curr.add(nextNode);
            backtrack(solution,graph,nextNode, curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        AllPathsToTarget testObj= new AllPathsToTarget();
        List<List<Integer>> lists = testObj.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        System.out.println(lists.toString());
    }
}
