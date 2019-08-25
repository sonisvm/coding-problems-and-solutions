import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the
 * intervals non-overlapping.
 *
 * Intervals can "touch", such as [0, 1] and [1, 2], but they won't be considered overlapping.
 *
 * For example, given the intervals (7, 9), (2, 4), (5, 8), return 1 as the last interval can be removed and the first
 * two won't overlap.
 */
public class DailyCoding191 {
    public static void main(String[] args) {

    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1.end == i2.end){
                return 0;
            } else if(i1.end < i2.end){
                return -1;
            } else if(i1.end > i2.end){
                return 1;
            }
            return 0;
        });
        int count = 1, end = intervals[0].end;
        /*Find the maximum number of non-overlapping intervals.
        Then substract that from total number to get minimum number of intervals to be removed.*/
        for(int i=1; i < intervals.length; i++){
            if(end <= intervals[i].start){
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length-count;
    }
}
