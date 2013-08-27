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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        else if(root.left == null) return checkBST(root.right, root.val, Integer.MAX_VALUE) && root.val < root.right.val;
        else if(root.right == null) return checkBST(root.left, Integer.MIN_VALUE, root.val) && root.val > root.left.val;
        else return checkBST(root.left,Integer.MIN_VALUE, root.val) && 
                    checkBST(root.right,root.val, Integer.MAX_VALUE)&&
                    root.val < root.right.val &&
                    root.val > root.left.val;
    }
    
    private boolean checkBST(TreeNode root, int lower, int upper){
        if(root.val <= lower || root.val >= upper) return false;
        else if(root.left == null && root.right == null) return true;
        else if(root.left == null) {
            if(root.val >= root.right.val) return false;
            else return checkBST(root.right, root.val, upper);
        }else if(root.right == null){
            if(root.val <= root.left.val) return false;
            else return checkBST(root.left, lower, root.val);
        }else{
            if(root.val >= root.right.val || root.val <= root.left.val) return false; 
            else return checkBST(root.right, root.val, upper) && 
                        checkBST(root.left, lower, root.val);
        }
    }
}
