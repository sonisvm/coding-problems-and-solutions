import java.util.ArrayDeque;
import java.util.Deque;


public class DailyCoding36 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node = new TreeNode(3);
        root.left = node;

        node = new TreeNode(7);
        TreeNode lnode = new TreeNode(6);
        node.left = lnode;
        //lnode = new TreeNode(8);
        //node.right = lnode;

        root.right = node;

        print(root);

        System.out.println("Second largest node="+secondLargest(root));
    }
    public static void print(TreeNode root){
        if(root == null){
            return;
        }
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }
    public static int secondLargest(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode tmp = root;
        int k = 2, result = -1;
        while(!stack.isEmpty() || tmp!=null){
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.right;
            }
            tmp = stack.pop();
            k--;
            if (k==0){
                result = tmp.val;
                break;
            }
            tmp = tmp.left;
        }
        return result;
    }
}
