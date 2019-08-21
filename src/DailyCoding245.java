/**
 * You are given an array of integers, where each element represents the maximum number of steps that can be
 * jumped going forward from that element. Write a function to return the minimum number of jumps you must
 * take in order to get from the start to the end of the array.
 */
public class DailyCoding245 {
    public static void main(String[] args) {
        System.out.println(minSteps(new int[]{6,2,4,0,5,1,1,4,2,9}));
        System.out.println(minSteps(new int[]{1,3,5,8,9,2,6,7,6,8,9}));
    }
    public static int minSteps(int[] nums) {
        int[] minSteps = new int[nums.length];
        minSteps[0] = 0;
        for (int i=1; i<minSteps.length; i++) {
            minSteps[i] = Integer.MAX_VALUE;
            for (int j=i-1; j>=0; j--) {
                if (minSteps[j] != Integer.MAX_VALUE) {
                    if (i <= j + nums[j]) {
                        minSteps[i] = Math.min(minSteps[j] + 1, minSteps[i]);
                    }
                }
            }
            //System.out.println(i+" " + minSteps[i]);
        }
        return minSteps[nums.length-1];
    }
}
