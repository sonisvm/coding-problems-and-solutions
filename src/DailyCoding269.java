/**
 * You are given an string representing the initial conditions of some dominoes. Each element can take one of three
 * values:
 *
 * L, meaning the domino has just been pushed to the left,
 * R, meaning the domino has just been pushed to the right, or
 * ., meaning the domino is standing still.
 * Determine the orientation of each tile when the dominoes stop falling. Note that if a domino receives a force
 * from the left and right side simultaneously, it will remain upright.
 *
 * For example, given the string .L.R....L, you should return LL.RRRLLL.
 *
 * Given the string ..R...L.L, you should return ..RR.LLLL.
 */
public class DailyCoding269 {
    public static void main(String[] args) {
        System.out.println(pushDominoes(".L.R...LR..L..").equals("LL.RR.LLRRLL.."));
        System.out.println(pushDominoes(".L.R....L").equals("LL.RRRLLL"));
        System.out.println(pushDominoes("..R...L.L").equals("..RR.LLLL"));
    }
    public static String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int n = chars.length;
        int i=0;
        while(i<n){
            //System.out.println(i);
            if(chars[i]=='R') {
                while(i<n && chars[i]=='R'){
                    i++;
                }
                //System.out.println(i);
                if(i==n){
                    break;
                }
                //find the next char
                int j = i;
                while(j<n && chars[j]=='.'){
                    j++;
                }
                if(j==n) {
                    //no L/R
                    fill(chars, i, n, 'R');
                    break;
                }
                if(chars[j]=='R') {
                    // System.out.println(i);
                    fill(chars, i, j, 'R');
                    i=j;
                } else {
                    int count = j-i;
                    fill(chars, i, i+count/2, 'R');
                    fill(chars, j-count/2, j, 'L');
                    i = j+1;
                }


            } else if(chars[i]=='L'){
                int j = i-1;
                while(j >= 0 && chars[j]=='.'){
                    j--;
                }
                if(j >=0 && chars[j]=='R'){
                    i++;
                    continue;
                }
                fill(chars, j+1, i, 'L');
                while(i<n && chars[i]=='L'){
                    i++;
                }
            } else {
                i++;
            }
        }
        return new String(chars);
    }
    public static void fill(char[] chars, int start, int end, char c) {
        for(int i=start; i<end; i++) {
            chars[i] = c;
        }
    }
}
