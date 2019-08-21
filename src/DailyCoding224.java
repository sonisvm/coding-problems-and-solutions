/**
 * Given a sorted array, find the smallest positive integer that is not the sum of a subset of the array.
 */
public class DailyCoding224 {
    public static void main(String[] args) {
        System.out.println(smallestInteger(new int[]{1,1,3,4,6,7,9}));
        System.out.println(smallestInteger(new int[]{1,1,1,1,1}));
        System.out.println(smallestInteger(new int[]{2,3,6,7}));
        System.out.println(smallestInteger(new int[]{1,2,6,7,9}));
    }

    public static int smallestInteger(int[] arr) {
        int res = 1; //if we find a gap in the numbers, then final result will be (1+smallest number of the gap)
        for (int val : arr) {
            if (val <= res) {
                res += val;
            } else {
                break;
            }
        }
        return res;
    }
}
