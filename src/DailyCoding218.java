import java.util.*;

/**
 * Write an algorithm that computes the reversal of a directed graph
 */
class Graph {
    HashMap<Integer, LinkedList<Integer>> adjList;
    public Graph() {
        adjList = new HashMap<>();
    }
}
public class DailyCoding218 {
    public static void main(String[] args) {
        Graph org = new Graph();

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        org.adjList.put(1, list1);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(3);

        org.adjList.put(2, list2);
        printGraph(reverse(org));
    }
    public static void printGraph(Graph graph) {
        for (Map.Entry<Integer, LinkedList<Integer>> entry : graph.adjList.entrySet()) {
            System.out.println("Node " + entry.getKey());

            Iterator<Integer> it = entry.getValue().iterator();
            System.out.println("Linked to : ");
            while (it.hasNext()) {
                System.out.print(it.next()+" ");
            }
        }
    }
    public static Graph reverse(Graph graph) {
        Graph rev = new Graph();

        for (Map.Entry<Integer, LinkedList<Integer>> list : graph.adjList.entrySet()) {
            int node = list.getKey();
            while(!list.getValue().isEmpty()) {
                int startNode = list.getValue().poll();
                LinkedList<Integer> revList = rev.adjList.getOrDefault(startNode, new LinkedList<>());
                revList.add(node);
                rev.adjList.put(startNode, revList);
            }
        }
        return rev;
    }
}
