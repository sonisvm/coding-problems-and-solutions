/**
 * Write a program that checks whether an integer is a palindrome. For example, 121 is a palindrome,
 * as well as 888. 678 is not a palindrome. Do not convert the integer into a string.
 */
public class DailyCoding202 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(888));
        System.out.println(isPalindrome(678));
    }
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            //since it has a sign, it cannot be a palindrome
            return false;
        }
        int num = 0;
        int m = x;
        while(m != 0) {
            int d = m%10;
            num = num*10 + d;
            m = m/10;
        }
        return num==x;
    }
}
