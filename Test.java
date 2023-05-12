import java.util.Map;

public class Test {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(3, "amogus");
        tree.put(1, "echpochmak");
        tree.put(5, "vladimir");
        tree.put(2, "vkusnyaxa");
        tree.put(4, "agurec");
        tree.put(45,"yelnur");

        for (Map.Entry<Integer, String> entry : tree) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }

        tree.delete(45);
        System.out.println();
        for (Map.Entry<Integer, String> entry : tree) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
    }
}