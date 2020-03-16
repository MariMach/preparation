import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    // root node
    // children
    // insert O(l)
    // delete O(l)
    // remove O(l)
    // lookup O(l)
    // l length of the word

    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char val;

        // 26 character in english
        // stored in index = val - 'a'
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "val :" + val;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public boolean noChildren() {
            return children.isEmpty();
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) {
            return false;
        }
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    // pre order traversal
    // post order traversal

    public void traverse() {
        traversePre(root);
        // traversePost(root);
    }

    private void traversePre(Node root) {
        System.out.println(root.val);
        for (Node child : root.getChildren()) {
            traversePre(child);
        }
    }

    private void traversePost(Node root) {
        for (Node child : root.getChildren()) {
            traversePre(child);
        }
        System.out.println(root.val);
    }

    public void remove(String word) {
        if (word == null) {
            return;
        }
        remove(root, word, 0);
    }

    public void remove(Node root, String word, int index) {
        if (index == word.length()) {
            System.out.println(root.val);
            return;
        }
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null) {
            return;
        }
        remove(child, word, index + 1);
        if (child.noChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList();
        Node lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null) {
            return;
        }

        if (root.isEndOfWord) {
            words.add(prefix);
        }
        for (Node child : root.getChildren()) {
            findWords(child, prefix + child.val, words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null) {
            return null;
        }
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }

}