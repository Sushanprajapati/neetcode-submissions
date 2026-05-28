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
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root) != -1;
    }

    private int balancedHeight(TreeNode root) {
        if (root == null) return 0;

        int lNode = balancedHeight(root.left);
        if (lNode == -1) return -1;

        int rNode = balancedHeight(root.right);
        if (rNode == -1) return -1;

        if (Math.abs(lNode - rNode) > 1) {
            return -1;
        }

        return Math.max(lNode, rNode) + 1;
    }
}
