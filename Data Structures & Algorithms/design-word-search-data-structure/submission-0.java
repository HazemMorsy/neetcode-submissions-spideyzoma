class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            HashMap<Character, TrieNode> childrenMap = curr.children;

            if (childrenMap.containsKey(c)) {
                curr = childrenMap.get(c);
            } else {
                curr = new TrieNode();
                childrenMap.put(c, curr);
            }
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {

        return dfs(0, word, root);
    }

    private boolean dfs(int idx, String word, TrieNode currNode) {
        TrieNode curr = currNode;
        for (int i=idx;i<word.length();i++) {
            if (word.charAt(i) == '.') {
                for (TrieNode treeNode : curr.children.values()) {
                    if (dfs(i+1, word, treeNode)) {
                        return true;
                    }
                }
                return false;

            } else {
                if (curr.children.containsKey(word.charAt(i))) {
                    curr = curr.children.get(word.charAt(i));
                }
                else {
                    return false;
                }
                
            }
        }
        return curr.endOfWord;
    }


    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean endOfWord = false;
    }
}
