public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node
    {
        private K key;
        private V val;
        private int size;
        private Node left, right;
        public Node(K key, V val, int size)
        {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public void put(K key, V val)
    {
        root = put(root, key, val);
    }

    private Node put(Node n,K key, V val)
    {
        if (n == null){
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.left = put(n.left, key, val);
        }
        else if (cmp > 0) {
            n.right = put(n.right, key, val);
        }
        else n.val = val;
        n.size++;
        return n;
    }

    public  V get(K key)
    {
        return null;
    }

    public void delete(K key)
    {

    }

    public Iterable<K> iterator()
    {
        return null;
    }
}
