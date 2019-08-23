/**
 * Spreadsheets often use this alphabetical encoding for its columns: "A", "B", "C", ..., "AA", "AB", ..., "ZZ",
 * "AAA", "AAB", ....
 *
 * Given a column number, return its alphabetical column id. For example, given 1, return "A". Given 27, return "AA".
 */
public class DailyCoding212 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB") == 28);
        System.out.println(titleToNumber("ZY") == 701);
    }
    public static int titleToNumber(String s) {
        int n = s.length();
        int count = countColumnsBefore(n-1);
        return count + countColumns(s, n, 0)+1;
    }
    public static int countColumnsBefore(int n){
        if(n==0){
            return 0;
        }
        return (int)Math.pow(26, n) + countColumnsBefore(n-1);
    }
    public static int countColumns(String s, int n, int index){
        if(n==0){
            return 0;
        }
        int i = s.charAt(index)-'A';
        return i*(int)Math.pow(26, n-1) + countColumns(s, n-1, index+1);
    }
}
