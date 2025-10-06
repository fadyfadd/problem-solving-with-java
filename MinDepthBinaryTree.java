import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MinDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0 || rightDepth == 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }

    @Test
    void min_depth_1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3));

        int expectedMinDepth = 2;
        assertEquals(expectedMinDepth, minDepth(root));
    }

}
