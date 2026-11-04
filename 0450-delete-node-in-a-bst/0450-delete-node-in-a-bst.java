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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left , key);
        }else{
            if(root.left == null && root.right ==  null){
                return null;
            }else if(root.right != null && root.left == null){
                return root.right;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else{
                int max = maxi(root.left);
                root.val = max;
                root.left = deleteNode(root.left,max);
            }
        }

        return root;
    }

    public static int maxi(TreeNode root){
        TreeNode cur = root;

        while(cur.right != null){
            cur = cur.right;
        }

        return cur.val;
    }
}