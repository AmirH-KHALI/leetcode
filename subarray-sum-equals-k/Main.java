package com.amirh;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    int[] a = {1, 1, 1};
	    Solution solution = new Solution();
        System.out.println(solution.subarraySum(a, 2));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for (int num : nums)
        {
            sum += num;
            ans += map.getOrDefault(sum - k, 0);
            int count = map.getOrDefault(sum, 0);
            map.put(sum, count + 1);
        }
        return ans;
    }
}