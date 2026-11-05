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
       return checkBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean checkBst(TreeNode root , long s , long e){
        if(root == null){
            return true;
        }

        if(root.val > s && root.val < e){
            boolean l = checkBst(root.left, s, root.val);
            boolean r = checkBst(root.right, root.val, e);

            return l && r;
        }

        return false;
    }
}