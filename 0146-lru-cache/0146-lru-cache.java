class Node{
    int value;
    int key;
    Node prev,next;

    public Node(int k, int v){
        this.key = k;
        this.value = v;
    }
}

class LRUCache {
    int capacity = 0;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer, Node> hm = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            delete(temp);

            Node nn = new Node(key, temp.value);
            hm.put(key, nn);
            insertAtBack(nn);

            return nn.value;
        }

        return -1;
    }

    private void delete(Node root){
        Node prev = root.prev;
        Node next = root.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insertAtBack(Node cur){
        Node prev = tail.prev;
        cur.next = tail;
        cur.prev = prev;
        prev.next = cur;
        tail.prev = cur;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            delete(temp);
        }else{
            if(hm.size() == capacity){
                Node t = head.next;
                delete(t);
                hm.remove(t.key);
            }
        }

        Node nn = new Node(key, value);
        hm.put(key, nn);
        insertAtBack(nn);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */