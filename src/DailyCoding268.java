/**
 * Given a 32-bit positive integer N, determine whether it is a power of four in faster than O(log N) time
 */
public class DailyCoding268 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }
    public static boolean isPowerOfFour(int n) {
        //num & (num-1) == 0 will be true for powers of 2
        //num & 0x55555555 == num only for powers of 4, since powers of 4 have only one
        //1 and it is in an odd place.
        return n > 0 && (n & (n-1)) == 0 && ((n & 0x55555555) == n);
    }
}
