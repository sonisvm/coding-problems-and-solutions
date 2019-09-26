/**
 * Given a list of integers, write a function that returns the largest sum of
 * non-adjacent numbers. Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
 * [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 *
 * Follow-up: Can you do this in O(N) time and constant space?
 */
public class DailyCoding9 {
    public static void main(String[] args) {
        System.out.println(largestSum(new int[]{2,4,6,2,5}) == 13);
        System.out.println(largestSum(new int[]{5,1,1,5}) == 10);

        System.out.println(largestSumOptimized(new int[]{2,4,6,2,5}) == 13);
        System.out.println(largestSumOptimized(new int[]{5,1,1,5}) == 10);
    }
    public static int largestSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for (int i=1; i<=n ; i++) {
            //if we don't choose the ith number
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);

            //if we choose the ith number
            dp[i][1] = dp[i-1][0]+arr[i-1];
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
    public static int largestSumOptimized(int[] arr) {
        int n = arr.length;

        int prevIncluded = 0, prevExcluded = 0;
        for (int i=0; i<n; i++) {
            int currExcluded = Math.max(prevIncluded, prevExcluded);
            int currIncluded = arr[i] + prevExcluded;
            prevExcluded = currExcluded;
            prevIncluded = currIncluded;
        }
        return Math.max(prevExcluded, prevIncluded);
    }
}
