class LRUCache {
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> hashMap;
    int cacheCapacity;

    public LRUCache(int capacity) {
        hashMap = new HashMap(capacity);
        this.cacheCapacity = capacity;
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
    
    // Note: Always Keep in mind that: Map is referencing the NODE. So, if you change NODE, no need to change map.
    // But if we want to make change to MAP, make sure to change the node too. in order: MAP -> Node
    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.val = value;
            removeNode(node);
            addAfterHead(node);
        } else {
            if (hashMap.size() == cacheCapacity) {
                hashMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            Node tempNode = new Node();
            tempNode.val = value;
            tempNode.key = key;

            hashMap.put(key, tempNode);
            addAfterHead(tempNode); 
        }
    }

    public void addAfterHead(Node node) {
        Node tempNode = head.next;
        node.next = tempNode;
        tempNode.prev = node;
        head.next = node;
        node.prev = head; 
    }

    public void removeNode(Node node) {
        Node prev_node = node.prev;
        Node next_node = node.next;
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
