/**
 * A permutation can be specified by an array P, where P[i] represents the location of the element at i in the
 * permutation. For example, [2, 1, 0] represents the permutation where elements at the index 0 and 2 are swapped.
 *
 * Given an array and a permutation, apply the permutation to the array. For example, given the array ["a", "b", "c"]
 * and the permutation [2, 1, 0], return ["c", "b", "a"].
 */
public class DailyCoding206 {
    public static void main(String[] args) {
        printArray(permutate(new String[]{"a", "b", "c"}, new int[]{2, 1, 0}));
        printArray(permutate(new String[]{"50", "40", "70", "60", "90"}, new int[]{3, 0, 4, 1, 2}));
    }
    public static void printArray(String[] res) {
        for (String s : res) {
            System.out.print(s + ", ");
        }
        System.out.println("");
    }
    public static String[] permutate(String[] original, int[] permutation) {
        int n = original.length;
        String[] permutated = new String[n];
        for (int i=0; i<permutation.length; i++) {
            permutated[permutation[i]] = original[i];
        }
        return permutated;
    }
    public static String[] permutateInPlace(String[] original, int[] permutation) {
        for (int i=0; i<permutation.length; i++) {
            while (permutation[i] != i) {
                int oldPerm = permutation[permutation[i]];
                String old = original[permutation[i]];

                permutation[permutation[i]] = permutation[i];
                original[permutation[i]] = original[i];

                original[i] = old;
                permutation[i] = oldPerm;
            }
        }
        return original;
    }
}
