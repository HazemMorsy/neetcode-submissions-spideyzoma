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
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            Queue<TreeNode> tempQ = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode curr = q.peek();
                list.add(curr.val);
                if (curr.left != null) {
                    tempQ.add(curr.left);
                }
                if (curr.right != null) {
                    tempQ.add(curr.right);
                }
                q.poll();
                
            }

            res.add(list);

            q.addAll(tempQ);
        }

        return res;
    }
}
