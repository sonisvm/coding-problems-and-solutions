import java.util.*;

class Tuple {
    String word;
    List<String> path;
    public Tuple(String word) {
        this.word = word;
        this.path = new ArrayList<>();
    }
    public void add(String word) {
        this.path.add(word);
    }
    public int dist() {
        return this.path.size();
    }
}

public class WordLadderII {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        List<List<String>> result = findLadders("hit", "cog", wordList);

        for(List<String> list : result) {
            for(String s : list) {
                System.out.print(s+", ");
            }
            System.out.println();
        }

    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        HashSet<String> seen = new HashSet<>();

        wordList.add(beginWord);

        HashMap<String, List<String>> combos = new HashMap<>();

        for(String s : wordList) {
            dict.add(s);
            for(int i=0; i<s.length(); i++) {
                String combo = s.substring(0, i) + "*" + s.substring(i+1);
                List<String> words = combos.getOrDefault(combo, new ArrayList<>());
                words.add(s);
                combos.put(combo, words);
            }
        }

        if(!dict.contains(endWord)) {
           return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();

        Deque<Tuple> q = new ArrayDeque<>();
        Tuple st = new Tuple(beginWord);
        st.add(beginWord);
        q.add(st);

        int minDist = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            seen.add(t.word);
            if(t.word.equals(endWord)) {
                if(t.dist() <= minDist) {
                    minDist = t.dist();
                    result.add(t.path);
                }
                continue;
            }
            List<String> nextWords = getAllNextWords(combos, t.word);
            for(String next : nextWords) {
                System.out.println(next);
                if(!seen.contains(next)) {
                    Tuple nt = new Tuple(next);
                    nt.path.addAll(t.path);
                    nt.add(next);
                    q.add(nt);
                }
            }

        }
        return result;
    }

    public static List<String> getAllNextWords(HashMap<String, List<String>> combos, String word) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<word.length(); i++) {
            String combo = word.substring(0, i) + "*" + word.substring(i+1);
            if(combos.containsKey(combo)) {
                result.addAll(combos.get(combo));
            }
        }
        return result;
    }
}
