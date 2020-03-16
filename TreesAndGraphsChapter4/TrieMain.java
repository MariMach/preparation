import java.util.List;

public class TrieMain {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("can");
        trie.insert("sal");
        trie.insert("car");
        trie.insert("care");
        trie.remove("cares");
        System.out.println(trie.contains("care"));
        List<String> words = trie.findWords("car");
        System.out.println(words);
    }
}