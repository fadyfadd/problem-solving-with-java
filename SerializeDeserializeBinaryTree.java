import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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

    private void assertTreeEquals(TreeNode expected,
                                   TreeNode actual) {
        if (expected == null && actual == null) return;
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected.val, actual.val);
        assertTreeEquals(expected.left, actual.left);
        assertTreeEquals(expected.right, actual.right);
    }

    @Test
    void testSerializeAndDeserializeTogether() {

        SerializeDeserializeBinaryTree.TreeNode root =
                new SerializeDeserializeBinaryTree.TreeNode(1);
        root.left = new SerializeDeserializeBinaryTree.TreeNode(2);
        root.right = new SerializeDeserializeBinaryTree.TreeNode(3);
        SerializeDeserializeBinaryTree ser = new SerializeDeserializeBinaryTree();
        String serialized = ser.serialize(root);
        SerializeDeserializeBinaryTree.TreeNode deserializedRoot = ser.deserialize(serialized);
        assertTreeEquals(root, deserializedRoot);
    }

}
