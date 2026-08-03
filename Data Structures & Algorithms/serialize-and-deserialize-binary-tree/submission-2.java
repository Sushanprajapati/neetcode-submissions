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
    // We'll try to implement level order traversal 

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder st = new StringBuilder();

        q.offer(root);

        while(!q.isEmpty()) {
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
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);

        for(int i = 1; i < arr.length; i++) {
            TreeNode node = q.poll();

            if (!arr[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                node.left = left;
                q.offer(left);
            }
            // for right node, we know the val will be one step forward of left val. so doing ++i
            if (!arr[++i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
