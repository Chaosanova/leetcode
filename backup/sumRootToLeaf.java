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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        
        return sumByLevel(root, 0);
    }
    
    private int sumByLevel(TreeNode root, int upperValue){
        int currSum = root.val + 10 * upperValue;
        if(root.left == null && root.right == null) return currSum;
        else if(root.left == null && root.right != null) return sumByLevel(root.right, currSum);
        else if(root.left != null && root.right == null) return sumByLevel(root.left, currSum);
        else return sumByLevel(root.left, currSum) + sumByLevel(root.right, currSum);
    }
}
