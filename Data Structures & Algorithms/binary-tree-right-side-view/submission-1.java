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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    void dfs(List<Integer> res, TreeNode curr, int index) {

        if (curr == null) {
            return;
        }

        if (res.size() == index) {
            res.add(curr.val);
        }

        // give priority to right node
        dfs(res, curr.right, index+1);
        dfs(res, curr.left, index+1);
    }
}
