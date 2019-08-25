/**
 * Given a circular array, compute its maximum subarray sum in O(n) time. A subarray can be empty, and in this case the
 * sum is 0.
 *
 * For example, given [8, -1, 3, 4], return 15 as we choose the numbers 3, 4, and 8 where the 8 is obtained from
 * wrapping around.
 *
 * Given [-4, 5, 1, 0], return 6 as we choose the numbers 5 and 1.
 */
public class DailyCoding190 {
    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[]{8,-1,3,4})==15);
        System.out.println(maxSumSubArray(new int[]{-4,5,1,0})==6);
    }
    public static int maxSumSubArray(int[] nums) {
        //first find maximum sum sub array considering that the array is not circular
        //then find the minimum sum sub array considering that the array is not circular
        //maximum sum sub array, when the array is circular would be total sum - min sub array sum
        int total = 0, maxSum = Integer.MIN_VALUE, curMax = 0, curMin = 0, minSum = Integer.MAX_VALUE;
        for (int n : nums) {
            curMax = Math.max(curMax+n, n);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin+n, n);
            minSum = Math.min(curMin, minSum);
            total += n;
        }
        //corner case: when all numbers are negative, the maxSum = max(nums) and minSum = sum(nums).
        //max(maxSum, total - minSum) = 0. However, we should be returning 0, representing empty sub array
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : 0;
    }
}

