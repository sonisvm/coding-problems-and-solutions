import java.util.*;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair of elements in the
 * subset (i, j) satisfies either i % j = 0 or j % i = 0.
 * For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20].
 * Given [1, 3, 6, 24], return [1, 3, 6, 24].
 */
public class DailyCoding198 {
    public static void main(String[] args) {
        Utility.print(largestDivisibleSubset(new int[]{3,5,10,20,21}));
        Utility.print(largestDivisibleSubset(new int[]{1,3,6,24}));
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.sort(nums);
        count[0] = 1;
        pre[0] = -1;
        int max = 0;
        int maxIndex = 0;
        for(int i=1; i<nums.length; i++) {
            count[i] = 1;
            pre[i] = -1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i]%nums[j] == 0) {
                    if(count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if(count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(maxIndex!= -1) {
            res.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return res;
    }
}
