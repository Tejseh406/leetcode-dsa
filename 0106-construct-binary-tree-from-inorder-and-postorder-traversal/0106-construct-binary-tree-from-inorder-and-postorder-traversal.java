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
    Map<Integer,Integer> hm = new HashMap<>();
    int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }

        postIndex = postorder.length-1;

        return build(postorder,0, inorder.length-1);
    }

    private TreeNode build(int[] postOrder, int left, int right){
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postIndex--]);
        int inIndex = hm.get(root.val);

        root.right = build(postOrder,inIndex + 1, right);
        root.left = build(postOrder, left, inIndex-1);

        return root;
    }
}