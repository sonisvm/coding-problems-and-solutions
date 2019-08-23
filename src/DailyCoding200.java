import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Let X be a set of n intervals on the real line. We say that a set of points P "stabs" X if every interval
 * in X contains at least one point in P. Compute the smallest set of points that stabs X.
 *
 * For example, given the intervals [(1, 4), (4, 5), (7, 9), (9, 12)], you should return [4, 9].
 */
class Interval {
    int start;
    int end;
    Interval(int x, int y) {
        this.start = x;
        this.end = y;
    }
}
public class DailyCoding200 {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(4,5));
        intervals.add(new Interval(7,9));
        intervals.add(new Interval(9,12));

        printResult(minStabSet(intervals));
    }
    public static void printResult(List<Integer> res) {
        for (int n : res) {
            System.out.print(n +", ");
        }
        System.out.println("");
    }
    public static List<Integer> minStabSet(List<Interval> intervals) {
        List<Integer> res = new ArrayList<>();

        //sort based on endpoints
        Collections.sort(intervals, (o1, o2) -> {
            if(o1.end == o2.end) {
                return 0;
            } else if (o1.end > o2.end) {
                return 1;
            } else {
                return -1;
            }
        });

        int endpt = intervals.get(0).end;
        boolean[] stabbed = new boolean[intervals.size()];
        boolean allDone = false;
        while (!allDone) {
            res.add(endpt);
            for (int i=0; i<intervals.size(); i++) {
                if (!stabbed[i] && endpt >= intervals.get(i).start && endpt <= intervals.get(i).end) {
                    stabbed[i] = true;
                }
            }
            //find the next endpt
            int newEntpt = -1;
            for (int i=0; i<intervals.size(); i++) {
                if (!stabbed[i]){
                    newEntpt = intervals.get(i).end;
                    break;
                }
            }
            if (newEntpt==-1) {
                allDone = true;
            }
            endpt = newEntpt;
        }
        return res;
    }
}
