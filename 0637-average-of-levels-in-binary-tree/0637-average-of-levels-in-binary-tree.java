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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            double sum =0;

            for(int i = 0;i<size;i++){
                TreeNode cur = q.remove();

                    sum += cur.val;

                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
            }

            res.add((double) (sum / size));
        }

        return res;
    }
}