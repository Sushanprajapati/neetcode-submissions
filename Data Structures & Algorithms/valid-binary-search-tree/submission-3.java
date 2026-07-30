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
    private List<Integer> tempList = new ArrayList<>(); 
    public boolean isValidBST(TreeNode root) {
        dfs(root);

        int prevVal = tempList.get(0);
        boolean result = true;

        for (int i = 1; i < tempList.size(); i++) {
            if (prevVal >= tempList.get(i)) result = false;

            prevVal = tempList.get(i);
        }

        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        tempList.add(root.val);
        dfs(root.right);
    }
}
