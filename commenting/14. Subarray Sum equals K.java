import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
	    int[] a = {1, 1, 1};
	    Solution solution = new Solution();
        System.out.println(solution.subarraySum(a, 2));
    }
}

class Solution
{
    public int subarraySum(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>(); // Using map to store number of nums prefixes with sum of k 
        
        int sum = 0;
        int ans = 0;
        map.put(0, 1); // First we have a empty subarray with sum of 0
        for (int num : nums)
        {
            sum += num;
            ans += map.getOrDefault(sum - k, 0); // Counting prefixes with sum of "sum - k" instead of sufixes with sum of "k"
            int count = map.getOrDefault(sum, 0);
            map.put(sum, count + 1);
        }
        return ans;
    }
}