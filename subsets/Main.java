package com.amirh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	    String[] splitString = in.next().split(",");
	    int[] nums = new int[splitString.length];
	    for(int i = 0; i < splitString.length; ++i)
	        nums[i] = Integer.parseInt(splitString[i]);
	    Solution s = new Solution();

        System.out.println(s.subsets(nums));
    }
}


class Solution
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i)
        {
            List<Integer> curr = new ArrayList<>();
            int temp = i;
            for (int j = 0; j < n; ++j)
            {
                if (temp % 2 == 1)
                {
                    curr.add(nums[j]);
                }
                temp /= 2;
            }
            output.add(curr);
        }
        return output;
    }
}