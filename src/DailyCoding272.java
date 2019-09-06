import javax.rmi.CORBA.Util;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function, throw_dice(N, faces, total), that determines how many ways it is possible to throw N dice with
 * some number of faces each to get a specific total.
 *
 * For example, throw_dice(3, 6, 7) should equal 15
 */
public class DailyCoding272 {
    public static void main(String[] args) {
        System.out.println(numDiceThrow(3, 6, 7)==15);
        System.out.println(numDiceThrowEfficient(3, 6, 7)==15);
    }
    public static int numDiceThrow(int numThrows, int faces, int total) {
        int[] count = new int[1];
        numDiceThrowHelper(numThrows, faces, total, new HashMap<>(), count, 0);
        return count[0];
    }
    public static void numDiceThrowHelper(int numThrows, int faces, int total, HashMap<Integer, Integer> map,
                                          int[] count, int currThrow) {
        if (total == 0 && currThrow == numThrows) {
            count[0] = count[0]+1;
            return;
        }
        if (currThrow == numThrows) {
            return;
        }
        for (int i=1; i<=faces; i++) {
            if (i <= total) {
                int c = map.getOrDefault(i, 0);
                map.put(i, c+1);
                numDiceThrowHelper(numThrows, faces, total-i, map, count, currThrow+1);
                c = map.get(i);
                c--;
                if (c==0) {
                    map.remove(i);
                } else {
                    map.put(i, c);
                }
            }
        }
    }
    public static int numDiceThrowEfficient(int numThrows, int faces, int total) {
        //DP approach
        /* Sum(m, n, X) = Finding Sum (X - 1) from (n - 1) dice plus 1 from nth dice
                            + Finding Sum (X - 2) from (n - 1) dice plus 2 from nth dice
                            + Finding Sum (X - 3) from (n - 1) dice plus 3 from nth dice
                             ...................................................
                             ...................................................
                             ...................................................
                            + Finding Sum (X - m) from (n - 1) dice plus m from nth dice */
        int[][] sums = new int[numThrows+1][total+1];
        for (int i=1; i<=faces; i++) {
            sums[1][i] = 1;
        }
        for (int i=2; i<=numThrows; i++) {
            for (int j=1; j<=total; j++) {
                for (int k=1;k<=faces; k++) {
                    if (k <= j) {
                        sums[i][j] += sums[i-1][j-k];
                    }
                }
            }
        }
        return sums[numThrows][total];
    }
}
