/**
 * Let's define a "sevenish" number to be one which is either a power of 7, or the sum of unique powers of 7.
 * The first few sevenish numbers are 1, 7, 8, 49, and so on. Create an algorithm to find the nth sevenish number.
 */
public class DailyCoding221 {
    public static void main(String[] args) {
        System.out.println(sevenishNumber(3));
        System.out.println(sevenishNumber(4));
        System.out.println(sevenishNumber(5));
    }
    public static int sevenishNumber(int n) {
        if (n==1) {
            return 1;
        }
        if (n%2 != 0) {
            return sumOfPowers(n/2);
        } else {
            return (int)Math.pow(7, n/2);
        }
    }
    public static int sumOfPowers(int n) {
        int sum=0;
        for (int i=0; i<=n; i++) {
            sum += Math.pow(7, i);
        }
        return sum;
    }
}
