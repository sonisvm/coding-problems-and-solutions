/**
 * Given a string str consisting of parentheses (, ) and alphanumeric characters. Remove minimum number
 * of paranthesis to make the string valid and return any valid result. In a valid string for every
 * opening/closing parentheses there is a matching closing/opening one.
 */
public class MinimumRemoveParenthesis {
    public static void main(String[] args) {
        System.out.println(minimumRemove("ab(a(c)fg)9)"));
    }
    public static String minimumRemove(String str) {
        StringBuilder s = new StringBuilder();
        int open =0;
        //remove closing parenthesis which don;t match
        for (int i=0; i<str.length();i++) {
            if (str.charAt(i)=='(') {
                open++;
                s.append(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                    s.append(str.charAt(i));
                }
            } else {
                s.append(str.charAt(i));
            }
        }
        open = 0;
        for (int i=s.length()-1; i>=0;i--) {
            if (s.charAt(i)=='(') {
                if(open >= 0) {
                    s.deleteCharAt(i);
                } else {
                    open++;
                }

            } else if (s.charAt(i) == ')') {
                open--;
            }
        }
        return s.toString();
    }
}
