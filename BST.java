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
        return get(root, key);
    }

    private V get(Node n, K key)
    {
        if (n == null){
            return null;
        }
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            return get(n.left, key);
        }
        else if (cmp > 0) {
            return get(n.right, key);
        }
        else return n.val;
    }

    public void delete(K key)
    {
        root = delete(root, key);
    }

    private Node delete(Node n, K key)
    {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.key);

        if (cmp < 0) {
            n.left = delete(n.left, key);
            n.size--;
        } else if (cmp > 0) {
            n.right = delete(n.right, key);
            n.size--;
        } else {
            if (n.right == null) {
                return n.left;
            }
            if (n.left == null) {
                return n.right;
            }
            Node temp = n;
            n = min(temp.right);
            n.right = deleteMin(temp.right);
            n.left = temp.left;
            n.size = n.left.size + n.right.size + 1;
        }
        return n;
    }

    private Node min(Node n) {
        if (n.left == null) {
            return n;
        } else {
            return min(n.left);
        }
    }

    private Node deleteMin(Node n) {
        if (n.left == null) {
            return n.right;
        }
        n.left = deleteMin(n.left);
        n.size--; // Decrement size of node n
        return n;
    }

    public Iterable<K> iterator()
    {
        return null;
    }
}
