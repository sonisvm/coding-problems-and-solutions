/**
 * Write a program that computes the length of the longest common subsequence of three given strings.
 * For example, given "epidemiologist", "refrigeration", and "supercalifragilisticexpialodocious", it should return 5,
 * since the longest common subsequence is "eieio".
 */
public class DailyCoding209 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("epidemiologist", "refrigeration", "supercalifragilisticexpialodocious") == 5);
    }
    public static int longestCommonSubsequence(String str1, String str2, String str3) {
        int n = str1.length();
        int m = str2.length();
        int o = str3.length();
        int[][][] lcs = new int[n+1][m+1][o+1];
        for (int i=1; i<=n ; i++) {
            for(int j=1; j<=m; j++) {
                for (int k=1; k<=o; k++) {
                    if (str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(k-1)) {
                        lcs[i][j][k] = 1 + lcs[i-1][j-1][k-1];
                    } else {
                        lcs[i][j][k] = Math.max(lcs[i-1][j][k], Math.max(lcs[i][j-1][k], lcs[i][j][k-1]));
                    }
                }
            }
        }
        return lcs[n][m][o];
    }
}
