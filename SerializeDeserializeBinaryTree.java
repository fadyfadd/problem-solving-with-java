import java.util.*;

public class SerializeDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) return "/,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Deque<String> nodes) {
        String val = nodes.poll();
        if (val.equals("/") || val.isEmpty()) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        SerializeDeserializeBinaryTree ser = new SerializeDeserializeBinaryTree();
        String data = ser.serialize(root);
        System.out.println("Serialized: " + data);

        TreeNode newRoot = ser.deserialize(data);
        printPreOrder(newRoot); 
    }

    private static void printPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
