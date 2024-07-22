package com.amirh;

import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	    String str = in.nextLine();
	    Solution s = new Solution();

	    String[] string_inputs = str.split(",");
        int[] inputs = new int[string_inputs.length];

	    for (int i = 0; i < inputs.length; ++i) {
	        inputs[i] = Integer.parseInt(string_inputs[i]);
        }

        System.out.println(s.jump(inputs));
    }
}


class Solution {
    public int jump(int[] nums) {
        // Minimum number of jumps to reach the ith index.
        int[] min_jumps_number = new int[nums.length];
        // j: Index of the farthest position can jump to the current position.
        int j = 0;

        // Because we start from the first index.
        min_jumps_number[0] = 0;
        for (int i = 1; i < nums.length; i++)
        {
            // Update j
            while (nums[j] < i - j)
            {
                j++;
            }
            // Update dp[i] from dp[j]
            min_jumps_number[i] = min_jumps_number[j] + 1;
        }
        return min_jumps_number[nums.length - 1];
    }
}
























