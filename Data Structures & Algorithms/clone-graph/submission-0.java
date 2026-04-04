/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> cloneMap = new HashMap<>();

        return dfs(node, cloneMap);
    }


    Node dfs(Node node, HashMap<Node,Node> cloneMap) {
        if (node == null) {
            return null;
        }

        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }

        Node newNode = new Node(node.val);
        cloneMap.put(node, newNode);

        for (Node currNode : node.neighbors) {
            newNode.neighbors.add(dfs(currNode, cloneMap));
        }

        return newNode;


    }
}