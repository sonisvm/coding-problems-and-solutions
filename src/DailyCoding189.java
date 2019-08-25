import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct.
 *
 * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is
 * [5, 2, 3, 4, 1].
 */
public class DailyCoding189 {
    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[]{5,1,3,5,2,3,4,1})==5);
    }
    public static int longestSubArray(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int start = 0;
        int curr = 0;
        int maxLen = 0;
        while(curr < nums.length) {
            if (numbers.contains(nums[curr])) {
                maxLen = Math.max(maxLen, numbers.size());
                while (nums[start]!= nums[curr]) {
                    numbers.remove(nums[start]);
                    start++;
                }
                numbers.remove(nums[start]);
                start++;
            }
            numbers.add(nums[curr]);
            curr++;
        }
        maxLen = Math.max(maxLen, numbers.size());
        return maxLen;
    }
}
