/**
 * You are given an array of nonnegative integers. Let's say you start at the beginning of the array and are trying to
 * advance to the end. You can advance at most, the number of steps that you're currently on. Determine whether you can
 * get to the end of the array.
 *
 * For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so return true.
 *
 * Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.
 */
public class DailyCoding192 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1,3,1,2,0,1}));
        System.out.println(canJump(new int[]{1,2,1,0,0}));
    }
    public static boolean canJump(int[] nums) {
        boolean[] possible = new boolean[nums.length];
        if(nums.length==0){
            return true;
        }
        possible[0]=true;
        for(int i=0; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(possible[j]){
                    possible[i] = j+nums[j]>=i;
                    if(possible[i]){
                        break;
                    }
                }
            }
        }
        return possible[possible.length-1];
    }
}
