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
        // edge case for null input
        if (node == null) return null;

        // Create a map to keep track of visited nodes and their adjacent neighbours
        // Key is the value of the node, whereas the value is the Node itself (Node will have its own neighbours)
        Map<Integer, Node> tempMap = new HashMap<>();
        
        // Perform a DFS for each node
        // visit each node and its neighbour recursively and return the node
        return dfs(node, tempMap);
    }

    // Helper dfs method
    private Node dfs(Node node, Map<Integer, Node> tempMap) {
        // check if the node is already visited
        // do that in the map
        // if the node is visited, return the node
        if (tempMap.containsKey(node.val)) {
            return tempMap.get(node.val);
        }

        // If the node doesnot exists in map / if its not visited, create a new node out of it 
        Node copy = new Node(node.val);

        // Add the entry to the Map
        tempMap.put(node.val, copy);

        // For each Node, they have their own list of neighbours
        // so we need to copy/add those neighbours as well
        // loop through the neighbors of node, and add each to the newly made node (copy)
        for (Node neighbour: node.neighbors) {

            // recursively call the dfs function for each of the neighbor node 
            // We'll add each neighbors to the current node by going deep (DFS)
            copy.neighbors.add(dfs(neighbour, tempMap));
        }

        return copy;
    }
}