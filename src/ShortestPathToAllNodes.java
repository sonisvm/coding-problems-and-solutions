import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathToAllNodes {
    public static void main(String[] args) {
        int[][] graph = {{ 0, 4, 0, 0, 0, 0, 0, 8, 0},
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }};

        int[] dist = DijkstraSP(graph, 0);

        for (int i =0; i< dist.length; i++) {
            System.out.println("Vertex: " + i +" Dist: "+ dist[i]);
        }
    }
    public static int[] DijkstraSP(int[][] graph, int src){
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[1]-b[1]);
        queue.add(new int[]{src, 0});
        dist[src]=0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]] = true;
            int node = curr[0];
            for (int i=0; i< n; i++) {
                if (!visited[i] && graph[node][i] != 0 && dist[i] > dist[node] + graph[node][i]){
                    dist[i] = dist[node] + graph[node][i];
                    queue.add(new int[]{i, dist[i]});
                }
            }
        }
        return dist;
    }
}
