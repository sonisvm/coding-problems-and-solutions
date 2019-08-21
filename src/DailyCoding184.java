/**
 * Given n numbers, find the greatest common denominator between them.
 */
public class DailyCoding184 {
    public static void main(String[] args) {
        System.out.println(gcdN(new int[]{56, 42, 14}));
    }

    public static int gcdN(int[] nums) {
        //gcd(a, b, c) = gcd(a, gcd(b, c))
        if (nums.length == 0) {
            return 0;
        }
        return gcdNHelper(nums, 0, nums.length-1);
    }

    public static int gcdNHelper(int[] nums, int start, int end) {
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end)/2;
        return gcd(gcdNHelper(nums, start, mid), gcdNHelper(nums, mid+1, end));
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        if (a > b) {
            return gcd(a-b, b);
        } else {
            return gcd(b-a, a);
        }
    }
}
