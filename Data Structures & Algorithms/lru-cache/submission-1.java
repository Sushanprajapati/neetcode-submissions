class LRUCache {
    // Defining head and tail node. They'll act as start and end point of our DLL
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> hashMap;
    int cache_capacity;

    public LRUCache(int capacity) {
        // Initialize the hashMap with given capacity
        hashMap = new HashMap(capacity);
        this.cache_capacity = capacity;
        // Initialize the connection between head and tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = hashMap.get(key);

        if (node != null) {
            result = node.val;
            removeNode(node);
            addAfterHead(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node != null) {
            removeNode(node);
            node.val = value;
            addAfterHead(node);
            // hashMap.put(key, node);
        } else { // node/value deosnot exists. So, we'll have to add new one. Before that, we've to check the size
            if (hashMap.size() == cache_capacity) {
                hashMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            Node tempNode = new Node();
            tempNode.key = key;
            tempNode.val = value;
            hashMap.put(key, tempNode);

            addAfterHead(tempNode);
        }
    }

    // Helper method to add the node or bring the node after head
    // It will indicate the node is the last visited
    public void addAfterHead(Node node) {
        Node tempNode = head.next;
        node.next = tempNode;
        tempNode.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Helper method to remove the node
    // Removing can either be totally deleting the node (if add method is called and there is no capacity left)
    // or removing the node from its position when get/put method is called. 
    // get/put method will remove the node and then later call the addAfterHead method because now the node has been
    // visited
    public void removeNode(Node node) {
        // First store the prev and next node somewhere
        Node prev_node = node.prev;
        Node next_node = node.next;
        // Then rearrange the nodes to remove pointer to/from the specific node
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }

    class Node {
        int val;
        int key;
        Node prev;
        Node next;
    }
}
