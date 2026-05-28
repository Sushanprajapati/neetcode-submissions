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
        return heightOfTree(root) != -1;
    }

    private int heightOfTree(TreeNode root) {
        if (root == null) return 0;

        int lNode = heightOfTree(root.left);
        if (lNode == -1) return -1;

        int rNode = heightOfTree(root.right);
        if (rNode == -1) return -1;

        if (Math.abs(rNode - lNode) > 1) return -1;

        return Math.max(lNode, rNode) + 1;
    }
}
