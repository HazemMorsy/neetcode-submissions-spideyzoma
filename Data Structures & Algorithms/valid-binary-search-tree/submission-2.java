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
        if (root == null) {
            return true;
        }

        return allLess(root.left, root.val) && allGreater(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean allLess(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        return root.val < val && allLess(root.left, val) && allLess(root.right, val);
    }

    private boolean allGreater(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        return root.val > val && allGreater(root.left, val) && allGreater(root.right, val);
    }
}
