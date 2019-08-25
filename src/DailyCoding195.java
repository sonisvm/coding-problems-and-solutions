/**
 * Let A be an N by M matrix in which every row and every column is sorted.
 *
 * Given i1, j1, i2, and j2, compute the number of elements of M smaller than M[i1, j1] and larger than M[i2, j2].
 */
public class DailyCoding195 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,7,10,15,20}, {2,6,9,14,22,25}, {3,8,10,15,25,20}, {10,11,12,23,30,35}, {20,25,30,35,40,45}};
        System.out.println(count(matrix, 1, 1, 3, 3));
    }
    public static int count(int[][] matrix, int i1, int j1, int i2, int j2) {
        if (i1 == i2) {
            if (j1 < j2) {
                return countHelper(matrix, i1, j1, i2, j2);
            } else {
                return countHelper(matrix, i2, j2, i1, j1);
            }
        } else if(i1 < i2){
            return countHelper(matrix, i1, j1, i2, j2);
        } else {
            return countHelper(matrix, i2, j2, i1, j1);
        }
    }
    public static int countHelper(int[][] matrix, int i1, int j1, int i2, int j2) {
        int count = 0;
        for (int i=0; i< matrix.length; i++) {
            int start = 0;
            while (start < matrix[0].length && matrix[i][start] < matrix[i1][j1]) {
                start++;
            }
            if (start == matrix[0].length) {
                //there is nothing greater than starting point in this row.
                continue;
            }
            int end = matrix.length-1;
            while (end >=0 && matrix[i][end] > matrix[i2][j2]) {
                end--;
            }
            if (end < 0) {
                //there is nothing less than ending point
                continue;
            }
            count += end - start + 1;
        }
        return count;
    }
}
