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
    public boolean isValidBST(TreeNode root) {
        return isValidTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean isValidTree(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        return (root.val > min && root.val < max) 
                && isValidTree(root.left, min, Math.min(max, root.val))
                && isValidTree(root.right, Math.max(min, root.val), max);        
    }
}
