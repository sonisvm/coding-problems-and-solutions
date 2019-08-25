/**
 * Given an array and a number k that's smaller than the length of the array, rotate the array to the right
 * k elements in-place.
 */
public class DailyCoding197 {
    public static void main(String[] args) {
        Utility.print(rotate(new int[]{1,2,3,4,5,6,7}, 3));
    }
    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int displaced = 0;
        for(int i=0; displaced < n; i++) {
            int current = i;
            int value = nums[i];
            do {
                int index = (i+k)%n;
                int replaced = nums[index];
                nums[index] = value;
                i = index;
                value = replaced;
                displaced++;
            } while (i != current);
        }
        return nums;
    }
}
