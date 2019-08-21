/**
 * Given a complete binary tree, count the number of nodes in faster than O(n) time. Recall that a complete binary tree
 * has every level filled except the last, and the nodes in the last level are filled starting from the left.
 */
public class DailyCoding204 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(6);

        root.left = left;
        root.right = right;

        System.out.print(countNodes(root));
    }
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + height(root.left);
    }
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = height(root);
        //if right subtree has height of h-1, then it means that left subtree also has same height and missing leaves are
        //in the right subtree. So we can count the number of leaves in left subtree plus the root and then recursively
        //determine number of nodes in right subtree.
        //If right subtree does not have a height of h-1, then it means that missing leaves are in left subtree. So we
        //can count the number of leaves in right subtree plus the root and then recursively determine number of nodes in
        //left subtree.
        return height(root.right) == h-1 ? (1 << (h-1)) + countNodes(root.right)
                : (1 << (h-2)) + countNodes(root.left);
    }
}
