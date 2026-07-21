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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // O(H) time - height of tree
        // Base case
        if (root == null || p == null || q == null) {
            return root;
        }

        // Recursively going towards left and right child (DFS approach)
        // if both the p and q are smaller (even after taking max(p,q), we go to left)
        // if both p and q are bigger than root (even after taking min (p,q), it means
        // root is smaller than min(p,q), so we go to right)
        // else, it signifies that we have reached the point of separation and that point is our answer
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
