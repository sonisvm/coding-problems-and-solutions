import java.util.List;

/**
 * Utility functions
 */
public class Utility {
    public static void print(List<Integer> list) {
        for (int n : list) {
            System.out.print(n + ", ");
        }
        System.out.println("");
    }
    public static void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n + ", ");
        }
        System.out.println("");
    }
}
