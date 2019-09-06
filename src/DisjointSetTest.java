class DisjointSet {
    int[] parent;
    int[] rank;
    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        for (int i=0; i<parent.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public void union(int x, int y) {
        if (parent[x] != parent[y]) {
            int xroot = find(x);
            int yroot = find(y);
            if (rank[xroot] < rank[yroot]) {
                parent[xroot] = yroot;
            } else if (rank[yroot] < rank[xroot]){
                parent[yroot] = xroot;
            } else {
                parent[yroot] = xroot;
                rank[xroot]++;
            }
        }
    }
    public int find(int y) {
        if (parent[y] == y) {
            return y;
        }
        parent[y] = find(parent[y]); // path compression, adding the current node directly under representative node
        return parent[y];
    }
}
public class DisjointSetTest {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);
        ds.union(1,2);
        ds.union(2,3);
        System.out.println(ds.find(1) == ds.find(3));
    }
}
