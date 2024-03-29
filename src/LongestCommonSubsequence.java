public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace") == 3);
        System.out.println(longestCommonSubsequence("abc", "abc") == 3);
        System.out.println(longestCommonSubsequence("abc", "def") == 0);
    }
    public static int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] lcs = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        return lcs[n][m];
    }
}
