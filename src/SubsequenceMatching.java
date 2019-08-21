class Trie{
    Trie[] children;
    boolean isWord;
    int length;
    Trie(){
        this.children = new Trie[26];
        this.isWord = false;
        this.length = 0;
    }
}
public class SubsequenceMatching {
    public static void main(String[] args) {
        String str = "abpplee";
        String[] dictionary = {"able", "ale", "apple", "bale", "kangaroo"};

        System.out.println(findLongestString(str, dictionary));
    }
    public static String findLongestString(String str, String[] dictionary){
        Trie root = new Trie();

        addToTrie(root, str);

        //printTrie(root);

        String maxStr="";
        int maxLen=0;

        for (int i=0; i < dictionary.length; i++){
            if (isSubsequence(root, dictionary[i], 0)){
                if (dictionary[i].length() > maxLen){
                    maxLen = dictionary[i].length();
                    maxStr = dictionary[i];
                }
            }
        }

        return maxStr;
    }

    public static boolean isSubsequence(Trie root, String str, int index){
        Trie temp = root;
        if (index==str.length()-1){
            return true;
        }
        if(temp!=null){
            char c = str.charAt(index);
            if (temp.children[c-'a']!=null){
                index++;
            }
            for (int j=0; j<26; j++){
                if (temp.children[j]!=null){
                    return isSubsequence(temp.children[j], str, index);
                }
            }
        }
        return false;
    }

    public static void addToTrie(Trie node, String str){
        int i=0;
        Trie temp = node;
        while (i < str.length()){
            char c = str.charAt(i);
            if (temp.children[c-'a']==null){
                temp.children[c-'a'] = new Trie();
            }
            if(i==str.length()-1){
                temp.isWord = true;
                temp.length = str.length();
                break;
            }
            temp = temp.children[c-'a'];
            i++;
        }
    }
    public static void printTrie(Trie root){
        if (root==null){
            return;
        }
        for (int i=0; i<26; i++){
            if (root.children[i]!=null){
                char c = (char)('a' + i);
                System.out.print(c);
                printTrie(root.children[i]);
            }
        }
    }
}
