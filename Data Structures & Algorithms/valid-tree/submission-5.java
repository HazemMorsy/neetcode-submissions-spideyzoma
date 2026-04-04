class Solution {
    public boolean validTree(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean isCyclic = dfs(adjList, 0, -1, visited);

        int connections = 0;
        for (boolean isVisited : visited) {
            if (isVisited) {
                connections++;
            }
        }

        return isCyclic && connections == n; // check if the graph is connected
        
    }


    boolean dfs(List<List<Integer>> adjList, int currNode, int parentNode, boolean[] visited) { // detect cycles
        if (visited[currNode]) {
            return false;
        }

        visited[currNode] = true;
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
