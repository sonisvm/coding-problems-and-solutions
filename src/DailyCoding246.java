import java.util.ArrayList;
import java.util.List;

public class DailyCoding246 {
    public static void main(String[] args) {
        List<String> input1 = new ArrayList<>();
        input1.add("geek");
        input1.add("king");

        System.out.println(isCircle(input1));

        List<String> input2 = new ArrayList<>();
        input2.add("geek");
        input2.add("rig");
        input2.add("for");
        input2.add("kaf");

        System.out.println(isCircle(input2));

        List<String> input3 = new ArrayList<>();
        input3.add("aaa");
        input3.add("bbb");
        input3.add("baa");
        input3.add("aab");

        System.out.println(isCircle(input3));

        List<String> input4 = new ArrayList<>();
        input4.add("aaa");

        System.out.println(isCircle(input4));

        List<String> input5 = new ArrayList<>();
        input5.add("aaa");
        input5.add("bbb");

        System.out.println(isCircle(input5));
    }
    public static boolean isCircle(List<String> words) {
        if (words.size() == 1) {
            return words.get(0).charAt(words.get(0).length()-1) == words.get(0).charAt(0);
        }
        int[][] graph = new int[words.size()][words.size()];
        for (int i=0; i< graph.length; i++) {
            for (int j=0; j< graph[0].length; j++) {
                String first = words.get(i);
                String second = words.get(j);
                if (first.charAt(first.length()-1) == second.charAt(0)){
                    graph[i][j] = 1;
                }
            }
        }
        boolean[] visited = new boolean[words.size()];
        return dfs(graph, 0, visited);
    }
    public static boolean dfs(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        for(int i=0; i<graph[0].length; i++){
            if(i != node && graph[node][i] == 1) {
                if(!visited[i]) {
                    if(dfs(graph, i, visited)) {
                        return true;
                    }
                } else {
                    if(i==0) {
                        boolean covered = true;
                        for (boolean flag : visited) {
                            covered = covered && flag;
                        }
                        return covered;
                    }
                }
            }
        }
        return false;
    }
}
