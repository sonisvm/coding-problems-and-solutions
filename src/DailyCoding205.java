/**
 * Given an integer, find the next permutation of it in absolute order. For example, given 48975,
 * the next permutation would be 49578.
 */
public class DailyCoding205 {
    public static void main(String[] args) {
        System.out.println(nextPermutation(48975) == 49578);
    }
    public static int nextPermutation(int num) {
        String strVersion = "" + num;
        //find an index i such that num[i] < num[i+1] starting from rightmost position.
        //if such an index is not found, then there is not next permutation
        int j = -1;
        char[] charArr = strVersion.toCharArray();
        for (int i=charArr.length-2; i>=0; i--) {
            int num1 = charArr[i] - '0';
            int num2 = charArr[i+1] - '0';
            if (num1 < num2) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return -1;
        }
        //swap num[j] and num[j+1]
        char tmp = charArr[j+1];
        charArr[j+1] = charArr[j];
        charArr[j] = tmp;

        //reverse all characters from j+1 to end
        String next = new String(charArr);
        StringBuilder sub = new StringBuilder(next.substring(j+1));
        sub = sub.reverse();
        return Integer.parseInt(next.substring(0, j+1) + sub.toString());
    }
}
