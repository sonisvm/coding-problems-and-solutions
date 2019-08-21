/**
 * The Sieve of Eratosthenes is an algorithm used to generate all prime numbers smaller than N.
 * The method is to take increasingly larger prime numbers, and mark their multiples as composite.
 * Implement this algorithm.
 */
public class DailyCoding244 {
    public static void main(String[] args) {
        sieveOfEratosthenes(15);
    }
    public static void sieveOfEratosthenes(int n) {
        int[] sieve = new int[n+1];
        for (int i=2; i<=n; i++) {
            if (sieve[i]!=1) {
                for (int j=2; j*i <=n; j++) {
                    sieve[j*i] = 1;
                }
            }
        }
        for (int i=2; i<=n; i++) {
            if (sieve[i] != 1) {
                System.out.print(i + " ");
            }
        }
    }
}
