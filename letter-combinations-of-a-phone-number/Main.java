package com.amirh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    String a = "23";
	    Solution solution = new Solution();
        System.out.println(solution.letterCombinations(a));
    }
}

class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }

        phoneDigits = digits;
        backtrack();
        return combinations;
    }

    private void backtrack() {

        StringBuilder path = new StringBuilder();
        int index = 0;
        int[] positions = new int[phoneDigits.length()];

        while (true) {
            if (path.length() == phoneDigits.length()) {
                combinations.add(path.toString());
                path.deleteCharAt(path.length() - 1);
                index--;
                continue;
            }

            String possibleLetters = letters.get(phoneDigits.charAt(index));
            if (index == 0 && positions[index] >= possibleLetters.length()) {
                break;
            }
            if (positions[index] >= possibleLetters.length()) {
                positions[index] = 0;
                path.deleteCharAt(path.length() - 1);
                index--;
                continue;
            }
            path.append(possibleLetters.charAt(positions[index]));
            positions[index]++;
            index++;
        }
    }

    public List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }

        phoneDigits = digits;
        backtrack1(0, new StringBuilder());
        return combinations;
    }

    private void backtrack1(int index, StringBuilder path) {
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }

        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack1(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}