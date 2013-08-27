/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        
        return mirrorSame(root.left, root.right);
    }
    
    private boolean mirrorSame(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null) return true;
        else if(leftNode != null && rightNode != null) return (leftNode.val == rightNode.val) && mirrorSame(leftNode.left, rightNode.right) && mirrorSame(leftNode.right, rightNode.left); 
        else return false;
    }
}
