/**
 * Given an integer n, return the length of the longest consecutive run of 1s in its binary representation.
 */
public class DailyCoding214 {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(156)==3);
    }
    public static int maxConsecutiveOnes(int n) {
        int max = 0, len = 0;
        while (n!=0) {
            if ((n&1)==1) {
                len++;
            } else {
                max = Math.max(len, max);
                len = 0;
            }
            n = n >> 1;
        }
        return Math.max(max, len);
    }
}
