/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxVal = new int[1];
        maxVal[0] = Integer.MIN_VALUE;
        splitTree(root, maxVal);
        return maxVal[0];
    }

    private int splitTree(TreeNode root, int[] maxVal) {
        if (root == null) return 0;

        // when we do math.max(0, splitTree)
        // we are actually eliminating negative value
        // even if we got the negative val, since we take max, 0 will come as our value
        int leftSum = Math.max(0, splitTree(root.left, maxVal));
        int rightSum = Math.max(0, splitTree(root.right, maxVal));

        maxVal[0] = Math.max(maxVal[0], leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}
