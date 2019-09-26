/**
 * A binary tree is level order sorted (Each level is sorted). Find a given node.
 * It is a full binary tree. The left and right edges are sorted.
 * Could you do better than O(n).
 */
public class FindNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(8);
        left.right = new TreeNode(9);

        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(10);
        right.right = new TreeNode(11);

        root.left = left;
        root.right = right;

        System.out.println(findNode(root, 10));
        System.out.println(findNode(root, 6));
    }
    public static int findNode(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }

        //find the level in which the element may appear
        TreeNode tmp = root;
        int level = 0;
        while(tmp.left!=null && tmp.left.val <= val) {
            tmp = tmp.left;
            level++;
        }

        //Number of nodes in the level
        int count = (int)Math.pow(2, level);


        int start = 0, end = count-1;
        while (start <= end) {
            int mid = (start + end)/2;
            int divPt = count/2; // this needs to be set everytime since we are traversing from root all over again
            int pos = mid;
            tmp = root;
            for (int l=0; l<level; l++) {
                int dir = pos/divPt;

                if(dir == 0) {
                    tmp = tmp.left;
                } else {
                    tmp = tmp.right;
                    pos -= divPt;
                }
                divPt /= 2;
            }

            if (val == tmp.val) {
                break;
            } else if (val > tmp.val) {
                start = mid+1;
            } else {
                end = mid -1;
            }
        }
        return val == tmp.val ? val : -1;
    }
}
