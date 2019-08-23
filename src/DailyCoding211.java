import java.util.ArrayList;
import java.util.List;

/**
 * Given a string and a pattern, find the starting indices of all occurrences of the pattern in the string.
 * For example, given the string "abracadabra" and the pattern "abr", you should return [0, 7].
 */

public class DailyCoding211 {
    public static void main(String[] args) {
        printResult(findIndices("abracadabra", "abr"));
        printResult(findIndices("aaaaa", "aaa"));
        printResult(findIndices("GeeksforGeeks", "Geeks"));

        printResult(findIndicesKMP("abracadabra", "abr"));
        printResult(findIndicesKMP("aaaaa", "aaa"));
        printResult(findIndicesKMP("GeeksforGeeks", "Geeks"));
    }
    public static void printResult(List<Integer> res) {
        for (int n : res) {
            System.out.print(n + ", ");
        }
        System.out.println("");
    }
    public static List<Integer> findIndicesKMP(String str, String pattern) {
        int[] lps = computeLPS(pattern);

        int i=0, j=0;
        int p = pattern.length();
        int n = str.length();
        List<Integer> res = new ArrayList<>();

        while (i < n) {
            if (str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                if (j==p) {
                    res.add(i-j);
                    j = lps[j-1];
                }
            } else {
                if (j==0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
        return res;
    }
    public static int[] computeLPS(String pattern) {
        int i=1;
        int j = 0;
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0] = 0;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }

    public static List<Integer> findIndices(String str, String pattern) {
        int i=0;
        int n = str.length();
        int p = pattern.length();
        List<Integer> indices = new ArrayList<>();
        while (i <= n-p) {
            if (str.charAt(i) == pattern.charAt(0)) {
                int j = i;
                boolean match = true;
                for (int k=0; k<pattern.length(); k++) {
                    if (pattern.charAt(k) != str.charAt(j+k)) {
                        match = false;
                    }
                }
                if (match) {
                    indices.add(j);
                }
            }
            i++;
        }
        return indices;
    }
}
