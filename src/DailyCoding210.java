/**
 * A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:
 *
 * if n is even, the next number in the sequence is n / 2
 * if n is odd, the next number in the sequence is 3n + 1
 *
 * It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.
 */
public class DailyCoding210 {
    public static void main(String[] args) {
        testCollatz(5);
    }
    public static void testCollatz(int n) {
        while(n!=1) {
            if(n%2==0) {
                n = n/2;
            } else {
                n = 3*n + 1;
            }
        }
    }
}
