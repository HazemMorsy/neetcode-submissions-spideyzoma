class PrefixTree {
    TrieNode mainNode;

    public PrefixTree() {
        mainNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = mainNode;
        for (char c : word.toCharArray()) {
            HashMap<Character, TrieNode> children = curr.children;
            if (children.containsKey(c)) {
                curr = children.get(c);
            } else {
                curr = new TrieNode();
                children.put(c, curr);
            }
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = mainNode;
        for (char c : word.toCharArray()) {
            HashMap<Character, TrieNode> children = curr.children;
            if (children.containsKey(c)) {
                curr = children.get(c);
            } else {
                return false;
            }
        }
         return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = mainNode;
        for (char c : prefix.toCharArray()) {
            HashMap<Character, TrieNode> children = curr.children;
            if (children.containsKey(c)) {
                curr = children.get(c);
            } else {
                return false;
            }
        }
         return true;
    }


    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean endOfWord = false;
    }
}
