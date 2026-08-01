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
        int[] maxSum = new int[1]; // declaring an array so that it'll be easier to replace the value 
        maxSum[0] = Integer.MIN_VALUE; // Initializing the min value at the beginning
        maxPath(root, maxSum);
        return maxSum[0];
    }

    // perform dfs which resembles finding the height of binary tree
    private int maxPath(TreeNode root, int[] maxSum) {
        // base case
        // if no any child nodes, return 0
        if (root == null) return 0;

        // We are doing math.max to ignore the negative value
        int leftSum = Math.max(0, maxPath(root.left, maxSum));
        int rightSum = Math.max(0, maxPath(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + root.val);

        // just like we did for finding the height of tree
        // just the diff. is: we are returning the sum of actual value of the nodes
        return root.val + Math.max(leftSum, rightSum);
    }
}
