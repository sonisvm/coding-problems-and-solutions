import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a k-ary tree, check if it is symmetric
 */
public class DailyCoding237 {
    public static void main(String[] args) {
        //ternary tree
        KTreeNode root = new KTreeNode(1);

        KTreeNode left1 = new KTreeNode(2);
        left1.addChild(new KTreeNode(5));
        left1.addChild(new KTreeNode(6));
        left1.addChild(new KTreeNode(7));

        KTreeNode mid = new KTreeNode(3);
        mid.addChild(new KTreeNode(7));

        KTreeNode right = new KTreeNode(2);
        right.addChild(new KTreeNode(7));
        right.addChild(new KTreeNode(6));
        right.addChild(new KTreeNode(5));

        root.addChild(left1);
        root.addChild(mid);
        root.addChild(right);

        System.out.println("Result: " + isSymmetric(root));


    }

    public static boolean isSymmetric(KTreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<KTreeNode> queue = new LinkedList<>();
        int i, j;
        for (i=0, j=root.children.size()-1; i < j; i++, j--) {
            queue.push(root.children.get(i));
            queue.push(root.children.get(j));
        }

        while (!queue.isEmpty()) {
            KTreeNode t1 = queue.poll();
            KTreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 != null && t2 == null) {
                return false;
            }
            if (t1 == null && t2 != null) {
                return false;
            }

            if (t1.val != t2.val) {
                return false;
            }

            if (t1.children.size() != t2.children.size()) {
                return false;
            }

            int n = t1.children.size();
            for (i=0; i<n; i++) {
                queue.push(t1.children.get(i));
                queue.push(t2.children.get(n-i-1));
            }
        }
        return true;
    }
}
