/**
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.
 *
 * (A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of
 * its values, divided by the number of nodes.)
 */
class Result1 {
    int sum;
    int num;
    public Result1(int sum, int num) {
        this.sum = sum;
        this.num = num;
    }
}
public class MaximumAverageSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);

        System.out.println(maximumAverageSubtree(root)==6.0);
    }
    public static double maximumAverageSubtree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        double[] maxAvg = new double[1];
        maximumAverageSubtreeHelper(root,maxAvg);
        return maxAvg[0];
    }
    public static Result1 maximumAverageSubtreeHelper(TreeNode root, double[] maxAvg) {
        if(root==null) {
            return new Result1(0, 0);
        }
        Result1 left = maximumAverageSubtreeHelper(root.left, maxAvg);
        Result1 right = maximumAverageSubtreeHelper(root.right, maxAvg);

        int totalSum = left.sum + right.sum + root.val;
        int totalNum = left.num + right.num + 1;
        if(((double)totalSum/totalNum) > maxAvg[0]) {
            maxAvg[0] = (double)totalSum/totalNum;
        }
        //System.out.println(totalSum + " "+ totalNum);
        return new Result1(totalSum, totalNum);
    }
}
