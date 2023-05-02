class LRUCache {

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!hashMap.containsKey(key)) {
            return -1;
        }
        Node node = hashMap.get(key);
        remove(node);
        insert(head, node);
        return node.val;    
    }
    
    public void put(int key, int value) {
        if(!hashMap.containsKey(key)) {
            Node node = new Node();
            node.key = key;
            node.val = value;
            hashMap.put(key, node);
            insert(head, node);
            if(hashMap.size() > capacity) {
                hashMap.remove(tail.pre.key);
                remove(tail.pre);
                
            }
        } else {
            Node node = hashMap.get(key);
            node.val = value;
            remove(node);
            insert(head, node);
        }
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void insert(Node pre, Node node) {
        pre.next.pre = node;
        node.next = pre.next;
        pre.next = node;
        node.pre = pre;
    }

    class Node{
        int  key;
        int val;
        Node pre;
        Node next;
    }
    HashMap<Integer,Node> hashMap = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */