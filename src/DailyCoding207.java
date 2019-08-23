/**
 * Given an undirected graph G, check whether it is bipartite. Recall that a graph is bipartite if its vertices
 * can be divided into two independent sets, U and V, such that no edge connects vertices of the same set.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j
 * exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges:
 * graph[i] does not contain i, and it doesn't contain any element twice.
 */
public class DailyCoding207 {
    public static void main(String[] args) {
        int[][] graph = new int[4][2];
        graph[0][0] = 1;
        graph[0][1] = 3;
        graph[1][0] = 0;
        graph[1][1] = 2;
        graph[2][0] = 1;
        graph[2][1] = 3;
        graph[3][0] = 0;
        graph[3][1] = 2;

        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        if(graph.length==0){
            return true;
        }

        int[] colors = new int[graph.length];
        for(int i=0; i<graph.length;i++){
            if(colors[i]==0){
                colors[i] = 1;
                if(!DFS(graph, i, colors)){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean DFS(int[][] graph, int n, int[] colors){
        int c = colors[n]==1?2:1;
        for(int i=0; i<graph[n].length; i++){
            if(colors[graph[n][i]]==0){
                colors[graph[n][i]] = c;
                if(!DFS(graph, graph[n][i], colors)){
                    return false;
                }
            } else {
                if(colors[n] == colors[graph[n][i]]){
                    return false;
                }
            }
        }
        return true;
    }
}
