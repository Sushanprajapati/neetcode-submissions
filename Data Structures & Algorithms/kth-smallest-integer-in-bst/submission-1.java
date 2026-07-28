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
    List<Integer> tempList = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);

        // we already have the elements of the BST in ascending order after performing in-order traversal
        // In-Order-Traversal (left, root, right)
        // So, we can directly access the element at kth - 1 position (position starts from 0)
        return tempList.get(k - 1);
    }

    // In order traversal and adding the elements in the list, which will be in ascending order
    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        tempList.add(root.val);
        dfs(root.right);
    }
}
