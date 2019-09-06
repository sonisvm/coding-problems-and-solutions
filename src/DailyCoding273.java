/**
 * A fixed point in an array is an element whose value is equal to its index. Given a sorted array of distinct elements,
 * return a fixed point, if one exists. Otherwise, return -1.
 *
 * For example, given [-6, 0, 2, 40], you should return 2. Given [1, 5, 7, 8], you should return -1.
 */
public class DailyCoding273 {
    public static void main(String[] args) {
        System.out.println(findFixedPoint(new int[]{-6,0,2,40})==2);
        System.out.println(findFixedPoint(new int[]{1,5,7,8})==-1);
    }
    public static int findFixedPoint(int[] nums) {
        int start = 0, end = nums.length;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == mid){
                return mid;
            } else if (nums[mid] < mid) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
