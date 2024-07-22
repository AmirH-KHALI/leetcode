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
        List<List<Integer>> output = new ArrayList<>(); // output
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) // For all 2 ^ n to 2 ^ (n + 1)
        {
            List<Integer> curr = new ArrayList<>(); // Store current list
            int temp = i;
            for (int j = 0; j < n; ++j) // Building the current list from i in binary
            {
                if (temp % 2 == 1)
                {
                    curr.add(nums[j]);
                }
                temp = temp >> 1;
            }
            output.add(curr); // Updating the output
        }
        return output;
    }
}