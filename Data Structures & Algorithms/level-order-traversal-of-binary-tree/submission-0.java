/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, TreeNode curr, int index) {

        if (curr == null) {
            return;
        }

        if (index ==res.size()) {
            res.add(new ArrayList<>(Arrays.asList(curr.val)));
        } else {
            res.get(index).add(curr.val);
        }

        dfs(res, curr.left, index+1);
        dfs(res, curr.right, index+1);
    }
}
