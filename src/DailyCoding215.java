import java.util.*;

/**
 * The bottom view of a tree, then, consists of the lowest node at each horizontal distance.
 * If there are two nodes at the same depth and horizontal distance, either is acceptable.
 *
 * Given the root to a binary tree, return its bottom view.
 */

class Depth {
    int depth;
    TreeNode node;
    public Depth(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}

public class DailyCoding215 {
    public static void main(String[] args) {
        printResult(bottomView(input1()));
        printResult(bottomView(input2()));
    }

    public static void printResult(List<Integer> rs) {
        for (int num : rs) {
            System.out.print(num +", ");
        }
        System.out.println("");
    }

    public static TreeNode input2() {
        TreeNode root = new TreeNode(20);

        TreeNode one = new TreeNode(3);
        one.left = new TreeNode(10);
        one.right = new TreeNode(14);

        TreeNode three = new TreeNode(8);
        three.right = one;
        three.left = new TreeNode(5);

        root.left = three;

        TreeNode nine = new TreeNode(22);
        nine.right = new TreeNode(25);

        root.right = nine;
        return root;
    }

    public static TreeNode input1() {
        TreeNode root = new TreeNode(5);

        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(0);

        TreeNode three = new TreeNode(3);
        three.left = one;
        three.right = new TreeNode(4);

        root.left = three;

        TreeNode nine = new TreeNode(9);
        nine.left = new TreeNode(8);

        TreeNode seven = new TreeNode(7);
        seven.left = new TreeNode(6);
        seven.right = nine;

        root.right = seven;
        return root;
    }

    public static List<Integer> bottomView(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        Map<Integer, Depth> depths = new TreeMap<>();
        bottomViewHelper(root, depths, 0, 0);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Depth> entry : depths.entrySet()) {
            result.add(entry.getValue().node.val);
        }
        return result;
    }
    public static void bottomViewHelper(TreeNode node, Map<Integer, Depth> map, int depth, int dist) {
        if (node == null) {
            return;
        }
        if (map.containsKey(dist)) {
            Depth depth1 = map.get(dist);
            if (depth > depth1.depth) {
                map.put(dist, new Depth(depth, node));
            }
        } else {
            map.put(dist, new Depth(depth, node));
        }
        bottomViewHelper(node.left, map, depth+1, dist-1);
        bottomViewHelper(node.right, map, depth+1, dist+1);
    }

}
