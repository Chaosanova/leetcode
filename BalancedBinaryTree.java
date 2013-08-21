/*
Original time exceeded version
@author Chao Zhang

     public static boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        //For the result tested
        if(getDepth(root) == -1) return false;
        else return true;
    }
    
    public static int getDepth(TreeNode root){
        //For leaves, return the depth 0
        if(root.left == null && root.right == null) {
	    return 0;
	}else if(root.left != null && root.right != null){
            if(getDepth(root.left) == -1 || getDepth(root.right) == -1) return -1;
            if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return -1;
            else return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }else if(root.left != null){
        	if(getDepth(root.left) >= 1 || getDepth(root.left) == -1) return -1;
        	else return getDepth(root.left) + 1;
        }else{
        	if(getDepth(root.right) >= 1 || getDepth(root.right) == -1) return -1;
        	else return getDepth(root.right) + 1;
        }
    }
     
*/

public class Solution {

    public boolean isBalanced(TreeNode root) {
	if (root == null) return true;

	int left = getHeight(root.left);
	int right = getHeight(root.right);
	if (Math.abs(left - right) > 1) return false;

	return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode n) {
	if (n == null) return 0;

	return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }
}

