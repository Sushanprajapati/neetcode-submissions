class LRUCache {
    Map<Integer, Node> tempHash;
    Node head = new Node();
    Node tail = new Node();
    int cache_capacity;

    public LRUCache(int capacity) {
        tempHash = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
        this.cache_capacity = capacity;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = tempHash.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            afterHead(node);
        }
        return result;
    }
    
    // Note: Always Keep in mind that: Map is referencing the NODE. So, if you change NODE, no need to change map.
    // But if we want to make change to MAP, make sure to change the node too. in order: MAP -> Node
    public void put(int key, int value) {
        Node node = tempHash.get(key);
        if (node != null) {
             node.val = value;
             remove(node);
             afterHead(node);
        } else {
            if (tempHash.size() == cache_capacity) {
                tempHash.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node tempNode = new Node();
            tempNode.val = value;
            tempNode.key = key;

            afterHead(tempNode);
            tempHash.put(key, tempNode);
        }
    }

    public void afterHead(Node node) {
        Node tempNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = tempNode;
        tempNode.prev = node;
    }

    public void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

}
