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
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;

        currNode.next = tail;
        currNode.prev = tail.prev;
        tail.prev.next = currNode;
        tail.prev = currNode;

        return currNode.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            map.remove(key);
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        map.put(key, newNode);
    
    }
}
