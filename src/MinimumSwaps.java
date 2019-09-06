/**
 * You are given an unordered array of size n consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array
 * in ascending order.
 */
public class MinimumSwaps {
    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{7,1,3,2,4,5,6})==5);
    }
    public static int minimumSwaps(int[] nums) {
        /* We will have n nodes and an edge directed from node i to node j if the element at i’th index must be
        present at j’th index in the sorted array. The graph will now contain many non-intersecting cycles. Now a cycle
        with 2 nodes will only require 1 swap to reach the correct ordering, similarly a cycle with 3 nodes will only
        require 2 swap to do so. Minimum number of swaps will be sum(cycle_size - 1) */
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int swaps=0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                int cycleSize = 0;
                int j = nums[i];
                int index = i;
                do {
                    visited[index] = true;
                    index = j-1;
                    j = nums[index];
                    cycleSize++;
                } while(index!=i);
                swaps+= cycleSize-1;
            }
        }
        return swaps;
    }
}
