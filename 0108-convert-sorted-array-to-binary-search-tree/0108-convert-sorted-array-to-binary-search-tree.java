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
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length - 1;
         
        return solve(nums, 0 , length);
    }

    public TreeNode solve(int[] nums, int s , int e){
        if(s > e) return null;

        int mid = (s+e)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = solve(nums, s, mid-1);
        root.right = solve(nums, mid + 1, e);

        return root;
    }
}