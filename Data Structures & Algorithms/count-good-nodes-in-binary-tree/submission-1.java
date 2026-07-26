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
    public int goodNodesCount = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return goodNodesCount;
    }

    private void dfs(TreeNode root, int max) {
        // Base Case
        if (root == null) return;

        if (root.val >= max) {
            goodNodesCount++;
            max = root.val;
        }
        dfs (root.left, max);
        dfs (root.right, max);
    }
}
