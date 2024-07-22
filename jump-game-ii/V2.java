public class Solution {

    public int jump(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1) return 0;


        int farthestJumpIndex=0;
        int currentEndIndex=0;
        int jumps=0;

        for(int i=0;i<nums.length-1;i++) 
		{
            if (i > farthestJumpIndex)
            {
                break;
            }
            farthestJumpIndex = Math.max(farthestJumpIndex, i+nums[i]);
            if(i==currentEndIndex) 
			{
                jumps++;
                currentEndIndex=farthestJumpIndex;
            }
            if(currentEndIndex >= nums.length-1) return jumps;
        }

        return -1;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.jump(new int[]{1,1,0}));
        System.out.println(s.jump(new int[]{2}));
        System.out.println(s.jump(new int[0]));
        System.out.println(s.jump(null));
        System.out.println(s.jump(new int[]{1, -2, 3}));
        System.out.println(s.jump(new int[]{2, -2, 3}));
        System.out.println(s.jump(new int[]{2, -2, 2, 3}));
    }

}