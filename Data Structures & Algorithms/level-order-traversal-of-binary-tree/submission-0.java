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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> tempQueue = new LinkedList<>();
        List<List<Integer>> tempList = new LinkedList<>();

        // Base Condition
        if (root == null) return tempList;

        // Starting Condition
        tempQueue.add(root);

        while (!tempQueue.isEmpty()) {
            // Storing the size of the queue at the beginning itself
            // because, we'll be adding the child nodes to the queue later
            // we want to add the level wise elements to the list for particular level.
            int queueSize = tempQueue.size();

            List<Integer> innerList = new LinkedList<>();

            for (int i = 0; i < queueSize; i++) {
                TreeNode nod = tempQueue.poll();
                if (nod.left != null) {
                    tempQueue.add(nod.left);
                }
                if (nod.right != null) {
                    tempQueue.add(nod.right);
                }
                innerList.add(nod.val);
            }

            tempList.add(innerList);
        }

        return tempList;
    }
}
