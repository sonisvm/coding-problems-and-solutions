import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not
 * case sensitive.  The answer is in lowercase.
 */
public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}).equals("ball"));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String s : banned) {
            bannedWords.add(s);
        }
        StringBuilder word = new StringBuilder();
        int maxCount = 0;
        String maxWord="";
        for (char c: paragraph.toCharArray()) {
            if(Character.isLetter(c)) {
                word.append(c);
            } else if(word.length() > 0) {
                String str = word.toString().toLowerCase();
                if(!bannedWords.contains(str)){
                    int ct = wordCount.getOrDefault(str, 0);
                    wordCount.put(str, ct+1);
                    if(ct+1 > maxCount){
                        maxCount = ct+1;
                        maxWord = str;
                    }
                }
                word = new StringBuilder();
            }
        }
        String str = word.toString().toLowerCase();
        if(!bannedWords.contains(str)){
            int ct = wordCount.getOrDefault(str, 0);
            wordCount.put(str, ct+1);
            if(ct+1 > maxCount){
                maxCount = ct+1;
                maxWord = str;
            }
        }

        return maxWord;
    }
}

