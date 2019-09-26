/**
 * Morris Traversal traverses the tree in-order in O(1) space and O(n) time
 */
public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        root.left = left;
        root.right = new TreeNode(3);

        traversal(root);
    }
    public static void traversal(TreeNode root) {
        TreeNode cur = root;
        while (cur!=null) {
            if (cur.left == null) {
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                TreeNode pred = getPredecessor(cur);

                if (pred.right==null){
                    /* the predecessor was found for the first time. so we need to link it to current node*/
                    pred.right = cur;
                    cur = cur.left;
                } else {
                    /* we have come back to the cur node after traversing left subtree. Remove the link added
                    previously*/
                    pred.right = null;
                    System.out.print(cur.val +" ");
                    cur = cur.right;
                }
            }
        }
    }
    public static TreeNode getPredecessor(TreeNode root) {
        TreeNode tmp = root.left;
        while (tmp.right!=null && tmp.right!=root) {
            tmp = tmp.right;
        }
        return tmp;
    }
}
