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
    public boolean isValidBST(TreeNode root) {
        dfs(root);

        int prevVal = tempList.get(0);
        boolean result = true;

        // we'll loop from location 1, to compare with prev val
        for (int i = 1; i < tempList.size(); i++) {

            if (tempList.get(i) <= prevVal) result = false;

            prevVal = tempList.get(i);
        }

        return result;
    }

    // performing in-order-traversal (left,root,right)
    // if we look at the results, the values are always in ascending order for valid BST
    // So, we'll first do the in order traversal, which gives us the BST nodes and then check
    // if the values are in ascending form or not
    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        tempList.add(root.val);
        dfs(root.right);    
    }
}
