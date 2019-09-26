import java.util.*;

/**
 * Leetcode 642
 */

class SearchTrie {
    HashMap<Character, SearchTrie> map;
    boolean isEnd;
    int hotness;
    public SearchTrie() {
        map = new HashMap<>();
        hotness = 0;
    }
}
class AutocompleteSystem {
    SearchTrie root;
    StringBuilder searchStr;
    SearchTrie searchNode;
    List<String> results;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new SearchTrie();
        for(int i=0; i<sentences.length; i++) {
            insert(root, sentences[i], times[i], 0);
        }
        searchStr = new StringBuilder();
        results = new ArrayList<>();
        searchNode = root;
    }

    public List<String> input(char c) {
        if(c=='#') {
            if(searchNode!=null) {
                searchNode.hotness++;
                searchNode.isEnd = true;
            } else {
                insert(root, searchStr.toString(), 1, 0);
            }
            results = new ArrayList<>();
            searchStr = new StringBuilder();
            searchNode = root;
        } else {
            searchStr.append(c);
            searchNode = searchNode!=null ? searchNode.map.getOrDefault(c, null) : null;
            results = new ArrayList<>();

            if (searchNode != null) {

                PriorityQueue<String[]> q = new PriorityQueue<>((o1, o2) -> {
                    int h1 = Integer.parseInt(o1[1]);
                    int h2 = Integer.parseInt(o2[1]);
                    if(h1 == h2) {
                        return o1[0].compareTo(o2[0]);
                    } else if (h1 < h2) {
                        return 1;
                    } else {
                        return -1;
                    }

                });

                findSentences(searchNode, searchStr, q);
                List<String> res = new ArrayList<>();
                while (!q.isEmpty()) {
                    res.add(q.poll()[0]);
                }

                results.addAll(res);
            }
        }

        return results.size() > 3 ? results.subList(0,3) : results;
    }

    private void findSentences(SearchTrie node, StringBuilder str, PriorityQueue<String[]> q) {
        if (node.isEnd) {
            q.add(new String[]{str.toString(),node.hotness+""});
        }

        for (Map.Entry<Character, SearchTrie> entry : node.map.entrySet()) {
            str.append(entry.getKey());
            findSentences(entry.getValue(), str, q);
            str.deleteCharAt(str.length()-1);
        }

    }

    private void insert(SearchTrie root, String word, int hotness, int index) {
        if(index == word.length()) {
            root.isEnd = true;
            root.hotness += hotness;
            return;
        }
        root.map.putIfAbsent(word.charAt(index), new SearchTrie());
        insert(root.map.get(word.charAt(index)), word, hotness, index+1);
    }

}
public class SearchAutoCompleteSystem {
    public static void main(String[] args) {
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(
                new String[]{"abc", "abbc", "a"},
                new int[] {3,3,3});

        List<String> param_1 = autocompleteSystem.input('b');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('c');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('#');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('b');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('c');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('#');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('a');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('b');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('c');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('#');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('a');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('b');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('c');
        Utility.printStr(param_1);

        param_1 = autocompleteSystem.input('#');
        Utility.printStr(param_1);
    }
}
