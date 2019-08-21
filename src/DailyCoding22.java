import java.util.*;

public class DailyCoding22 {
    public static void main(String[] args) {
        String[] dictinary1 = {"quick", "brown", "the", "fox"};
        String input1 = "thequickbrownfox";

        String[] dictinary2 = {"bed", "bath", "beyond", "bedbath", "and"};
        String input2 = "bedbathandbeyond";

        //Test(dictinary1, input1);
        //Test(dictinary2, input2);
        //Test(dictinary2, "bedbat");

        String[] dictionary3 = {"a", "abc", "b", "cd"};
        Test(dictionary3, "abcd");
    }
    public static List<String> breakIntoWords(String[] dictionary, String sentence){
        Set<String> dict = new HashSet<String>(Arrays.asList(dictionary));
        boolean[] dp = new boolean[sentence.length()+1];
        dp[0]=true;
        for(int i=1; i<=sentence.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && dict.contains(sentence.substring(j, i))){
                    dp[i] = true;
                    System.out.println("Setting true " + i);
                    break;
                }
            }
        }
        if (!dp[sentence.length()]){
            return null;
        }
        List<String> result = new ArrayList<>();

        int prev=0;
        for (int i=0; i<dp.length; i++){
            if (dp[i]){
                result.add(sentence.substring(prev, i));
                prev = i;
            }
        }
        return result;
    }



    public static void Test(String[] dictionary, String sentence){
        List<String> result = breakIntoWords(dictionary, sentence);
        if (result==null){
            System.out.println("Reconstruction not possible");
        } else {
            for (int i=0; i<result.size();i++){
                System.out.print(result.get(i)+" ");
            }
            System.out.println("");
        }
    }
}
