/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * Find the minimum element in O(log N) time. You may assume the array does not contain duplicates.
 */
public class DailyCoding203 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,7,10,3,4}) == 3);
    }
    public static int findMin(int[] nums) {
        int start=0, end=nums.length-1;
        int mid=0;
        while(start <= end){
            //System.out.println("start "+start +" end "+end );
            mid = (start+end)/2;
            int prev = (mid-1+nums.length)%nums.length;
            int next = (mid+1)%nums.length;
            //System.out.println("prev "+nums[prev] +" next "+nums[next]+" mid "+mid);
            if(nums[prev]>=nums[mid] && nums[next]>=nums[mid]){
                break;
            } else {
                if(nums[end] >= nums[mid]){
                    //System.out.println("updating end"+(mid-1));
                    end = mid-1;
                } else if(nums[start] <= nums[mid]){
                    //System.out.println("updating start "+ (mid+1));
                    start= mid+1;
                }

            }
        }
        return nums[mid];
    }
}
