/**
 * Given a string of parentheses, find the balanced string that can be produced from it using the minimum number of
 * insertions and deletions. If there are multiple solutions, return any of them.
 *
 * For example, given "(()", you could return "(())". Given "))()(", you could return "()()()()".
 */
public class DailyCoding199 {
    public static void main(String[] args) {
        System.out.println(minimalBalancedString("(()"));
        System.out.println(minimalBalancedString("))()("));
    }
    public static String minimalBalancedString(String str) {
        StringBuilder balanced = new StringBuilder();
        int open=0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                open++;
                balanced.append('(');
            } else if(open == 0) {
                balanced.append("(");
                balanced.append(")");
            } else {
                open--;
                balanced.append(")");
            }
        }
        while(open!=0) {
            balanced.append(")");
            open--;
        }
        return balanced.toString();
    }
}
