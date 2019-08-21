import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine whether any permutation of it is a palindrome.
 */
public class DailyCoding157 {
    public static void main(String[] args) {
        System.out.println(isPermutationPalindrom("code"));
        System.out.println(isPermutationPalindrom("aab"));
        System.out.println(isPermutationPalindrom("carerac"));
    }
    public static boolean isPermutationPalindrom(String str) {
        Set<Character> characters = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (characters.contains(c)) {
                characters.remove(c);
            } else {
                characters.add(c);
            }
        }
        return characters.size() <= 1;
    }
}
