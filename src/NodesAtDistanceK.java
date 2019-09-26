import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  \The answer can be returned
 * in any order.
 */
public class NodesAtDistanceK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode left1 = new TreeNode(5);
        left1.left = new TreeNode(6);

        TreeNode right1 = new TreeNode(2);
        right1.left = new TreeNode(7);
        right1.right = new TreeNode(4);

        left1.right = right1;

        TreeNode right = new TreeNode(1);
        right.left = new TreeNode(0);
        right.right = new TreeNode(8);

        root.left = left1;
        root.right = right;

        List<Integer> result = distanceK(root, new TreeNode(5),2);

        Utility.print(result);
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<Integer, Integer> dist = new HashMap<>();

        //find the dist of nodes from the target, on the path to the target
        findDist(root, target.val, dist);

        //find nodes that are at distance K
        List<Integer> result = new ArrayList<>();
        dfs(root, K, dist, result,0);
        return result;
    }
    public static void dfs(TreeNode root, int K, HashMap<Integer, Integer> dist, List<Integer> result, int length) {
        if(root == null) {
            return;
        }
        if(dist.containsKey(root.val)) {
            length = dist.get(root.val);
        }
        if(length == K) {
            result.add(root.val);
        }

        dfs(root.left, K, dist, result,  length+1);
        dfs(root.right, K, dist,result, length+1);

    }
    public static int findDist(TreeNode root, int target, HashMap<Integer, Integer> dist) {
        if(root == null) {
            return -1; // we haven't found the target in this subtree, so no distance need to be recorded;
        }
        if(root.val == target) {
            dist.put(target, 0);
            return 0;
        }
        int left = findDist(root.left, target, dist);
        if(left >=0) {
            dist.put(root.val, left+1);
            return left+1;
        }

        int right = findDist(root.right, target, dist);
        if(right >=0) {
            dist.put(root.val, right+1);
            return right+1;
        }

        return -1;
    }
}
