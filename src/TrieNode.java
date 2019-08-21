public class TrieNode{
    private boolean isWord;
    private TrieNode[] children;
    public TrieNode(){
        this.isWord = false;
        children = new TrieNode[26];
    }
    public TrieNode getChild(int i){
        return this.children[i];
    }
    public void setChild(int i, TrieNode node){
        this.children[i] = node;
    }
    public void setIsWord(boolean isWord){
        this.isWord = isWord;
    }

    public boolean isWord() {
        return isWord;
    }
}