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
    int count = 0;
    int ans = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = ans = Integer.MAX_VALUE;

        find(root,k);

        return ans;
    }

    private void find(TreeNode root, int k){
        if(root == null){
            return;
        }

        if(ans == Integer.MAX_VALUE) find(root.left,k);

        count += 1;

        if(count == k){
            ans = root.val;
            return;
        }

        if(ans == Integer.MAX_VALUE) find(root.right , k);
    }
}