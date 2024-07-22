import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	    String str = in.nextLine();
	    Solution s = new Solution();

	    String[] string_inputs = str.split(",");
        TreeNode[] inputs = new TreeNode[string_inputs.length * 2 + 20];
        int pi = in.nextInt();
        int qi = in.nextInt();
        TreeNode p = new TreeNode(pi);
        TreeNode q = new TreeNode(qi);

	    for (int i = string_inputs.length - 1; i >= 0; --i) {
	        if (string_inputs[i].equals("null")) inputs[i] = null;
	        else {
	            inputs[i] = new TreeNode(Integer.parseInt(string_inputs[i]), inputs[2 * i + 1], inputs[2 * i + 2]);
	            if (inputs[i].val == pi) p = inputs[i];
	            if (inputs[i].val == qi) q = inputs[i];
            }
        }


        System.out.println(s.lowestCommonAncestor(inputs[0], p, q).val);
    }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x, TreeNode left, TreeNode right) {
      val = x;
      this.left = left;
      this.right = right;
  }
  TreeNode(int x) {
      val = x;
  }
}
class Solution {

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        ans = null;
        lca(root, p.val, q.val);
        return ans;
    }

    int lca(TreeNode root, int p, int q)
    {
        if (root == null)
            return 0;

        // found: Number of requested nodes in the current subtree
        int found = 0;

        // If the current node equals to p or q
        if (root.val == p) found++;
        if (root.val == q) found++;

        // Add The number of the requested nodes in the left or right subtree
        found += lca(root.left, p, q);
        found += lca(root.right, p, q);

        // If all the requested nodes were in the subtree for the first time, the answer is found
        if (found == 2 && ans == null) ans = root;

        return found;
    }
}
























