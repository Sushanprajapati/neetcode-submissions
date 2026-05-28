/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> tempMap = new HashMap<>();
        return dfs(tempMap, node);
    }

    private Node dfs(Map<Integer, Node> tempMap, Node node) {
        if (tempMap.containsKey(node.val)) {
            return tempMap.get(node.val);
        }

        Node copy = new Node(node.val);
        tempMap.put(node.val, copy);
        for (Node neighbor: node.neighbors) {
            copy.neighbors.add(dfs(tempMap, neighbor));
        }

        return copy;
    }
}