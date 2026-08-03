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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //base case
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder st = new StringBuilder();

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                st.append("N ");
                continue;
            }
            st.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }

        return st.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Base case
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode temp = q.poll();

            // check for left node
            if (!arr[i].equals("N")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(arr[i]));
                temp.left = leftNode;
                q.offer(leftNode);
            }
            // For right node, check one step further
            // use pre increment, such that the final value of i remains same
            if (!arr[++i].equals("N")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(arr[i]));
                temp.right = rightNode;
                q.offer(rightNode);
            }
        }

        return root;
    }
}
