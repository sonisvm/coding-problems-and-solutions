
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 212
 */
class WordTrie {
    WordTrie[] map ;
    String word;
    public WordTrie() {
        map = new WordTrie[26];
        word = null;
    }
}
public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b'},
                {'a', 'a'},
        };

        List<String> result = findWords(board, new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"});

        Utility.printStr(result);
    }
    public static List<String> findWords(char[][] board, String[] words) {

        int r = board.length;
        int c = board[0].length;

        WordTrie root = new WordTrie();
        for (String s : words) {
            insert(root, s);
        }

        List<String> result = new ArrayList<>();
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                dfs(board, i, j, result, root);
            }
        }
        return new ArrayList<>(result);
    }
    public static void insert(WordTrie root, String s) {
        WordTrie cur = root;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (cur.map[c-'a']==null) {
                cur.map[c-'a'] = new WordTrie();
            }
            cur = cur.map[c-'a'];
        }
        cur.word = s;
    }
    public static void dfs(char[][] board, int i, int j, List<String> result, WordTrie root) {
        char c = board[i][j];

        if (c=='#' || root.map[c-'a'] == null){
            return;
        }
        root = root.map[c-'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null; //so that duplicates don't occur
        }

        board[i][j] = '#';
        if (i>0) {
            dfs(board, i-1, j, result, root);
        }
        if (i<board.length-1) {
            dfs(board, i+1, j, result, root);
        }
        if (j > 0) {
            dfs(board, i, j-1, result, root);
        }
        if (j < board[0].length-1) {
            dfs(board, i, j+1, result, root);
        }
        board[i][j] = c;
    }
}
