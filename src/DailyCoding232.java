class PrefixTrieNode {
    boolean isWord;
    PrefixTrieNode[] children;
    int value;
    public PrefixTrieNode(){
        this.isWord = false;
        children = new PrefixTrieNode[26];
    }
}
class PrefixSumMap {
    PrefixTrieNode root;

    public PrefixSumMap() {
        root = new PrefixTrieNode();
    }

    private void insert(PrefixTrieNode node, String key, int index, int value) {
        if (index == key.length()) {
            node.isWord = true;
            node.value = value;
            return;
        }
        char c = key.charAt(index);
        if (node.children[c-'a'] == null) {
            node.children[c-'a'] = new PrefixTrieNode();
        }
        insert(node.children[c-'a'], key, index+1, value);
    }

    public void insert(String key, int value) {
        insert(root, key, 0, value);
    }

    private PrefixTrieNode findPrefixNode(PrefixTrieNode node, String prefix, int index) {
        if (node == null) {
            return null;
        }
        if (index == prefix.length()) {
            return node;
        }
        char c = prefix.charAt(index);
        return findPrefixNode(node.children[c-'a'], prefix, index+1);
    }

    private int calculateValue(PrefixTrieNode node) {
        int sum = node.value;
        for (PrefixTrieNode child : node.children) {
            if (child != null) {
                sum += calculateValue(child);
                //System.out.println("sum " + sum);
            }
        }
        return sum;
    }

    public int sum(String prefix) {
        PrefixTrieNode prefixNode = findPrefixNode(root, prefix, 0);
        if (prefixNode == null) {
            return 0;
        }
        return calculateValue(prefixNode);

    }
}
public class DailyCoding232 {
    public static void main(String[] args) {
        PrefixSumMap map = new PrefixSumMap();
        map.insert("columnnar", 3);

        System.out.println(map.sum("col"));

        map.insert("column", 2);
        map.insert("columnar", 4);

        System.out.println(map.sum("col"));
    }
}
