/**
 * Find the maximum of two numbers without using any if-else statements, branching, or direct comparisons.
 */
public class DailyCoding248 {
    public static void main(String[] args) {
        System.out.println(findMax(5, 8));
        System.out.println(findMax(45, 67));
    }

    public static int findMax(int a, int b) {
        return (a+b+Math.abs(a-b))/2;
    }
}
