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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length == 0) return null;
        
        int lengthIndex = num.length - 1;
        int rootVal = num[lengthIndex/2];
        TreeNode root = new TreeNode(rootVal);
        
        if(lengthIndex == 1){
            root.right = new TreeNode(num[lengthIndex]);
        }
        
        if(lengthIndex > 1){
            root.left = genTree(0, lengthIndex/2 - 1, num);
            root.right = genTree(lengthIndex/2 + 1, lengthIndex, num);
        }
        return root;
    }
    
    private TreeNode genTree(int start, int end, int[] num){
        if(start > end) return null; 
        else if(start == end) return new TreeNode(num[start]);
        else if(start == end - 1){
            TreeNode mediumNode = new TreeNode(num[start]);
            mediumNode.right = genTree(end, end, num);
            return mediumNode;
        }
        else{
            TreeNode mediumNode = new TreeNode(num[(start + end)/2]);
            mediumNode.left = genTree(start, (start + end)/2 - 1, num);
            mediumNode.right = genTree((start + end)/2 + 1, end, num);
            return mediumNode;
        }
    }
}
