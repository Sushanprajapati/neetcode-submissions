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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);  
        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);

        return Math.max((lDepth + rDepth), Math.max(lDiameter, rDiameter));
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    } 


}
