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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new LinkedList<>();

        // base case
        if (root == null) return l;

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                li.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            l.add(li.getLast());
        }

        return l;
    }
}
