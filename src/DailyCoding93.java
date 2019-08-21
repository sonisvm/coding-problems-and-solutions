class Result {
    int size;
    boolean isBST;
    TreeNode node;

    public Result(int size, boolean isBST, TreeNode node){
        this.isBST = isBST;
        this.size = size;
        this.node = node;
    }
}
public class DailyCoding93 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);
        System.out.println(largestBST(root).node.val);
    }

    public static Result largestBST(TreeNode root){
        if (root==null){
            return new Result(0, true, null);
        }
        //System.out.println("Entering "+root.val);
        if(root.left == null && root.right == null){
            return new Result(1, true, root);
        }
        Result lSize = largestBST(root.left);
        Result rSize = largestBST(root.right);

        if (lSize.isBST && rSize.isBST && (lSize.size==0 || (root.left.val < root.val)) && (rSize.size == 0 || (root.right.val > root.val))){
            //System.out.println("Returning true with size "+(lSize.size+rSize.size+1));
            return new Result(lSize.size+rSize.size+1, true, root);
        } else {
            //System.out.println("Returning false with size "+Math.max(lSize.size, rSize.size));

            return lSize.size > rSize.size? new Result(lSize.size, false, lSize.node) : new Result(rSize.size, false, rSize.node);
        }
    }
}
