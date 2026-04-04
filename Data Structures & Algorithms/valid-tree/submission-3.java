class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n==0) return true;

        HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean isCyclic = dfs(adjList, 0, -1, visited);

        return isCyclic && visited.size() == n; // check if the graph is connected
        
    }


    boolean dfs(List<List<Integer>> adjList, int currNode, int parentNode, HashSet<Integer> visited) { // detect cycles
        if (visited.contains(currNode)) {
            return false;
        }

        visited.add(currNode);
        for (int node: adjList.get(currNode)) {
            if (node == parentNode) {
                continue;
            }

            if (!dfs(adjList, node, currNode, visited)) {
                return false;
            }
        }

        return true;
    }
}
