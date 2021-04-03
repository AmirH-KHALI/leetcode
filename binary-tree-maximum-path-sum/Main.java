import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode dovomi = new TreeNode(-1);
        TreeNode avali = new TreeNode(-2, dovomi, null);
        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(avali));
    }
}

class TreeNode {
    int val;
    int maxPathToRoot = 0;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            root.maxPathToRoot = root.val;
            return root.val;
        }
        int maxPathToRootFromLeft = 0;
        int maxPathToRootFromRight = 0;
        int maxPathOfLeftSubtree = 0;
        int maxPathOfRightSubtree = 0;
        if (root.left != null) {
            maxPathOfLeftSubtree = maxPathSum(root.left);
            maxPathToRootFromLeft = root.left.maxPathToRoot;
        }
        if (root.right != null) {
            maxPathOfRightSubtree = maxPathSum(root.right);
            maxPathToRootFromRight = root.right.maxPathToRoot;
        }

        root.maxPathToRoot = Math.max(0, Math.max(maxPathToRootFromLeft, maxPathToRootFromRight)) + root.val;
        int ans =
                Math.max(0, maxPathToRootFromLeft) + Math.max(0, maxPathToRootFromRight) + root.val;

        if (root.right != null) ans = Math.max(ans, maxPathOfRightSubtree);
        if (root.left != null) ans =  Math.max(ans, maxPathOfLeftSubtree);
        return ans;
    }
}