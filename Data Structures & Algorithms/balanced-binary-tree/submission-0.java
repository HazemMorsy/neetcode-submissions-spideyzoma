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
    public boolean isBalanced(TreeNode root) {
        return balance(root)[0] == 0 ? false : true;  
    }

    // first entry for balance & the second one for height
    private int[] balance(TreeNode root) {
        if (root == null) {
            return new int[] {1, 0};
        }

        int [] leftArr = balance(root.left);
        int [] rightArr = balance(root.right);

        if (leftArr[0] == 0 || rightArr[0] == 0 || Math.abs(leftArr[1] - rightArr[1]) > 1) {
            return new int[] {0, Math.max(leftArr[1], rightArr[1]) + 1};
        } else {
            return new int[] {1, Math.max(leftArr[1], rightArr[1]) + 1};
        }
    }
}
