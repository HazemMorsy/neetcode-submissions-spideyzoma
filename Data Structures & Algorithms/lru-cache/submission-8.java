class Node {
    int key;
    int val;
    Node next;
    Node prev;


    public Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node currNode = map.get(key);
        remove(currNode);
        insert(currNode);

        return currNode.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            remove(currNode);
            map.remove(key);
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head = head.next;
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
    
    }

    private void insert(Node node) {
        node.next = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        this.tail.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
