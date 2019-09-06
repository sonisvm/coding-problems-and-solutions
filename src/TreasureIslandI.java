import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous
 * reefs. Other areas are safe to sail in.
 * There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
 * Assume the map area is a two dimensional grid, represented by a matrix of characters.
 * You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
 * The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
 * Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks.
 * You cannot leave the map area.
 * Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
 * Output the minimum number of steps to get to the treasure.
 */
class Index{
    int i;
    int j;
    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class TreasureIslandI {
    public static void main(String[] args) {
        char[][] map = {{'O','O','O','O'}, {'D','O','D','O'},{'O','O','O','O'},{'X','D','D','O'}};
        System.out.println(minSteps(map)==5);
    }
    public static int minSteps(char[][] map) {
        Deque<Index> queue = new ArrayDeque<>();

        queue.push(new Index(0, 0));
        int[][] dir = {{0,1}, {0, -1}, {1,0}, {-1,0}};
        map[0][0] = 'D';
        int steps = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Index index = queue.poll();
                for (int j=0; j<dir.length; j++) {
                    int x = index.i + dir[j][0];
                    int y = index.j + dir[j][1];
                    if (isValidToVisit(map, x, y)){
                        if (map[x][y] == 'X') {
                            return steps;
                        }
                        map[x][y] = 'D';
                        queue.add(new Index(x, y));
                    }
                }
            }
            steps++;
        }
        return steps;
    }
    public static boolean isValidToVisit(char[][] map, int x, int y) {
        if (x < 0 || x>=map.length || y <0 || y>=map[0].length) {
            return false;
        }
        if (map[x][y] == 'D') {
            return false;
        }

        return true;
    }
}
