package com.amirh;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	    String str = in.next();
	    Solution s = new Solution();

        System.out.println(s.minRemoveToMakeValid(str));
    }
}


class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> open_parentheses = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                open_parentheses.push(ans.length());
            }
            else if (s.charAt(i) == ')')
            {
                if (open_parentheses.size() > 0)
                {
                    open_parentheses.pop();
                }
                else
                {
                    continue;
                }
            }
            ans.append(s.charAt(i));
        }

        for (int j = 0; j < open_parentheses.size(); j++) {
            int i = open_parentheses.size() - j - 1;
            ans.deleteCharAt(open_parentheses.get(i));
        }

        return ans.toString();
    }
}