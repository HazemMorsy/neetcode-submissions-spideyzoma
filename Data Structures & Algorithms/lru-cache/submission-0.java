class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.left = new Node(-1,-1);
        this.right = new Node(-1,-1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // key exists in the map
        Node existingNode = map.get(key);
        moveToTop(existingNode);
        return existingNode.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            existingNode.val = value;
            moveToTop(existingNode);
            map.put(key, existingNode);
        } else {
            // adding new key
            Node newNode = new Node(key, value);
            if (map.size() == capacity){
                insertNode(newNode);
                removeLast();
            } else {
                // map size is still lower than the capacity
                insertNode(newNode);
            }
            map.put(key, newNode);
        }
    }

    private void moveToTop(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        insertNode(node);
    }

    private void insertNode(Node node) {
        Node currNext = this.left.next;
        node.next = currNext;
        currNext.prev = node;
        this.left.next = node;
        node.prev = this.left;
    }

    private void removeLast() {
        Node currLast = this.right.prev;
        int key = currLast.key;
        currLast.prev.next = this.right;
        this.right.prev = currLast.prev;
        currLast.prev = null;
        currLast.next = null;
        this.map.remove(key);
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next  = null;
    }
}
