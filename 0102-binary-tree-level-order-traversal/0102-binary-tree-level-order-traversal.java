import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }
        
        // Initialize a queue to store nodes for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            
            // Process all nodes belonging to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.val);
                
                // Queue the left child if it exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                // Queue the right child if it exists
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
            // Add the populated level list to our final result
            result.add(currentLevelList);
        }
        
        return result;
    }
}