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
    public int goodNodes(TreeNode root) {
        return getGood(root, Integer.MIN_VALUE);
    }


    private int getGood(TreeNode root, int currMax) {
        if (root == null) {
            return 0;
        }

        if (root.val >= currMax) {
            return 1 + getGood(root.left, root.val) + getGood(root.right, root.val);
        } else {
            return getGood(root.left, currMax) + getGood(root.right, currMax);
        }

    }
}
