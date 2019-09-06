import java.util.*;

/**
 * Find the cost of the minimum spanning tree
 */
class Vertex {
    int node;
    int dist;
    public Vertex(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Edge {
    int src;
    int dest;
    int weight;
    public Edge(int src, int dest, int weight) {
        this.dest = dest;
        this.src = src;
        this.weight = weight;
    }
}
class Subset {
    int parent;
    int rank;
}
public class MinimumSpanningTree {
    public static void main(String[] args) {
        int[][] graph = { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
        System.out.println(costMSTPrim(graph)==16);
        System.out.println(costMSTKruskal(graph)==16);
    }
    public static int costMSTKruskal(int[][] graph) {
        List<Edge> edges = new ArrayList<>();
        for (int i=0; i<graph.length; i++) {
            for (int j=0;j<=i; j++) {
                if (graph[i][j]!=0){
                    edges.add(new Edge(i, j, graph[i][j]));
                }

            }
        }
        //sort the edges according to weight
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int numEdges = 0, index=0, totalCost=0;
        Subset[] subsets = new Subset[graph.length];
        for (int i=0; i< subsets.length; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        List<Edge> mst = new ArrayList<>();

        //keep adding edges until we have V-1 edges
        while (numEdges < graph.length-1) {
            Edge e = edges.get(index);

            int root1 = find(subsets, e.src);
            int root2 = find(subsets, e.dest);

            if (root1 != root2) {
                //there won't be a cycle formed by adding this edge
                mst.add(e);
                totalCost+= e.weight;
                union(subsets, root1, root2);
                numEdges++;
            }
            index++;
        }
        return totalCost;
    }
    public static int find(Subset[] subsets, int x){
        if (subsets[x].parent == x) {
            return x;
        }
        subsets[x].parent = find(subsets, subsets[x].parent);
        return subsets[x].parent;
    }
    public static void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank == subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        } else if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else {
            subsets[yroot].parent = xroot;
        }
    }
    public static int costMSTPrim(int[][] graph) {
        //The cost of the MST will be the same regardless of the starting node. However, shape of the MST
        //will be different
        PriorityQueue<Vertex> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.dist == o2.dist){
                return 0;
            } else if(o1.dist > o2.dist) {
                return 1;
            } else {
                return -1;
            }
        });
        int[] dist = new int[graph.length];
        dist[0] = 0;
        for (int i=1; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[graph.length];
        queue.add(new Vertex(0, dist[0]));
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            visited[v.node] = true;
            for (int i=0; i<graph[0].length; i++) {
                if (!visited[i] && graph[v.node][i]!=0) {
                    if (dist[i] > graph[v.node][i]) {

                        dist[i] = graph[v.node][i];
                        queue.add(new Vertex(i, dist[i]));
                    }
                }
            }
        }
        int cost = 0;
        for (int i=0; i<dist.length; i++) {
            if (dist[i]!=Integer.MAX_VALUE) {
                cost += dist[i];
            }
        }
        return cost;
    }
}
