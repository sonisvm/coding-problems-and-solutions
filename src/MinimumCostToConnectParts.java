import java.util.PriorityQueue;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect
 * two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.
 */
public class MinimumCostToConnectParts {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{4,3,2,6})==29);
    }
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> lengths = new PriorityQueue<>();
        for (int n : ropes) {
            lengths.add(n);
        }
        int total = 0;
        while (lengths.size() > 1) {
            //take the minimum and the second minimum. Add them and put it back into queue
            int min = lengths.poll();
            int secondMin = lengths.poll();
            total += min+secondMin;
            lengths.add(min+secondMin);
        }
        return total;
    }
}
