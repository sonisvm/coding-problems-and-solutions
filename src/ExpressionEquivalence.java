import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Check if two expressions are equivalent
 *
 * -(a+b+c) is same as -a-b-c
 * -(c+b+a) is same as -c-b-a
 * a-b-(c-d) is not same as a-b-c-d
 *
 * Each operand appears only once. Operands are lower case variables a-z.
 * Operators will be only + or -
 */
public class ExpressionEquivalence {
    public static void main(String[] args) {
        System.out.println(equals("-(a+b+c)", "-a-b-c"));
        System.out.println(equals("a-b-(c-d)", "a-b-c-d"));
        System.out.println(equals("a+((b)+(c))", "((b+c)+a)"));
    }
    public static boolean equals(String exp1, String exp2) {
        Deque<Integer> stack = new ArrayDeque<>(); // 1 for +, -1 for -

        int sign = 1;
        int[] count = new int[26];
        for(char c : exp1.toCharArray()) {
            if (c=='+') {
                sign = 1;
            } else if (c=='-') {
                sign = -1;
            } else if (c=='(') {
                stack.push(sign);
                sign = 1;
            } else if (c==')') {
                sign = stack.pop();
            } else {
                int global = 1;
                if (!stack.isEmpty()) {
                    global = stack.peek();
                }
                count[c-'a'] += sign * global;
            }
        }
        sign = 1;
        for (char c : exp2.toCharArray()) {
            if (c=='+') {
                sign = 1;
            } else if (c=='-') {
                sign = -1;
            } else if (c=='(') {
                stack.push(sign);
                sign = 1;
            } else if (c==')') {
                sign = stack.pop();
            } else {
                int global = 1;
                if (!stack.isEmpty()) {
                    global = stack.peek();
                }
                count[c-'a'] -= sign*global;
            }
        }

        for (int n: count) {
            if (n!=0) {
                return false;
            }
        }
        return true;
    }
}
