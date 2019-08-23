import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of arrays of integers, where each array corresponds to a row in a triangle of numbers.
 * For example, [[1], [2, 3], [1, 5, 1]] represents the triangle:
 *
 *   1
 *  2 3
 * 1 5 1
 *
 * We define a path in the triangle to start at the top and go down one row at a time to an adjacent value,
 * eventually ending with an entry on the bottom row. For example, 1 -> 3 -> 5. The weight of the path is the sum of
 * the entries.
 *
 * Write a program that returns the weight of the maximum weight path.
 */

public class DailyCoding201 {
    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(3);

        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(5);
        row3.add(1);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);

        System.out.println(maxPathSum(triangle) == 9);
    }
    public static int maxPathSum(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        return maxPathSumHelper(triangle, 0, 0);
    }
    public static int maxPathSumHelper(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        return triangle.get(row).get(col) + Math.max(maxPathSumHelper(triangle, row+1, col), maxPathSumHelper(triangle,
                row+1, col+1));
    }
}
