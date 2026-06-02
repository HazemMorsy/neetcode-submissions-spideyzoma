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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode newRoot = new TreeNode(preorder[0]);
        int idx = getIdx(inorder, preorder[0]);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, idx + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
        newRoot.left = buildTree(leftPreorder, leftInorder);
        int[] rightPreorder = Arrays.copyOfRange(preorder, idx + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        newRoot.right = buildTree(rightPreorder, rightInorder);
        return newRoot;
    }


    private int getIdx(int[] inorder, int target) {
        for (int i = 0;i < inorder.length;i++) {
            if (inorder[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
