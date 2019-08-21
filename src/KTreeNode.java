import java.util.ArrayList;
import java.util.List;

public class KTreeNode {
    int val;
    List<KTreeNode> children;
    public KTreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
    public void addChild(KTreeNode child) {
        children.add(child);
    }
}
