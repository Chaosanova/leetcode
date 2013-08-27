class Solution { 
    //Path Sum
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return false;
        }else{
            if(root.left == null && root.right == null){
                return root.val == sum;
            }
        
            if(root.left != null && root.right != null){
                return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
            }else if(root.left != null){
                return hasPathSum(root.left, sum - root.val);
            }else{
                return hasPathSum(root.right, sum - root.val);
            }
        }
    }
}
