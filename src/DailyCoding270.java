import java.util.Deque;
import java.util.LinkedList;

/**
 * A network consists of nodes labeled 0 to N. You are given a list of edges (a, b, t), describing the time t it takes
 * for a message to be sent from node a to node b. Whenever a node receives a message, it immediately passes the message
 * on to a neighboring node, if possible.
 *
 * Assuming all nodes are connected, determine how long it will take for every node to receive a message that begins
 * at node 0.
 *
 * For example, given N = 5, and the following edges:
 *
 * edges = [
 *     (0, 1, 5),
 *     (0, 2, 3),
 *     (0, 5, 4),
 *     (1, 3, 8),
 *     (2, 3, 1),
 *     (3, 5, 10),
 *     (3, 4, 5)
 * ]
 * You should return 9, because propagating the message from 0 -> 2 -> 3 -> 4 will take that much time.
 */
class QEntry{
    int node;
    int dist;
    public QEntry(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
public class DailyCoding270 {
    public static void main(String[] args) {
        int[][] edges = {{0,1,5}, {0,2,3}, {0,5,4}, {1,3,8}, {2,3,1}, {3,5,10}, {3,4,5}};
        System.out.println(propagationTime(edges,5));

    }
    public static int propagationTime(int[][] edges, int n) {
        Deque<QEntry> queue = new LinkedList<>();
        queue.push(new QEntry(0, 0));
        boolean[] visited = new boolean[n+1];
        int maxTime = 0;
        while(!queue.isEmpty()) {
            QEntry node = queue.poll();
            for (int i=0; i<edges.length; i++) {
                if (edges[i][0] == node.node && !visited[edges[i][1]]) {
                    visited[edges[i][1]] = true;
                    queue.push(new QEntry(edges[i][1], node.dist + edges[i][2]));
                    //System.out.println(node.node + " " + edges[i][1] + " " + (node.dist+edges[i][2]));
                    maxTime = Math.max(maxTime, node.dist+edges[i][2]);
                }
            }
        }
        return maxTime;
    }
}
