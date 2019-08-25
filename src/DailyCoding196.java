import java.util.*;

/**
 * Given the root of a binary tree, find the most frequent subtree sum. The subtree sum of a node is the sum of all
 * values under a node, including the node itself.
 *
 *   5
 *  / \
 * 2  -5
 *
 * Return 2 as it occurs twice: once as the left leaf, and once as the sum of 2 + 5 - 5.
 */

public class DailyCoding196 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        Utility.print(findFrequentTreeSum(root));
    }
    public static int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int[] maxCount = {0};
        findFrequentTreeSumHelper(root, counts, maxCount);
        List<Integer> rs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxCount[0]) {
                rs.add(entry.getKey());
            }
        }
        int[] res = new int[rs.size()];
        for (int i=0; i<rs.size(); i++) {
            res[i] = rs.get(i);
        }
        return res;
    }
    public static int findFrequentTreeSumHelper(TreeNode root, HashMap<Integer, Integer> counts, int[] maxCount) {
        if (root == null) {
            return 0;
        }
        int left = findFrequentTreeSumHelper(root.left, counts, maxCount);
        int right = findFrequentTreeSumHelper(root.right, counts, maxCount);

        int total = root.val + left + right;
        int count = counts.getOrDefault(total, 0);
        counts.put(total, count+1);
        maxCount[0] = Math.max(maxCount[0], count+1);
        return total;
    }
}

