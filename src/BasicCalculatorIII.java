import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode question
 */

public class BasicCalculatorIII {
    public static void main(String[] args) {
        System.out.println(calculate("1 + 1")==2);
        System.out.println(calculate(" 6-4 / 2 ")==4);
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")==21);
        System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")==-12);
        System.out.println(calculate("1-(-7)")==8);
    }
    public static int calculate(String s) {
        Deque<Long> operands = new ArrayDeque<>();
        Deque<Integer> signs = new ArrayDeque<>();
        //1 for +, -1 for -, 2 for * and  3 for /

        int sign = 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                long num = 0l;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                long res = operate(operands, sign, num);
                operands.push(res);
            } else if(c=='+') {
                sign = 1;
            } else if(c=='-') {
                sign = -1;
            } else if(c=='*') {
                sign = 2;
            } else if(c=='/') {
                sign = 3;
            } else if(c=='(') {
                signs.push(sign);
                operands.push(Long.MAX_VALUE);
                sign = 1;
            } else if(c==')') {
                long sum = 0;
                while(!operands.isEmpty() && operands.peek()!=Long.MAX_VALUE) {
                    sum += operands.pop();
                }
                sign = signs.pop();
                operands.pop();
                long res = operate(operands, sign, sum);
                operands.push(res);
            }
        }
        int sum = 0;
        while (!operands.isEmpty()) {
            sum += operands.pop().intValue();
        }

        return sum;
    }
    public static long operate(Deque<Long> operands, int sign, long num) {
        if(sign == 1) {
            return num;
        } else if(sign == -1) {
            return -num;
        } else if(sign == 2) {
            return operands.pop() * num;
        } else {
            return operands.pop()/num;
        }
    }
}
