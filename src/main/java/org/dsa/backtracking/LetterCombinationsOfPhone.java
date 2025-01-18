package org.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhone {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> buttonMap = Map.of(
                '2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z')
        );

        List<String> solution = new ArrayList<>();
        if (digits.isEmpty()) return  solution;
        char [] digitsArr = digits.toCharArray();

        backtrack(buttonMap, solution, digitsArr, 0, new StringBuilder());
        return solution;

    }

    private void backtrack(Map<Character, List<Character>> buttonMap, List<String> solution, char[] digitsArr, int i, StringBuilder curr) {
        if(curr.length() == digitsArr.length){
            solution.add(curr.toString());
            return;
        }

        for (char c : buttonMap.get(digitsArr[i])){
            curr.append(c);
            backtrack(buttonMap, solution, digitsArr, i+1, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public static void main(String[] args) {

        LetterCombinationsOfPhone letterCombinationsOfPhone = new LetterCombinationsOfPhone();
        List<String> strings = letterCombinationsOfPhone.letterCombinations("239");
        System.out.println(strings.toString());

    }
}
