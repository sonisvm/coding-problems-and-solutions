import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose you are given two lists of n points, one list p1, p2, ..., pn on the line y = 0 and the other
 * list q1, q2, ..., qn on the line y = 1. Imagine a set of n line segments connecting each point pi to qi.
 * Write an algorithm to determine how many pairs of the line segments intersect.
 */
class LPoint {
    int x;
    int y;
    public LPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class DailyCoding194 {
    public static void main(String[] args) {
        System.out.println(numInversions(new int[]{2,4,1,3,5}) == 3);
        System.out.println(numInversions(new int[]{1, 20, 6, 4, 5}) == 5);
    }
    public static int intersections(int[] p, int[] q) {
        List<LPoint> points = new ArrayList<>();
        for (int i=0; i<p.length; i++) {
            points.add(new LPoint(p[i], q[i]));
        }
        Collections.sort(points, (o1, o2) -> {
            if (o1.x == o2.x) {
                return 0;
            } else if (o1.x > o2.x) {
                return 1;
            } else {
                return -1;
            }
        });
        int[] sorted = new int[q.length];
        for (int i=0; i<points.size(); i++) {
            sorted[i] = points.get(i).y;
        }
        return numInversions(sorted);
    }
    public static int numInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length-1);
    }
    public static int mergeSort(int[] arr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end)/2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid+1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }
    public static int merge(int[] arr, int start, int mid, int end) {
        int n = end-start+1;
        int[] tmp = new int[n];
        int l = start, r = mid+1;
        int k = 0, count = 0;
        while (l <= mid && r<=end) {
            if (arr[l] <= arr[r]) {
                tmp[k] = arr[l];
                l++;
                k++;
            } else {
                count += (mid - l + 1);
                tmp[k] = arr[r];
                r++;
                k++;
            }
        }
        while (l <= mid) {
            tmp[k] = arr[l];
            k++;
            l++;
        }
        while (r<=end) {
            tmp[k] = arr[r];
            r++;
            k++;
        }
        for (int i=start; i<=end; i++) {
            arr[i] = tmp[i-start];
        }
        return count;
    }
}
